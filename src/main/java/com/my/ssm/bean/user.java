package com.my.ssm.bean;

import javax.validation.constraints.Pattern;

public class user {
    private Integer id;

    @Pattern(regexp="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})"
            ,message="用户名必须是2-5位中文或者6-16位英文和数字的组合")
    private String name;

    @Pattern(regexp="^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",
            message="邮箱格式不正确")
    private String email;

    @Pattern(regexp="(^[a-zA-Z0-9_-]{6,16}$)"
            ,message="密码必须6-16位英文和数字的组合")
    private String userpassword;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }
}