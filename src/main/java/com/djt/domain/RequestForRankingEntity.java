package com.djt.domain;

import javax.persistence.*;

/**
 * @author Zhipeng
 * @date 2016/7/7.
 */
@Entity
@Table(name = "request_for_ranking", schema = "", catalog = "djt")
public class RequestForRankingEntity {
    private Long rankingId;
    private Long userId;

    public RequestForRankingEntity(Long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "ranking_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getRankingId() {
        return rankingId;
    }

    public void setRankingId(Long rankingId) {
        this.rankingId = rankingId;
    }

    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
