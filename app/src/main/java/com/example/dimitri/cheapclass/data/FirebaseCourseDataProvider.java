package com.example.dimitri.cheapclass.data;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dimitri on 7/19/2017.
 */

public class FirebaseCourseDataProvider implements CourseDataProvider {

    List<Course> courseList;
    static Map<String,Course > cppCourseList;

    public FirebaseCourseDataProvider(){
        cppCourseList = new HashMap<>();
        courseList = new ArrayList<>();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference = firebaseDatabase.getReference("cpp/courses");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //cppCourseList =
                Log.e("Constructor","In onDataChange");
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Course course = ds.getValue(Course.class);
                    cppCourseList.put(ds.getKey(), course);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Constructor","The read failed: " + databaseError.getCode());
            }
        });

    }

    @Override
    public List<Course> getAllCourses() {
        return null;
    }

    @Override
    public List<Course> getCoursesInMajor(String major) {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference = firebaseDatabase.getReference(
                "cpp/majors/" + major + "/courses");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("getCoursesInMajor","In onDataChange");
                DataSnapshot coreDS = dataSnapshot.child("core");
                DataSnapshot supportDS = dataSnapshot.child("support");
                for(DataSnapshot ds : coreDS.getChildren()) {
                    Log.e("getCoursesInMajor","Data:" + ds.getValue());
                    String courseId = (String) ds.getValue();
                    courseList.add(cppCourseList.get(courseId));
                }
                for(DataSnapshot ds : supportDS.getChildren()) {
                    Log.e("getCoursesInMajor","Data:" + ds.getValue());
                    String courseId = (String) ds.getValue();
                    courseList.add(cppCourseList.get(courseId));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("getCoursesInMajor","The read failed: " + databaseError.getCode());
            }
        });

        return courseList;
    }

    @Override
    public List<Course> getCoursesInArea(String major, String Area){
        return null;
    }

    @Override
    public Course getCourse(String id){
        return cppCourseList.get(id);
    }
}
