package com.cn.bafang.backstage.manage.controller;

import com.cn.bafang.backstage.manage.entity.Role;
import com.cn.bafang.backstage.manage.entity.User;
import com.cn.bafang.backstage.manage.service.IMenuService;
import com.cn.bafang.backstage.manage.service.IRoleService;
import com.cn.bafang.backstage.manage.service.IUserService;
import com.cn.bafang.backstage.manage.util.BasePatterns;
import com.cn.bafang.backstage.manage.util.DataBackMessage;
import com.cn.bafang.backstage.manage.util.StringUtil;
import org.apache.ibatis.annotations.Select;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cn.bafang.backstage.manage.util.DataBackMessage.BackJSONMessage;

/**
 * 本类用于拦截为登陆访问本网站url，并将其跳转到登陆页面
 */
@Controller
public class MainController {
   private static final String UnknownAccountException = "1";

   private static final String IncorrectCredebtialsException = "2";

   private static final String  kaptchaValidateFailed = "3";


    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IMenuService menuService;


    @RequestMapping(value = "/admin/login")
    public String index(){
        return "admin/login";
    }

//    @RequestMapping(value = "/sign")
//    @ResponseBody()
//    public Map login(@RequestParam String name, @RequestParam String password, HttpSession session) {
//        Map result = new HashMap();
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
//        try {
//            //登陆验证
//            subject.login(token);
//            String username = (String) SecurityUtils.getSubject().getPrincipal();
//            Map<String, Object> map = new HashMap<>();
//            map.put("user_name", username);
//            User user = userService.selectByMap(map).get(0);
//            session.setAttribute("user", user);
//            List<Role> lrole = roleService.findByUserId(user.getId());
//            result.put("user",user);
//            result.put("role",lrole);
//            result.put("rolesize",lrole.size());
//            return result;
//
//        } catch (Exception e) {
//            result.put("status",false);
//            result.put("msg",e.toString());
//            return result;
//        }
//    }

    @RequestMapping(value = "/sign")
    //@ResponseBody()
    public String login(@RequestParam String name, @RequestParam String password,
                        HttpSession session, HttpServletRequest request,
                        Map<String,Object> map) {
        UsernamePasswordToken toke = new UsernamePasswordToken(name,password);
        String msg = "";
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(toke);
            return "/index";

        }catch (Exception exception){
            switch (exception.toString()){
                case "1":
                    System.out.println("账号不存在");
                    msg="UnknownAccountException="+exception;

                case "2":
                    System.out.println("密码不正确");
                    msg="IncorrectCredebtialsException="+exception;

                case "3":
                    System.out.println("验证码错误");
                    msg="kaptchaValidateFailed="+exception;

                default:
                    System.out.println("exception="+exception);
                    msg="exception="+exception;
            }
            return "/admin/login";
        }
    }

    @RequestMapping(value="/register")
    public String register(){
        return "register";
    }

    @RequestMapping(value="/addregister")
    public String addregister(){
       return null;
    }

    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        if (session != null) {
            session.invalidate();//将保存的session删除
        }
        return null;
    }

    @RequestMapping(value="/index")
    public String home() {
        return "index";
    }

    @RequestMapping(value="/errorpage")
    public String errorpage() {
        return "error";
    }

    @RequestMapping(value="/demo")
    @ResponseBody
    public String demo(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","jack");
        map.put("address","赵家胡同");
        return DataBackMessage.BackJSONMessage(true,null,map);
    }
}
