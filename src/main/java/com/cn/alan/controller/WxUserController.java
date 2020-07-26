package com.cn.alan.controller;


import com.cn.alan.domain.WxUser;
import com.cn.alan.service.IWxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("wxUserController")
@RequestMapping("/user")
public class WxUserController {

    @Autowired
    IWxUserService wxUserService;

    @PostMapping(value = "login")
    @ResponseBody
    public String login(@RequestBody WxUser wxUser, HttpServletRequest request, HttpServletResponse response, Model model){
        boolean flag = wxUserService.login(wxUser);
        if(flag){
            request.getSession().setAttribute("wx_id",wxUser.getWx_id());
            model.addAttribute("wx_id",wxUser.getWx_id());
            return "index";
        }else {
            model.addAttribute("login_error","账户或密码错误");
            return "login";
        }
    }

    //注册
    @RequestMapping("register")
    @ResponseBody
    public String  register(@RequestBody WxUser wxUser){
        wxUserService.register(wxUser);
        return "login";
    }
}
