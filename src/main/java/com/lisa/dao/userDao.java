package com.lisa.dao;

import com.lisa.entity.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface userDao {
    public user findByEmail (String Email);
    public void add(user u);
    public void update(user u);
    public user findByid(Integer id);
    public void updateHeadImg(@Param("id") Integer id,@Param("imgUrl") String imgUrl);
}
