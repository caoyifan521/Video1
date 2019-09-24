package com.lisa.service.impl;


import com.lisa.dao.adminDao;
import com.lisa.entity.admin;
import com.lisa.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements adminService {

    @Autowired(required = false)
    private adminDao ado;
    @Override
    public admin login(String username, String password) {
        admin ad = ado.findByName(username);
        if(ad == null){
            throw new RuntimeException("账号错误");
        }
        if(!ad.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        return ad;

    }


}
