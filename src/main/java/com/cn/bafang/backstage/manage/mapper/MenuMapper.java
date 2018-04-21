package com.cn.bafang.backstage.manage.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cn.bafang.backstage.manage.entity.Menu;
import com.cn.bafang.backstage.manage.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    @Select("<![CDATA[ " +
            "    SELECT tm.* " +
            "    from T_MENU tm " +
            "    inner join " +
            "    T_ROLE_MENU trm " +
            "    on tm.id=trm.menu_id " +
            "    where " +
            "    trm.role_id=]]>#{roleid}")
    List<Menu> selectMenusByRoleId(Integer userid);

    @Select("<![CDATA[ " +
            "    select tm.* " +
            "    from t_menu tm " +
            "      inner join t_role_menu trm " +
            "        on trm.menu_id=tm.id " +
            "    where trm.role_id=]]>#{roleid} " +
            "    <![CDATA[and tm.p_id=]]>#{pid} " +
            "    order by tm.id ASC")
    List<Menu> selectByParentIdAndRoleId(Integer roleid);
}
