package com.cn.bafang.backstage.manage.entity;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName(value="t_user_role")
public class UserAndRole {
    private int id;

    private int role_id;

    private int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
