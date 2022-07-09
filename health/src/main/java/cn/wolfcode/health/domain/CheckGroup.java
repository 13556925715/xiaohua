package cn.wolfcode.health.domain;

import java.util.List;

public class CheckGroup {
    private Integer groupId;

    private String groupCode;

    private String groupName;

    private String helpcode;

    private String groupSex;

    private String attention;

    private String remark;

    private List<CheckItem> checkItems;
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getHelpcode() {
        return helpcode;
    }

    public void setHelpcode(String helpcode) {
        this.helpcode = helpcode;
    }

    public String getGroupSex() {
        return groupSex;
    }

    public void setGroupSex(String groupSex) {
        this.groupSex = groupSex;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getRemark() {
        return remark;
    }

    @Override
    public String toString() {
        return "CheckGroup{" +
                "groupId=" + groupId +
                ", groupCode='" + groupCode + '\'' +
                ", groupName='" + groupName + '\'' +
                ", helpcode='" + helpcode + '\'' +
                ", groupSex='" + groupSex + '\'' +
                ", attention='" + attention + '\'' +
                ", remark='" + remark + '\'' +
                ", checkItems=" + checkItems +
                '}';
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<CheckItem> getCheckItems() {
        return checkItems;
    }

    public void setCheckItems(List<CheckItem> checkItems) {
        this.checkItems = checkItems;
    }



}