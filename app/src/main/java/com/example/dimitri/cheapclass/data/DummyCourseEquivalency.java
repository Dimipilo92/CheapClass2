package com.example.dimitri.cheapclass.data;

import java.util.ArrayList;

/**
 * Created by Dimitri on 7/13/2017.
 */

public class DummyCourseEquivalency extends CourseEquivalency {
    DummyCourseEquivalency() {
         ArrayList<Course> cpp = new ArrayList<Course>(){{
             add(new Course("CS311", "CS 311","Languages and Automata",4,"It's Lit!"));
             add(new Course("CS499","CS 499", "App Development",4,"Super Cray!"));
             add(new Course("BIO111L","BIO 111L", "Biology Lab",4,"EASY A!"));
         }};
        ArrayList<Course> transfer = new ArrayList<Course>(){{
            add(new Course("MATH101", "MATH 101","Super Lame Math",4,"It's tame."));
            add(new Course("CS49","CS 49", "Intro to Baby Code",4,"So sane."));
            add(new Course("BIO5000L","BIO 5000L", "Impossible Biology",4,"HARD FAIL."));
        }};
        super.setCppCourses(cpp);
        super.setTransferCourses(transfer);
    }
}
