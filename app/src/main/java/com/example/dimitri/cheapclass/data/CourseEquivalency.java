package com.example.dimitri.cheapclass.data;

import java.util.List;

/**
 * Created by Dimitri on 7/2/2017.
 */

public class CourseEquivalency {
    private List<Course> cppCourses;

    private List<Course> transferCourses;

    public CourseEquivalency() {}

    public CourseEquivalency(List<Course> cppCourses, List<Course> transferCourses) {
        this.cppCourses = cppCourses;
        this.transferCourses = transferCourses;
    }

    public List<Course> getCppCourses() {
        return cppCourses;
    }

    public void setCppCourses(List<Course> cppCourses) {
        this.cppCourses = cppCourses;
    }

    public List<Course> getTransferCourses() {
        return transferCourses;
    }

    public void setTransferCourses(List<Course> transferCourses) {
        this.transferCourses = transferCourses;
    }
}