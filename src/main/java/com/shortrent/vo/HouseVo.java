package com.shortrent.vo;


import com.fasterxml.jackson.annotation.JsonProperty;


public class HouseVo {
    //横向装载值
    private String type;

    @JsonProperty("value")
    private Integer count;//将count转化为value

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
