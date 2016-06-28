package com.djt.data.follow;

/**
 * Created by Zhipeng on 2016/4/11.
 */
public class FollowGroupInfo {
    private Long userId;
    private String name;
    private String description;
    private Long id;

    public FollowGroupInfo() {
    }

    public FollowGroupInfo(Long userId, String name, String description, Long id) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FollowGroupInfo{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
