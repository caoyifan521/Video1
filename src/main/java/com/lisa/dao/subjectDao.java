package com.lisa.dao;

import com.lisa.entity.subject;
import com.lisa.vo.subjectInfo;

import java.util.List;

public interface subjectDao {
    public List<subject> findAll();
    public subjectInfo findSubJectInfo(Integer id);
}
