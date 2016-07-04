package com.djt.data.investor;

/**
 * @author Zhipeng
 * @date 2016/7/4.
 */
public class InvestorShortList {
    private String name;
    private String photo;
    private String position;


    public InvestorShortList(String name, String photo, String position) {
        this.name = name;
        this.photo = photo;
        this.position = position;
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

    @Override
    public String toString() {
        return "InvestorShortList{" +
                "name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
