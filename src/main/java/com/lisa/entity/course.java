package com.lisa.entity;

import java.util.List;

public class course {
    private Integer id;
    private String courseTitle;
    private String courseDesc;
    private Integer subjectid;
    private List<video> videoList;

    public List<video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<video> videoList) {
        this.videoList = videoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseDesc='" + courseDesc + '\'' +
                ", subjectid=" + subjectid +
                '}';
    }
}
