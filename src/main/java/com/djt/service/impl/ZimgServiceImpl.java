/*
 * @(#)ZimgServiceImpl.java, 2016/2/29.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.djt.service.impl;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.util.StringUtils;
import com.djt.data.ResponseData;
import com.djt.data.zimg.ZimgResult;
import com.djt.service.ZimgService;
import com.djt.utils.ConfigUtils;
import com.djt.utils.URLUtils;
import com.djt.utils.document.QiNiuUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * ZimgServiceImpl
 *
 * @author chenbin
 * @date 2016/2/29
 */
@Service
public class ZimgServiceImpl implements ZimgService {
    private static Logger logger = Logger.getLogger(ZimgServiceImpl.class);

    public static String zimgUrl = ConfigUtils.getProperty("server.image");
    public static String tmpPath = ConfigUtils.getProperty("image.tmpPath");

    /**
     * 从页面提交图片，上传到zimg
     *
     * @param request
     * @return
     */
    @Override
    public ResponseData uploadImgToZimg(HttpServletRequest request) {
        MultipartHttpServletRequest mhs = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> files = mhs.getFileMap();
        File directory = new File(tmpPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        for (String file : files.keySet()) {
            // 上传到图片服务器
            MultipartFile f = files.get(file);
            if (f.getSize() == 0)
                return new ResponseData(false, "file size is 0", null);
            String tmpFileName = tmpPath + "/" + f.getOriginalFilename();
            File tmp = new File(tmpPath);
            tmp = new File(tmpFileName);
            try {
                f.transferTo(tmp);
            } catch (Exception e) {
                e.printStackTrace();
            }

            ZimgResult ret = uploadImg(tmpFileName);
            String url = URLUtils.getZimgUrl(ret.getInfo().getMd5());

            // 删除文件
            if (tmp != null) {
                tmp.setWritable(true);
                System.gc();
                tmp.delete();
            }

            return new ResponseData(true, "success", url);
        }

        return new ResponseData(false, "fail", "");
    }

    /**
     * 获取下载地址
     */
    public ResponseData getDownloadAddress(String fileName) {
        try {
            String string = QiNiuUtil.privateDownload(fileName);
            return new ResponseData(true, "success", string);
        } catch (Exception e) {
            return new ResponseData(false, "fail", null);
        }

    }


    /**
     * 指定文件名，上传到zimg
     *
     * @param fileName
     * @return
     */
    public ZimgResult uploadImg(String fileName) {
        String ext = "jpeg";
        int inx = fileName.lastIndexOf(".");
        if (inx > 0)
            ext = fileName.substring(inx + 1);
        String resp = send(zimgUrl + "upload", fileName, ext);
        return new Gson().fromJson(resp, ZimgResult.class);
    }

    /**
     * 将图片文件上传到zimg服务器
     *
     * @param url
     * @param fileName
     * @param ext
     * @return
     */
    protected String send(String url, String fileName, String ext) {

        if (ext.toLowerCase().compareTo("jpg") == 0)
            ext = "jpeg";
        String respXML = "";
        try {
            // 获得connection对象
            logger.debug("zimg server url:" + url);
            URL ul = new URL(url);
            URLConnection connection = ul.openConnection();
            connection.setReadTimeout(50000);
            connection.setConnectTimeout(25000);
            HttpURLConnection uc = (HttpURLConnection) connection;

            // 设置HTTP协议的消息头
            logger.debug("zimg set header");
            uc.setRequestMethod("POST");
            uc.setRequestProperty("Connection", "Keep-Alive");
            uc.setRequestProperty("Cache-Control", "no-cache");
            uc.setRequestProperty("Content-Type", ext.toLowerCase());// "jpeg");//
            uc.setRequestProperty("COOKIE", "william");
            uc.setDoOutput(true);
            uc.setDoInput(true);

            logger.debug("zimg connect server.");
            // 与建立服务器连接
            uc.connect();
            // 设置传输模式为二进制
            logger.debug("zimg upload image in binary.");
            OutputStream om = uc.getOutputStream();
            // 循环读取图片，发送到zimg服务器
            FileInputStream in = new FileInputStream(fileName);
            byte[] buf = new byte[8192];
            while (true) {
                int len = in.read(buf);
                if (len <= 0)
                    break;
                om.write(buf, 0, len);
            }

            // 到开输入（返回信息）流
            InputStreamReader im = new InputStreamReader(uc.getInputStream(),
                    "UTF-8");
            // 循环读取，知道结束，获取返回信息
            logger.debug("zimg get response text.");
            char[] bb = new char[8192];
            while (true) {
                int length = im.read(bb);
                if (length == -1)
                    break;
                char[] bc = new char[length];
                for (int i = 0; i < length; i++)
                    bc[i] = bb[i];
                respXML += new String(bc);
            }
            logger.debug("zimg response:" + respXML);
            // 关闭上下行
            im.close();
            uc.disconnect();
        } catch (Exception e) {
            logger.debug("zimg exception :" + e.getMessage());
            e.printStackTrace();
        }

        return respXML;
    }

    //    /**
//     * 返货图片类型
//     *
//     * @param data
//     * @return
//     */
//    protected String getImageType(byte[] data) {
//        String type = null;
//        // Png test:
//        if (data[1] == 'P' && data[2] == 'N' && data[3] == 'G') {
//            type = "PNG";
//            return type;
//        }
//        // Gif test:
//        if (data[0] == 'G' && data[1] == 'I' && data[2] == 'F') {
//            type = "GIF";
//            return type;
//        }
//        // JPG test:
//        if (data[6] == 'J' && data[7] == 'F' && data[8] == 'I'
//                && data[9] == 'F') {
//            type = "JPG";
//            return type;
//        }
//        return type;
//    }


    //    public ZimgResult uploadImgFromUrl(String url) {
//        String resp = this.SendFromUrl(url);
//        return new Gson().fromJson(resp, ZimgResult.class);
//    }
//
//    /**
//     * 从指定的URL下载图片并上传到zimg服务器
//     *
//     * @param imgUrl
//     * @return
//     */
//    protected String SendFromUrl(String imgUrl) {
//
//        // 设置文件类型默认值
//        String ext = "jpeg";
//        String respXML = "";
//        try {
//            // 获得connection对象
//            logger.debug("zimg server url:" + zimgUrl);
//            URL zimgUL = new URL(zimgUrl);
//            URLConnection zimgConnection = zimgUL.openConnection();
//            zimgConnection.setReadTimeout(50000);
//            zimgConnection.setConnectTimeout(25000);
//            HttpURLConnection zimgUC = (HttpURLConnection) zimgConnection;
//
//            // 设置HTTP协议的消息头
//            logger.debug("zimg set header");
//            zimgUC.setRequestMethod("POST");
//            zimgUC.setRequestProperty("Connection", "Keep-Alive");
//            zimgUC.setRequestProperty("Cache-Control", "no-cache");
//            zimgUC.setRequestProperty("Content-Type", ext.toLowerCase());// "jpeg");//
//            zimgUC.setRequestProperty("COOKIE", "william");
//            zimgUC.setDoOutput(true);
//            zimgUC.setDoInput(true);
//
//            logger.debug("zimg connect server.");
//            // 与建立服务器连接
//            zimgUC.connect();
//            // 设置传输模式为二进制
//            logger.debug("zimg upload image in binary.");
//            OutputStream om = zimgUC.getOutputStream();
//            // 循环读取图片，发送到zimg服务器
//
//            ext = this.writeImage(imgUrl, om);
//            logger.debug("image type=" + ext);
//            // byte[] buf = new byte[8192];
//            // while (true) {
//            // int len = in.read(buf);
//            // if (len <= 0)
//            // break;
//            // om.write(buf, 0, len);
//            // }
//
//            // 到开输入（返回信息）流
//            InputStreamReader im = new InputStreamReader(
//                    zimgUC.getInputStream(), "UTF-8");
//            // 循环读取，知道结束，获取返回信息
//            logger.debug("zimg get response text.");
//            char[] bb = new char[8192];
//            while (true) {
//                int length = im.read(bb);
//                if (length == -1)
//                    break;
//                char[] bc = new char[length];
//                for (int i = 0; i < length; i++)
//                    bc[i] = bb[i];
//                respXML += new String(bc);
//            }
//            logger.debug("zimg response:" + respXML);
//            // 关闭上下行
//            im.close();
//            zimgUC.disconnect();
//        } catch (Exception e) {
//            logger.debug("zimg exception :" + e.getMessage());
//            e.printStackTrace();
//        }
//
//        return respXML;
//
//    }

//    /**
//     * 获取URL的输入流
//     *
//     * @param imgUrl
//     * @return
//     */
//    private String writeImage(String imgUrl, OutputStream om) {
//        long totalBytes = 0;
//        String imgType = "jpeg";
//        try {
//            // 获得connection对象
//            URL imgUL = new URL(imgUrl);
//            URLConnection imgConnection = imgUL.openConnection();
//            imgConnection.setReadTimeout(50000);
//            imgConnection.setConnectTimeout(25000);
//            HttpURLConnection imgUC = (HttpURLConnection) imgConnection;
//
//            // 设置HTTP协议的消息头
//            logger.debug("set header");
//            imgUC.setRequestMethod("GET");
//            imgUC.setRequestProperty("Connection", "Keep-Alive");
//            imgUC.setRequestProperty("Cache-Control", "no-cache");
//            // imgUC.setRequestProperty("Content-Type", ext.toLowerCase());//
//            // "jpeg");//
//            imgUC.setRequestProperty("COOKIE", "GostLiu程序员老刘");
//            imgUC.setDoOutput(true);
//            imgUC.setDoInput(true);
//            InputStream in = imgUC.getInputStream();
//
//            byte[] buf = new byte[8192];
//            boolean GotType = false;
//            while (true) {
//                int len = in.read(buf);
//                if (len <= 0)
//                    break;
//                if (!GotType) {
//                    imgType = this.getImageType(buf);
//                    GotType = true;
//                }
//                totalBytes += len;
//                om.write(buf, 0, len);
//            }
//            in.close();
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return "";
//        }
//        if (totalBytes > 0)
//            return imgType;
//        else
//            return "";
//    }


}
