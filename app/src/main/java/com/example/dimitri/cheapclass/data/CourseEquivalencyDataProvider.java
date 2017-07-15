package com.example.dimitri.cheapclass.data;

import java.util.List;

/**
 * Created by Dimitri on 7/13/2017.
 */

public interface CourseEquivalencyDataProvider {
    List<CourseEquivalency> getCourseEquivalencies(String school, String course);
}
