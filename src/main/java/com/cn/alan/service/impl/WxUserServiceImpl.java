package com.cn.alan.service.impl;

import com.cn.alan.dao.IWxUserDao;
import com.cn.alan.domain.WxUser;
import com.cn.alan.service.IWxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("wxUserService")
public class WxUserServiceImpl implements IWxUserService {

    @Autowired
    IWxUserDao wxUserDao;

    @Override
    public boolean login(WxUser wxUser) {
        String wx_id = wxUser.getWx_id();
        String wx_password = wxUser.getWx_password();
        String truePassword = wxUserDao.findByWxId(wx_id).getWx_password();
        if(wx_password!=null && wx_password.equals(truePassword)){
            return true;
        }
        return false;
    }

    @Override
    public void register(WxUser wxUser) {
        wxUserDao.saveWxUser(wxUser);
    }

    @Override
    public void updateInfo(WxUser wxUser) {
        wxUserDao.updateWxUser(wxUser);
    }

    @Override
    public List<WxUser> findAll() {
        return wxUserDao.findAll();
    }
}
