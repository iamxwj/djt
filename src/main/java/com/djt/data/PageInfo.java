package com.djt.data;

import com.djt.domain.es.InstitutionDocument;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;

/**
 * @author Zhipeng
 * @date 2016/8/23.
 */
public class PageInfo<T> {
    private int pageSize ; //每页显示多少条记录
    private int totalPages;
    private Long totalElements;
    private int nowPage;
    private List<T> content;

    public PageInfo() {
    }

    public PageInfo(PageInfo pageInfo) {
        this.nowPage = pageInfo.getNowPage();
        this.pageSize = pageInfo.getPageSize();
        this.totalPages = pageInfo.getTotalPages();
        this.totalElements = pageInfo.getTotalElements();
    }

    public PageInfo(int nowPage, int pageSize, int totalPages, Long totalElements, List<T> content) {
        this.nowPage = nowPage;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.content = content;
    }
    public PageInfo(int nowPage, int pageSize, int totalPages, Long totalElements) {
        this.nowPage = nowPage;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                ", totalElements=" + totalElements +
                ", nowPage=" + nowPage +
                ", content=" + content +
                '}';
    }
}
