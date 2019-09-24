package com.lisa.dao;

import com.lisa.entity.admin;

public interface adminDao {
    public admin findByName(String username);
}
