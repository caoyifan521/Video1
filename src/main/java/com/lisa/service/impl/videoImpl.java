package com.lisa.service.impl;

import com.github.pagehelper.PageHelper;
import com.lisa.dao.videoDao;
import com.lisa.entity.video;
import com.lisa.service.videoService;
import com.lisa.vo.videoInfo;
import com.lisa.vo.videoInfo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class videoImpl implements videoService {
    @Autowired
    private videoDao vdao;
    @Override
    public List<videoInfo> findAll(Integer page,Integer limit,String title,String speakerName,String courseTitle) {
        PageHelper.startPage(page, limit);
        List<videoInfo> list = vdao.findAll(title,speakerName,courseTitle);
        return list;
    }

    @Override
    public void addVideo(video v) {
        vdao.addVideo(v);
    }

    @Override
    public void deleteById(Integer id) {
        vdao.deleteById(id);
    }

    @Override
    public List<videoInfo2> findById(Integer id) {
        List<videoInfo2> list = vdao.findById(id);
        return list;
    }

    @Override
    public void update(video v) {
        vdao.update(v);
    }

    @Override
    public String findById1(Integer id) {
        String videourl = vdao.findById1(id);
        return videourl;
    }

    @Override
    public videoInfo findAll2(Integer id) {
        videoInfo list = vdao.findAll2(id);
        return list;
    }

    @Override
    public List<videoInfo2> findAll3() {
        List<videoInfo2> list = vdao.findAll3();
        return list;
    }
    @Override
    public void deleteManyVideo(int[] idArr) {

         vdao.deleteManyVideo(idArr);
    }
}
