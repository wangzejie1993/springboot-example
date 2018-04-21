package com.cn.bafang.backstage.manage.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.bafang.backstage.manage.entity.Menu;
import com.cn.bafang.backstage.manage.mapper.MenuMapper;
import com.cn.bafang.backstage.manage.service.IMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper,Menu> implements IMenuService {

    @Override
    public Map<String, Object> addMenu(Menu menu) {
        return null;
    }

    @Override
    public Map<String, Object> updateMenu(Menu menu) {
        return null;
    }

    @Override
    public Map<String, Object> selectMenu(String content) {
        return null;
    }

    @Override
    public Map<String, Object> selectByIdMenu(String id) {
        return null;
    }

    @Override
    public Map<String, Object> deletByIdMenu(String id) {
        return null;
    }

    @Override
    public List<Menu> findByRoleId(Integer id) {
        List<Menu> list = new ArrayList<>();
        try {
            list = baseMapper.selectMenusByRoleId(id);
        }catch (Exception e){
            return  null;
        }
        return list;
    }
}
