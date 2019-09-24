package com.lisa.entity;

public class subject {
    private Integer id;
    private String subjectname;

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

    @Override
    public String toString() {
        return "subject{" +
                "id=" + id +
                ", subjectname='" + subjectname + '\'' +
                '}';
    }
}
