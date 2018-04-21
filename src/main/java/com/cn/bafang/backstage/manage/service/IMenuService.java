package com.cn.bafang.backstage.manage.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.bafang.backstage.manage.entity.Menu;

import java.util.List;
import java.util.Map;

public interface IMenuService extends IService<Menu> {
    /*
     * 增加菜单
     */
    Map<String, Object> addMenu(Menu menu);

    /*
     * 修改菜单
     */
    Map<String, Object> updateMenu(Menu menu);

    /*
     * 全量查询菜单
     */
    Map<String, Object> selectMenu(String content);

    /*
     * 根据id查询菜单
     */
    Map<String, Object> selectByIdMenu(String id);

    /*
     * 删除菜单
     */
    Map<String, Object> deletByIdMenu(String id);

    List<Menu> findByRoleId(Integer id);
}
