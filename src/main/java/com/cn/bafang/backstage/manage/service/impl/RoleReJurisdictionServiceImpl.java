package com.cn.bafang.backstage.manage.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.bafang.backstage.manage.entity.RoleRelJurisdictionEntity;
import com.cn.bafang.backstage.manage.mapper.RoleRelJurisdictionMapper;
import com.cn.bafang.backstage.manage.service.IRoleReJurisdictionService;
import com.cn.bafang.backstage.manage.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleReJurisdictionServiceImpl extends ServiceImpl<RoleRelJurisdictionMapper,RoleRelJurisdictionEntity> implements IRoleReJurisdictionService{
    @Override
    public Map<String, Object> addRoleRelJurisdiction(RoleRelJurisdictionEntity role) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isBlank(role.getJur_id())) {
            map.put("ret", -1);
            map.put("msg", "有未填写的角色权限信息");
            return map;
        }
        try {
            String id = UUID.randomUUID().toString().replace("-", "");
            role.setId(id);
            int flag = baseMapper.insert(role);
            if (flag != 1) {
                map.put("ret", -1);
                map.put("msg", "角色权限添加失败");
                return map;
            }
        } catch (Exception e) {
            map.put("ret", -1);
            map.put("msg", "程序出错，角色权限添加失败");
            return map;
        }
        map.put("ret", 1);
        map.put("msg", "角色权限添加成功");
        return map;
    }

    @Override
    public Map<String, Object> updateRoleRelJurisdiction(RoleRelJurisdictionEntity role) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int flag = baseMapper.updateAllColumnById(role);
            if (flag != 1) {
                map.put("ret", -1);
                map.put("msg", "角色权限更新失败");
                return map;
            }
        } catch (Exception e) {
            map.put("ret", -1);
            map.put("msg", "程序出错，角色权限更新失败");
            return map;
        }
        map.put("ret", 1);
        map.put("msg", "角色权限更新成功");
        return map;
    }

    @Override
    public Map<String, Object> selectRoleRelJurisdiction(String content) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String,Object> retult = new HashMap<>();
        retult.put("status","0");
        List<RoleRelJurisdictionEntity> list = new ArrayList<RoleRelJurisdictionEntity>();
        try {
            list = baseMapper.selectByMap(retult);
        } catch (Exception e) {
            map.put("ret", -1);
            map.put("msg", "程序出错，查询角色权限失败");
            return map;
        }

        map.put("list", list);
        map.put("ret", 1);
        map.put("msg", "获取成功");
        return map;
    }

    @Override
    public Map<String, Object> selectByIdRoleRelJurisdiction(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        RoleRelJurisdictionEntity entity = new RoleRelJurisdictionEntity();
        if(StringUtil.isEmpty(id)){
            map.put("msg","id不能为空，查询角色权限失败");
            map.put("ret",-1);
            return map;
        }
        try {
            entity = baseMapper.selectById(id);
        } catch (Exception e) {
            map.put("ret", -1);
            map.put("msg", "程序出错，查询角色权限失败");
            return map;
        }

        map.put("RoleEntity", entity);
        map.put("ret", 1);
        map.put("msg", "获取成功");
        return map;
    }

    @Override
    public Map<String, Object> deletByIdRoleRelJurisdiction(String id) {
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
                map.put("msg", "删除角色权限失败");
                return map;
            }
        } catch (Exception e) {
            map.put("ret", -1);
            map.put("msg", "程序出错，删除角色权限失败");
            return map;
        }
        map.put("ret", 1);
        map.put("msg", "删除角色权限成功");
        return map;
    }

    /**
     * 分页查询
     */

}
