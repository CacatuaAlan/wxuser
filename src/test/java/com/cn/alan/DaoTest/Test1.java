package com.cn.alan.DaoTest;

import com.cn.alan.dao.IWxUserDao;
import com.cn.alan.domain.WxUser;
import com.cn.alan.service.IWxUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test1 {

    @Autowired
    private IWxUserService wxUserService;

    @Test
    public void test(){
        WxUser wxUser = new WxUser();
        wxUser.setWx_id("CacatuaAlan");
        wxUser.setWx_name("CacatuaAlan");
        wxUser.setWx_password("CacatuaAlan");
        wxUser.setGender(0);
        wxUser.setRegion("广东省");
        wxUser.setPhone("13751878592");
        wxUser.setGmt_create(new Date());
        //wxUserService.register(wxUser);
        //System.out.println(wxUserService.login(wxUser));
        wxUserService.updateInfo(wxUser);
    }
}
