package com.my.ssm.bean;

public class role {
    private Integer id;

    private String name;

    private String ENname;

    public String getENname() {
        return ENname;
    }

    public void setENname(String ENname) {
        this.ENname = ENname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}