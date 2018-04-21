package com.cn.bafang.backstage.manage.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cn.bafang.backstage.manage.entity.Role;
import com.cn.bafang.backstage.manage.entity.RoleEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * role 表数据库控制接口
 */
public interface RoleMapper extends BaseMapper<Role> {

    @Select(
            "  SELECT " +
            "    tr.ID, tr.BZ, tr.NAME, tr.REMARKS " +
            "  from T_ROLE tr " +
            "  inner join " +
            "  T_USER_ROLE tur " +
            "  on tr.id=tur.role_id " +
            "  where " +
            "  tur.user_id= #{userid}")
    List<Role> selectRolesByUserId(Integer userid);

}
