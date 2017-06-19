package com.example.phoenixchain.home;

import java.io.Serializable;

/**
 * Created by coderex2522 on 6/16/2017.
 */

public class RecentContacts implements Serializable {
    private String name;
    private int headSculptureImgId;
    private String phoneNum;

    public RecentContacts(String name, int headSculptureImgId, String phoneNum) {
        this.name = name;
        this.headSculptureImgId = headSculptureImgId;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeadSculptureImgId() {
        return headSculptureImgId;
    }

    public void setHeadSculptureImgId(int headSculptureImgId) {
        this.headSculptureImgId = headSculptureImgId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
