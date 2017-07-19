package com.example.dimitri.cheapclass.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dimitri on 7/13/2017.
 */

public class DummyCourseDataProvider implements CourseDataProvider {

    private ArrayList<Course> courseList;
    public DummyCourseDataProvider(){
        courseList = new ArrayList<Course>(){{
            add(new Course("CS311", "CS 311","Languages and Automata",4));
            add(new Course("CS499","CS 499", "App Development",4));
            add(new Course("BIO111L","BIO 111L", "Biology Lab",4));
            add(new Course("CS311", "CS 311","Languages and Automata",4));
            add(new Course("CS499","CS 499", "App Development",4));
            add(new Course("BIO111L","BIO 111L", "Biology Lab",4));
            add(new Course("CS311", "CS 311","Languages and Automata",4));
            add(new Course("CS499","CS 499", "App Development",4));
            add(new Course("BIO111L","BIO 111L", "Biology Lab",4));
            add(new Course("CS311", "CS 311","Languages and Automata",4));
            add(new Course("CS499","CS 499", "App Development",4));
            add(new Course("BIO111L","BIO 111L", "Biology Lab",4));
            add(new Course("CS311", "CS 311","Languages and Automata",4));
            add(new Course("CS499","CS 499", "App Development",4));
            add(new Course("BIO111L","BIO 111L", "Biology Lab",4));
            add(new Course("CS311", "CS 311","Languages and Automata",4));
            add(new Course("CS499","CS 499", "App Development",4));
            add(new Course("BIO111L","BIO 111L", "Biology Lab",4));
            add(new Course("CS311", "CS 311","Languages and Automata",4));
            add(new Course("CS499","CS 499", "App Development",4));
            add(new Course("BIO111L","BIO 111L", "Biology Lab",4));
            add(new Course("CS311", "CS 311","Languages and Automata",4));
            add(new Course("CS499","CS 499", "App Development",4));
            add(new Course("BIO111L","BIO 111L", "Biology Lab",4));


        }};
    }

    @Override
    public Course getCourse(String id){
        return new Course("BIO111L","BIO 111L", "Biology Lab",4);
    }

    @Override
    public List<Course> getAllCourses(){
        return courseList;
    }

    @Override
    public List<Course> getCoursesInMajor(String major){
        return courseList;
    }

    @Override
    public List<Course> getCoursesInArea(String major, String area) { return courseList; }
}
