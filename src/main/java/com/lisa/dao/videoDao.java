package com.lisa.dao;

import com.lisa.entity.video;
import com.lisa.vo.videoInfo;
import com.lisa.vo.videoInfo2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface videoDao {
    public List<videoInfo> findAll(@Param("title") String title,@Param("speakerName") String speakerName,@Param("courseTitle") String courseTitle);
    public void addVideo(video v);
    public void deleteById(Integer id);
    public List<videoInfo2> findById(Integer id);
    public void update(video v);
    public String findById1(Integer id);
    public videoInfo findAll2(Integer id);
    public List<videoInfo2> findAll3();
    public void deleteManyVideo(int[] idArr);

}
