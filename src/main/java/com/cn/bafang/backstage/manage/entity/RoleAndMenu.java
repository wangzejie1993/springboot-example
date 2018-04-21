package com.cn.bafang.backstage.manage.entity;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName(value="t_role_menu")
public class RoleAndMenu {
    private int id;

    private int menu_id;

    private int role_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
