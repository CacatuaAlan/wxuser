package com.cn.alan.dao;


import com.cn.alan.domain.WxUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wxUserDao")
public interface IWxUserDao {

    // 查找全部用户信息
    @Select("select * wx_user")
    List<WxUser> findAll();

    // 根据微信号查找用户
    @Select("select * from wx_user where wx_id=#{wx_id}")
    WxUser findByWxId(String wx_id);

    // 保存用户
    @Insert("insert into wx_user(wx_id,wx_password,wx_name,gender,region,phone,gmt_create)" +
            " values(#{wx_id},#{wx_password},#{wx_name},#{gender},#{region},#{phone},#{gmt_create})")
    void saveWxUser(WxUser wxUser);

    // 更新用户
    @Update("update wx_user set gender=#{gender},region=#{region},phone=#{phone} where wx_id=#{wx_id}")
    void updateWxUser(WxUser wxUser);
}
