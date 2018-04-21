package com.cn.bafang.backstage.manage.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.bafang.backstage.manage.entity.RoleAndMenu;
import com.cn.bafang.backstage.manage.entity.UserAndRole;

import java.util.Map;

public interface IUserAndRole extends IService<UserAndRole> {
    /*
     * 增加用户角色关系
     */
    Map<String, Object> addUserAndRole(UserAndRole user);

    /*
     * 修改用户角色关系
     */
    Map<String, Object> updateUserAndRole(UserAndRole user);

    /*
     * 全量查询用户角色关系
     */
    Map<String, Object> selectUserAndRole(String content);

    /*
     * 根据id查询用户角色关系
     */
    Map<String, Object> selectByIdUserAndRole(String id);

    /*
     * 删除用户角色关系
     */
    Map<String, Object> deletByIdUserAndRole(String id);
}
