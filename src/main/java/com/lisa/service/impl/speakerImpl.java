package com.lisa.service.impl;

import com.github.pagehelper.PageHelper;
import com.lisa.dao.speakerDao;
import com.lisa.entity.speaker;
import com.lisa.service.speakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class speakerImpl implements speakerService {
    @Autowired
    private speakerDao sdao;

    @Override
    public List<speaker> findAll() {
        List<speaker> list = sdao.findAll();
        return list;
    }

    @Override
    public List<speaker> findAll2(Integer page,Integer limit) {
        PageHelper.startPage(page, limit);
        List<speaker> list = sdao.findAll();
        return list;
    }

    @Override
    public void add(speaker s) {
        sdao.add(s);
    }

    @Override
    public speaker queryById(Integer id) {
        speaker speaker = sdao.queryById(id);
        return speaker;
    }

    @Override
    public void update(speaker s) {
            sdao.update(s);
    }

    @Override
    public void deleteById(Integer id) {
        sdao.deleteById(id);
    }
}
