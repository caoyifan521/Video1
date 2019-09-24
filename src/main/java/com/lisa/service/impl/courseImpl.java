package com.lisa.service.impl;

import com.github.pagehelper.PageHelper;
import com.lisa.dao.courseDao;
import com.lisa.entity.course;
import com.lisa.service.courseService;
import com.lisa.vo.courseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class courseImpl implements courseService {
    @Autowired
    private courseDao cdao;
    @Override
    public List<course> findAll() {
        List<course> list = cdao.findAll();
        return list;
    }

    @Override
    public List<courseInfo> findAll2(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<courseInfo> list = cdao.findAll2();
        return list ;
    }

    @Override
    public void add(course c) {
        cdao.add(c);
    }

    @Override
    public course findById(Integer id) {
        return cdao.findById(id);
    }

    @Override
    public void update(course c) {
        cdao.update(c);
    }

    @Override
    public void deleteById(Integer id) {
        cdao.deleteById(id);
    }
}
