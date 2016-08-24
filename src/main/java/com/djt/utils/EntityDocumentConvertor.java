package com.djt.utils;

import com.djt.data.PageInfo;
import com.djt.domain.InstitutionInfoEntity;
import com.djt.domain.InstitutionMemberEntity;
import com.djt.domain.InvestorInfoEntity;
import com.djt.domain.es.InstitutionDocument;
import com.djt.domain.es.InvestorDocument;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhipeng
 * @date 2016/6/17.
 */
public class EntityDocumentConvertor {
    /**
     * render  InstitutionInfoEntity
     *
     * @param infoEntity
     * @return
     */
    public static InstitutionDocument renderInstitution(InstitutionInfoEntity infoEntity) {
        List<InvestorInfoEntity> list =  infoEntity.getMemberEntityList();
        return new InstitutionDocument(infoEntity.getInstitutionName(), infoEntity.getInstitutionId(), renderInstitutionMemberToString(list));
    }

    public static Iterable<InstitutionDocument> renderInstitutions(Iterable<InstitutionInfoEntity> infos) {
        List<InstitutionDocument> documents = new ArrayList<>();
        for (InstitutionInfoEntity info : infos) {
            documents.add(renderInstitution(info));
        }
        return documents;
    }

    public static List<String> renderInstitutionMemberToString(Iterable<InvestorInfoEntity> memberEntityList) {
        List<String> string = new ArrayList<>();
        for (InvestorInfoEntity member : memberEntityList) {
            string.add(member.getInvestorName());
        }
        return string;
    }

    public static PageInfo<Long> getInstitutionIds(Page<InstitutionDocument> institutionDocuments, int page, int size) {
        List<Long> ids = new ArrayList<>();
        PageInfo<Long> pageInfo = PageAndSortUtils.getPageInfo2(page,size,institutionDocuments);
        for (InstitutionDocument institutionDocument : institutionDocuments.getContent()) {
            ids.add(institutionDocument.getInstitutionId());
        }
        pageInfo.setContent(ids);
        return pageInfo;
    }


    // end of render InstitutionInfoEntity

    //start of render Investor
    public static Iterable<InvestorDocument> renderInvestor(Iterable<InvestorInfoEntity> all) {
        List<InvestorDocument> investors = new ArrayList<>();
        for (InvestorInfoEntity i : all) {
            investors.add(renderInvestor(i));
        }
        return investors;
    }

    public static InvestorDocument renderInvestor(InvestorInfoEntity i) {
        return new InvestorDocument(i.getInvestorId(), i.getInvestorName(), i.getInstitutionName(), i.getInvestorPosition());
    }

    public static PageInfo<Long> getInvestorIds(Page<InvestorDocument> institutionDocuments, int page, int size) {
        List<Long> ids = new ArrayList<>();
        PageInfo<Long> pageInfo = PageAndSortUtils.getPageInfo2(page,size,institutionDocuments);
        for (InvestorDocument institutionDocument : institutionDocuments.getContent()) {
            ids.add(institutionDocument.getInvestorId());
        }
        pageInfo.setContent(ids);
        return pageInfo;
    }
    // end of the Investor
}
