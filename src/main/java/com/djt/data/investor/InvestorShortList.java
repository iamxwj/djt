package com.djt.data.investor;

/**
 * @author Zhipeng
 * @date 2016/7/4.
 */
public class InvestorShortList {
    private String name; //高管名字
    private String photo;//高管照片
    private String position;//高管职位
    private Byte level;

    public InvestorShortList() {
    }

    public InvestorShortList(String name, String photo, String position, Byte level) {
        this.name = name;
        this.photo = photo;
        this.position = position;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "InvestorShortList{" +
                "name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", position='" + position + '\'' +
                ", level=" + level +
                '}';
    }

}
