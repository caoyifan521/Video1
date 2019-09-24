package com.lisa.dao;

import com.lisa.entity.speaker;

import java.util.List;

public interface speakerDao {
    public List<speaker> findAll();
    public List<speaker> findAll2();
    public void add(speaker s);
    public speaker queryById(Integer id);
    public void update(speaker speaker);
    public void deleteById(Integer id);
}
