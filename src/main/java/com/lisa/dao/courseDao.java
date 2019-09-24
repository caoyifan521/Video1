package com.lisa.dao;

import com.lisa.entity.course;
import com.lisa.vo.courseInfo;

import java.util.List;

public interface courseDao {
    public List<course> findAll();
    public List<courseInfo> findAll2();
    public void add(course c);
    public course findById(Integer id);
    public void update(course c);
    public void deleteById(Integer id);
}
