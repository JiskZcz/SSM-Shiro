package com.my.ssm.controller;

import com.my.ssm.bean.Msg;
import com.my.ssm.bean.user;
import com.my.ssm.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginAndLogoutController {
    @Autowired
    private UserService userService;

    //初始页面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    @RequestMapping("/unauthorizedUrl")
    public String unauthorizedUrl(){
        return "unauthorizedUrl";
    }

    /**
     * 使用Shiro来进行登录验证和权限认证
     * @param username 登录用户名
     * @param userpswd  密码
     * @param session 登录名字
     * @return 是否成功
     */
    @ResponseBody
    @RequestMapping("/Login")
    public Msg login(@RequestParam("username") String username, @RequestParam("userpswd") String userpswd,
                     HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(username,userpswd);
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            session.setAttribute("loginUser",username);
            return Msg.success();
        }catch (Exception ex){
            ex.printStackTrace();
            return Msg.fail();
        }
    }

    //退出
    @RequestMapping("/logout")
    public String LogOut(HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }
        return "redirect:/login";
    }

}
