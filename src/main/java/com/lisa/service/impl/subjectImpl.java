package com.lisa.service.impl;

import com.lisa.dao.subjectDao;
import com.lisa.entity.subject;
import com.lisa.service.subjectService;
import com.lisa.vo.subjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class subjectImpl implements subjectService {
    @Autowired
    private subjectDao sdao;
    @Override
    public List<subject> findAll() {
        List<subject> list = sdao.findAll();
        return list;
    }

    @Override
    public subjectInfo findSubJectInfo(Integer id) {
        subjectInfo list = sdao.findSubJectInfo(id);
        return list;
    }

}
