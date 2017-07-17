package com.example.dimitri.cheapclass.data;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dimitri.cheapclass.R;

import java.util.List;

/**
 * Created by Dimitri on 7/13/2017.
 */

public class CourseEquivalencyListAdapter extends ArrayAdapter {
    private Context context;
    private List<CourseEquivalency> equivalencyList;

    LinearLayout cppCourseLayout;
    LinearLayout transferCourseLayout;

    public CourseEquivalencyListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<CourseEquivalency> objects){
        super(context, resource,objects);
        this.context = context;
        equivalencyList = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.listview_item_equivalency, parent, false);
        }


        cppCourseLayout = (LinearLayout) convertView.findViewById(R.id.cppCourseLayout);
        cppCourseLayout.removeAllViews();

        transferCourseLayout = (LinearLayout) convertView.findViewById(R.id.transferCourseLayout);
        transferCourseLayout.removeAllViews();

        List<Course> cppCourseList = equivalencyList.get(position).getCppCourses();
        List<Course> transferCourseList = equivalencyList.get(position).getTransferCourses();

        inflateCourseLayout(layoutInflater,position,cppCourseList, cppCourseLayout);
        inflateCourseLayout(layoutInflater,position,transferCourseList, transferCourseLayout);

        return convertView;
    }


    private void inflateCourseLayout(LayoutInflater layoutInflater,
                                   int position, List<Course> courseList,
                                   LinearLayout targetLayout) {
        for (Course course : courseList) {
            View child = layoutInflater.inflate(R.layout.layout_item_equivalency_course, null);

            TextView equivalencyCourseCode = (TextView) child.findViewById(
                    R.id.equivalencyCourseCode);
            equivalencyCourseCode.setText(course.getCode());
            targetLayout.addView(child);
        }
    }

}
