package com.lisa.service.impl;

import com.lisa.dao.userDao;
import com.lisa.entity.user;
import com.lisa.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userImpl implements userService {
    @Autowired
    private userDao udao;
    @Override
    public user login(String email, String password) {
        user u = udao.findByEmail(email);
        if (u==null){
            throw new RuntimeException("用户名错误");
        }
        if (!password.equals(u.getPassword())){
            throw new RuntimeException("密码错误");
        }


        return u;
    }

    @Override
    public void add(String email,String password,String pswagain) {
        System.out.println("852");
        if (email==null){
            throw new RuntimeException("请输入邮箱");
        }
        user u = udao.findByEmail(email);
        if (u!=null){
            throw new RuntimeException("用户名已存在");
        }
        if (password==null){
            throw new RuntimeException("请输入密码");
        }
        if (pswagain==null){
            throw new RuntimeException("请再次输入密码");
        }
        if (!password.equals(pswagain)){
            throw new RuntimeException("两次密码不一致");
        }
        user u2 = new user();
        u2.setPassword(password);
        u2.setEmail(email);
        udao.add(u2);
        System.out.println("ok");
    }

    @Override
    public user findByEmail(String Email) {
        user us = udao.findByEmail(Email);
        return us;
    }

    @Override
    public void update(user u) {
        udao.update(u);
    }

    @Override
    public user findByid(Integer id) {
        user us = udao.findByid(id);
        return us;
    }

    @Override
    public void updateHeadImg(Integer id, String imgUrl) {
        udao.updateHeadImg(id,imgUrl);
    }
}
