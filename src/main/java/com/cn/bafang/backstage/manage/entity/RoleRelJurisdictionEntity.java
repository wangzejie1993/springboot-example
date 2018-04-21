package com.cn.bafang.backstage.manage.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("role_rel_jurisdiction")
public class RoleRelJurisdictionEntity {
        private String id;

        private String role_id;

        private String jur_id;

        private String status;

        @TableField("create_time")
        private Date createtime;

        @TableField("create_time")
        private Date updatetime;

        private String other;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getJur_id() {
        return jur_id;
    }

    public void setJur_id(String jur_id) {
        this.jur_id = jur_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
