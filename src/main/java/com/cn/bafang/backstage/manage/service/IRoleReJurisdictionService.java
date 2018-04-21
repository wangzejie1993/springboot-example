package com.cn.bafang.backstage.manage.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.bafang.backstage.manage.entity.RoleRelJurisdictionEntity;

import java.util.Map;

public interface IRoleReJurisdictionService extends IService<RoleRelJurisdictionEntity>{
    /*
     * 增加角色与权限关联
     */
    Map<String, Object> addRoleRelJurisdiction(RoleRelJurisdictionEntity role);

    /*
     * 修改角色与权限关联
     */
    Map<String, Object> updateRoleRelJurisdiction(RoleRelJurisdictionEntity role);

    /*
     * 全量查询角色与权限关联
     */
    Map<String, Object> selectRoleRelJurisdiction(String content);

    /*
     * 根据id查询角色与权限关联
     */
    Map<String, Object> selectByIdRoleRelJurisdiction(String id);

    /*
     * 删除角色与权限关联
     */
    Map<String, Object> deletByIdRoleRelJurisdiction(String id);
}
