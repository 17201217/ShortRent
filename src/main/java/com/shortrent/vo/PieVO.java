package com.shortrent.vo;

public class PieVO {
    private Integer value;
    private String name;


    public PieVO() {

    }

    public PieVO(Integer value,String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
