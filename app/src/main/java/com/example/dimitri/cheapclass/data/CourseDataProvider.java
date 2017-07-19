package com.example.dimitri.cheapclass.data;

import java.util.List;

/**
 * Created by Dimitri on 7/2/2017.
 */

public interface CourseDataProvider {

    Course getCourse(String id);
    List<Course> getAllCourses();
    List<Course> getCoursesInMajor(String major);
    List<Course> getCoursesInArea(String major, String area);
}
