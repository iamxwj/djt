package com.djt.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Zhipeng
 * @date 2016/6/15.
 */
@Entity
@Table(name = "request_cash", schema = "", catalog = "djt")
public class RequestCashEntity {
    private Long id;
    private Long userId;
    private int amount;
    private String account;
    private String name;
    private Byte type;
    private Timestamp createDate;

    public RequestCashEntity() {
    }

    public RequestCashEntity(Long id, Long userId, int amount, String account, String name, Byte type, Timestamp createDate) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.account = account;
        this.name = name;
        this.type = type;
        this.createDate = createDate;
    }

    public RequestCashEntity(Long id, Long userId, int amount, String account, Byte type, Timestamp createDate) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.account = account;
        this.type = type;
        this.createDate = createDate;
    }

    public RequestCashEntity(Long id, Long userId, int amount, Byte type, Timestamp createDate) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "RequestCashEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", amount=" + amount +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", createDate=" + createDate +
                '}';
    }
}
