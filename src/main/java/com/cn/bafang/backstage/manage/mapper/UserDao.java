package com.cn.bafang.backstage.manage.mapper;

import com.cn.bafang.backstage.manage.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by caden on 2017/7/14.
 */
@Mapper
public interface UserDao {
    @Select("SELECT * FROM user where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password")
    })
    User findById(@Param("id") int id);
}
