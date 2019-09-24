package com.lisa.service;

import com.lisa.entity.subject;
import com.lisa.vo.subjectInfo;

import java.util.List;

public interface subjectService {
    public List<subject> findAll();
    public subjectInfo findSubJectInfo(Integer id);
}
