package com.xr.entity;

public class Menu {
    private Integer sysmid;
    private String sysmName;
    private String sysParentId;
    private String url;
    private String perms;
    private Integer type;
    private String icon;
    private Integer orderNum;

    public Integer getSysmid() {
        return sysmid;
    }

    public void setSysmid(Integer sysmid) {
        this.sysmid = sysmid;
    }

    public String getSysmName() {
        return sysmName;
    }

    public void setSysmName(String sysmName) {
        this.sysmName = sysmName;
    }

    public String getSysParentId() {
        return sysParentId;
    }

    public void setSysParentId(String sysParentId) {
        this.sysParentId = sysParentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "sysmid=" + sysmid +
                ", sysmName='" + sysmName + '\'' +
                ", sysParentId='" + sysParentId + '\'' +
                ", url='" + url + '\'' +
                ", perms='" + perms + '\'' +
                ", type=" + type +
                ", icon='" + icon + '\'' +
                ", orderNum=" + orderNum +
                '}';
    }
}
