package com.example.test2;

import cn.bmob.v3.BmobObject;

/**
 * Created by Lenovo on 1/27/2018.
 */

public class Person extends BmobObject {

    private String username;
    private String password;
    private String portrait;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
