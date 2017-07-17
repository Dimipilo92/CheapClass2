package com.example.dimitri.cheapclass.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dimitri on 7/13/2017.
 */

public class DummyCourseEquivalencyDataProvider implements CourseEquivalencyDataProvider{

    private List<CourseEquivalency> equivalencies;

    public DummyCourseEquivalencyDataProvider() {
        equivalencies = new ArrayList<CourseEquivalency>(){{
            add(new DummyCourseEquivalency());
            add(new DummyCourseEquivalency());
            add(new DummyCourseEquivalency());
            add(new DummyCourseEquivalency());
            add(new DummyCourseEquivalency());
            add(new DummyCourseEquivalency());
            add(new DummyCourseEquivalency());
        }};
    }

    @Override
    public List<CourseEquivalency> getCourseEquivalencies(String course){
        return equivalencies;
    }
}
