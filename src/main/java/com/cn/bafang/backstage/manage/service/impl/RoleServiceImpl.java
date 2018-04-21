package com.cn.bafang.backstage.manage.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.bafang.backstage.manage.entity.Role;
import com.cn.bafang.backstage.manage.mapper.RoleMapper;
import com.cn.bafang.backstage.manage.service.IRoleService;
import com.cn.bafang.backstage.manage.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements IRoleService {
    @Override
    public Map<String, Object> addRole(Role role) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isBlank(role.getName())) {
            map.put("ret", -1);
            map.put("msg", "有未填写的角色信息");
            return map;
        }
        try {
            int flag = baseMapper.insert(role);
            if (flag != 1) {
                map.put("ret", -1);
                map.put("msg", "角色添加失败");
                return map;
            }
        } catch (Exception e) {
            map.put("ret", -1);
            map.put("msg", "程序出错，角色添加失败");
            return map;
        }
        map.put("ret", 1);
        map.put("msg", "角色更新成功");
        return map;
    }
    @Override
    public Map<String, Object> updateRole(Role role) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            int flag = baseMapper.updateAllColumnById(role);
            if (flag != 1) {
                map.put("ret", -1);
                map.put("msg", "角色更新失败");
                return map;
            }
        } catch (Exception e) {
            map.put("ret", -1);
            map.put("msg", "程序出错，角色更新失败");
            return map;
        }
        map.put("ret", 1);
        map.put("msg", "角色更新成功");
        return map;
    }

    @Override
    public Map<String, Object> selectRole(String content) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String,Object> retult = new HashMap<>();
        retult.put("status","0");
        List<Role> list = new ArrayList<Role>();
        try {
            list = baseMapper.selectByMap(retult);
        } catch (Exception e) {
            map.put("ret", -1);
            map.put("msg", "程序出错，查询角色失败");
            return map;
        }

        map.put("list", list);
        map.put("ret", 1);
        map.put("msg", "获取成功");
        return map;
    }

    @Override
    public Map<String, Object> selectByIdRole(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Role roleEntity = new Role();
        if(StringUtil.isEmpty(id)){
            map.put("msg","id不能为空，查询角色失败");
            map.put("ret",-1);
            return map;
        }
        try {
             roleEntity = baseMapper.selectById(id);
        } catch (Exception e) {
            map.put("ret", -1);
            map.put("msg", "程序出错，查询角色失败");
            return map;
        }

        map.put("RoleEntity", roleEntity);
        map.put("ret", 1);
        map.put("msg", "获取成功");
        return map;
    }

    @Override
    public Map<String, Object> deletByIdRole(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isBlank(id)) {
            map.put("ret", -1);
            map.put("msg", "id不能为空");
            return map;
        }
        try {
            int flag = baseMapper.deleteById(id);
            if (flag != 1) {
                map.put("ret", -1);
                map.put("msg", "删除失败");
                return map;
            }
        } catch (Exception e) {
            map.put("ret", -1);
            map.put("msg", "程序出错，删除失败");
            return map;
        }
        map.put("ret", 1);
        map.put("msg", "删除成功");
        return map;
    }

    @Override
    public List<Role> findByUserId(Integer userid) {
        List<Role> list = new ArrayList<>();
        if (null==userid){
            return null;
        }
        try{
            list = baseMapper.selectRolesByUserId(userid);
        }catch (Exception e){
            return null;
        }
        return list;
    }
}
