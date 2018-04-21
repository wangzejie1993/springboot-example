package com.cn.bafang.backstage.manage.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.bafang.backstage.manage.entity.RoleAndMenu;

import java.util.Map;

public interface IRoleAndMenuService extends IService<RoleAndMenu> {
    /*
     * 增加角色菜单
     */
    Map<String, Object> addRoleAndMenu(RoleAndMenu user);

    /*
     * 修改角色菜单
     */
    Map<String, Object> updateRoleAndMenu(RoleAndMenu user);

    /*
     * 全量查询角色菜单
     */
    Map<String, Object> selectRoleAndMenu(String content);

    /*
     * 根据id查询角色菜单
     */
    Map<String, Object> selectByIdRoleAndMenu(String id);

    /*
     * 删除角色菜单
     */
    Map<String, Object> deletByIdRoleAndMenu(String id);

}
