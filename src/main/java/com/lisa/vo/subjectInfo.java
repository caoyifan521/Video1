package com.lisa.vo;

import com.lisa.entity.course;
import com.lisa.entity.video;

import java.util.List;

public class subjectInfo {
    private Integer id;
    private String subjectname;
    private List<course> coursesList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public List<course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<course> coursesList) {
        this.coursesList = coursesList;
    }



    @Override
    public String toString() {
        return "subjectInfo{" +
                "id=" + id +
                ", subjectname='" + subjectname + '\'' +
                ", coursesList=" + coursesList +
                '}';
    }
}
