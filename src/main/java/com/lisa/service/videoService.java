package com.lisa.service;

import com.lisa.entity.video;
import com.lisa.vo.videoInfo;
import com.lisa.vo.videoInfo2;

import java.util.List;

public interface videoService {
    public List<videoInfo> findAll(Integer page,Integer limit,String title,String speakerName,String courseTitle);
    public void addVideo(video v);
    public void deleteById(Integer id);
    public List<videoInfo2> findById(Integer id);
    public void update(video v);
    public String findById1(Integer id);
    public videoInfo findAll2(Integer id);
    public List<videoInfo2>  findAll3();
    public void deleteManyVideo(int[] idArr);
}
