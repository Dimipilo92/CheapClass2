package com.example.dimitri.cheapclass.data;

import java.util.List;

/**
 * Created by Dimitri on 7/19/2017.
 */

public class SchoolMetaData {
    List<Course> courses;
    List<Major> majors;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }
}
