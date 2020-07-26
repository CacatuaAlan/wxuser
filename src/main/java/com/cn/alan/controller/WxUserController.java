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
import java.util.List;

/**
* @Annotated: 控制层
* @Author: CacatuaAlan
* @Date: 2020/7/26
*/

@Controller("wxUserController")
@RequestMapping("/user")
public class WxUserController {

    @Autowired
    IWxUserService wxUserService;

    /**
     * 登录
     * @param wxUser
     * @param request
     * @param model
     * @return
     */
    @PostMapping(value = "login")
    @ResponseBody
    public String login(@RequestBody WxUser wxUser, HttpServletRequest request, Model model){
        boolean flag = wxUserService.login(wxUser);
        if(flag){
            request.getSession().setAttribute("wx_id",wxUser.getWx_id());
            model.addAttribute("wx_id", wxUser.getWx_id());
            return "index";
        }else {
            model.addAttribute("login_error","账户或密码错误");
            return "login";
        }
    }

    /**
     * 注册
     * @param wxUser
     * @return
     */
    @RequestMapping("register")
    @ResponseBody
    public String  register(@RequestBody WxUser wxUser){
        wxUserService.register(wxUser);
        return "login";
    }

    /**
     * 修改用户信息
     * @param wxUser
     * @return
     */
    @RequestMapping("updateInfo")
    @ResponseBody
    public String updateInfo(@RequestBody WxUser wxUser, HttpServletRequest request){
        request.getSession().setAttribute("updateInfo", wxUser);
        wxUserService.register(wxUser);
        return "updateSuccess";
    }

    public String findAll(HttpServletRequest request){
        List<WxUser> wxUsers = wxUserService.findAll();
        request.getSession().setAttribute("allUsers",wxUsers);
        return "allUsers";
    }
}
