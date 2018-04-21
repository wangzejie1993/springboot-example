package com.cn.bafang.backstage.manage.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.bafang.backstage.manage.entity.User;
import com.cn.bafang.backstage.manage.mapper.Usermapper;
import com.cn.bafang.backstage.manage.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class UserServiceImpl extends ServiceImpl<Usermapper,User> implements IUserService {
    @Override
    public Map<String, Object> addUser(User user) {
        return null;
    }

    @Override
    public Map<String, Object> updateUser(User user) {
        return null;
    }

    @Override
    public Map<String, Object> selectUser(String content) {
        return null;
    }

    @Override
    public Map<String, Object> selectByIdUser(String id) {
        return null;
    }

    @Override
    public Map<String, Object> deletByIdUser(String id) {
        return null;
    }
}
