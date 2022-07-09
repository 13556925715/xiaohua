package cn.wolfcode.health.domain;

import java.util.List;

public class Setmeal {
    private Integer setmealId;

    private String setmealName;

    private String setmealCode;

    private String helpcode;

    private String setmealSex;

    private String setmealAge;

    private Double setmealPrice;

    private String attention;

    private String remark;

    public List<CheckGroup> getCheckGroups() {
        return checkGroups;
    }

    public void setCheckGroups(List<CheckGroup> checkgroups) {
        this.checkGroups = checkgroups;
    }

    private List<CheckGroup> checkGroups;

    public Integer getSetmealId() {
        return setmealId;
    }

    public void setSetmealId(Integer setmealId) {
        this.setmealId = setmealId;
    }

    public String getSetmealName() {
        return setmealName;
    }

    public void setSetmealName(String setmealName) {
        this.setmealName = setmealName;
    }

    public String getSetmealCode() {
        return setmealCode;
    }

    public void setSetmealCode(String setmealCode) {
        this.setmealCode = setmealCode;
    }

    public String getHelpcode() {
        return helpcode;
    }

    public void setHelpcode(String helpcode) {
        this.helpcode = helpcode;
    }

    public String getSetmealSex() {
        return setmealSex;
    }

    public void setSetmealSex(String setmealSex) {
        this.setmealSex = setmealSex;
    }

    public String getSetmealAge() {
        return setmealAge;
    }

    public void setSetmealAge(String setmealAge) {
        this.setmealAge = setmealAge;
    }

    public Double getSetmealPrice() {
        return setmealPrice;
    }

    public void setSetmealPrice(Double setmealPrice) {
        this.setmealPrice = setmealPrice;
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

    public void setRemark(String remark) {
        this.remark = remark;
    }
}