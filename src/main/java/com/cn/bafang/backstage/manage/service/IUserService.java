package com.cn.bafang.backstage.manage.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.bafang.backstage.manage.entity.User;

import java.util.Map;

public interface IUserService extends IService<User> {
    /*
     * 增加角色
     */
    Map<String, Object> addUser(User user);

    /*
     * 修改角色
     */
    Map<String, Object> updateUser(User user);

    /*
     * 全量查询角色
     */
    Map<String, Object> selectUser(String content);

    /*
     * 根据id查询角色
     */
    Map<String, Object> selectByIdUser(String id);

    /*
     * 删除角色
     */
    Map<String, Object> deletByIdUser(String id);
}
