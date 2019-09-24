package com.lisa.service;

import com.lisa.entity.speaker;

import java.util.List;

public interface speakerService {
    public List<speaker> findAll();
    public List<speaker> findAll2(Integer page,Integer limit);
    public void add(speaker s);
    public speaker queryById(Integer id);
    public void update(speaker s);
    public void deleteById(Integer id);
}
