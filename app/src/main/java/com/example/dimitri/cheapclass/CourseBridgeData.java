package com.example.dimitri.cheapclass;

import android.app.Application;

/**
 * Created by Dimitri on 7/16/2017.
 */

public class CourseBridgeData extends Application {
    private static CourseBridgeData application;

    String major;
    String school;
    String area;
    String selectedCourse;


    public CourseBridgeData getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(String selectedCourse) {
        this.selectedCourse = selectedCourse;
    }
}
