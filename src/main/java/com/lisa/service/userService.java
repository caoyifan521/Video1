package com.lisa.service;

import com.lisa.entity.user;

public interface userService {
    public user login(String email,String password);
    public void add(String email,String password,String pswagain);
    public user findByEmail (String Email);
    public void update(user u);
    public user findByid(Integer id);
    public void updateHeadImg(Integer id,String imgUrl);
}
