package com.heyang.mall.entity;

/**
 * creat on 2019/4/10
 * <p>
 * #author : CAS_hy
 **/
public class UserDo {
    private Long id;

    private String username;

    private String password;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
