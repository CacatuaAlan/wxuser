package com.cn.alan.service;

import com.cn.alan.domain.WxUser;

import java.util.List;

public interface IWxUserService {
    boolean login(WxUser wxUser);
    void register(WxUser wxUser);
    void updateInfo(WxUser wxUser);
    List<WxUser> findAll();
}
