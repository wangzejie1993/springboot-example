package com.cn.bafang.backstage.manage.config;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cn.bafang.backstage.manage.entity.Menu;
import com.cn.bafang.backstage.manage.entity.Role;
import com.cn.bafang.backstage.manage.entity.User;
import com.cn.bafang.backstage.manage.service.IMenuService;
import com.cn.bafang.backstage.manage.service.IRoleService;
import com.cn.bafang.backstage.manage.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IMenuService menuService;

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String name =(String) SecurityUtils.getSubject().getPrincipal();
        User user1 = new User();
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        user1= userService.selectOne(wrapper.eq("user_name",name));

        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        //List<Role> roleList=roleRepository.findByUserId(user.getId());
        EntityWrapper<Role> entityWrapper = new EntityWrapper<>();
        List<Role> roleList = roleService.findByUserId(user1.getId());

        Set<String> roles=new HashSet<String>();
        if(roleList.size()>0){
            for(Role role:roleList){
                roles.add(role.getName());
                //根据角色id查询所有资源
                EntityWrapper<Menu> menuwrapper = new EntityWrapper<>();
                List<Menu> menuList=menuService.findByRoleId(role.getId());
                for(Menu menu:menuList){
                    info.addStringPermission(menu.getName()); // 添加权限
                }
            }
        }
        info.setRoles(roles);
        return info;
    }

    /**
     * 权限认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        EntityWrapper<User> entity = new EntityWrapper<>();
        User u = new User();
        u.setName(username);
        entity.setEntity(u);
        Map map = new HashMap();
        map.put("user_name",username);

        List<User> list = userService.selectByMap(map);

        User user = list.get(0);//用户登陆查验

        if (user!=null){
            AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getName(),user.getPassword(),getName());
            return authcInfo;
        }else{
            return null;
        }
    }

    @Override
    public String getName() {
        return "myRealm";
    }
}
