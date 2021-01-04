package com.example.xier_android_obj;

public class GroupBean {

    private int imgId;

    private String creater;

    private String groupName;

    public GroupBean(int imgId, String creater, String groupName) {
        this.imgId = imgId;
        this.creater = creater;
        this.groupName = groupName;
    }

    public int getImgId() {
        return imgId;
    }

    public String getCreater() {
        return creater;
    }

    public String getGroupName() {
        return groupName;
    }
}
