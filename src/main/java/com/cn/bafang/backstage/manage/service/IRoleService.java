package com.cn.bafang.backstage.manage.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.bafang.backstage.manage.entity.Role;

import java.util.List;
import java.util.Map;

public interface IRoleService extends IService<Role>{
    /*
     * 增加角色
     */
    Map<String, Object> addRole(Role role);

    /*
     * 修改角色
     */
    Map<String, Object> updateRole(Role role);

    /*
     * 全量查询角色
     */
    Map<String, Object> selectRole(String content);

    /*
     * 根据id查询角色
     */
    Map<String, Object> selectByIdRole(String id);

    /*
     * 删除角色
     */
    Map<String, Object> deletByIdRole(String id);

    List<Role> findByUserId(Integer userid);
}
