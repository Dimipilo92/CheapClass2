package com.example.dimitri.cheapclass.data;

import java.util.List;

/**
 * Created by Dimitri on 7/2/2017.
 */

public interface CourseDataProvider {

    List<Course> getAllCourses(String major, String Area);
    List<Course> getCoursesInArea(String major, String Area);
}
