package com.example.dimitri.cheapclass.data;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dimitri.cheapclass.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Dimitri on 7/14/2017.
 */

public class CourseSelectListAdapter extends ArrayAdapter {
    private Context context;
    private List<Course> courses;

    public CourseSelectListAdapter(
            @NonNull Context context, @LayoutRes int resource, @NonNull List<Course> objects){
        super(context, resource,objects);
        this.context = context;
        courses = objects;
    }

    @NonNull
    @Override
    public View getView(final int position,
                        @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(
                    R.layout.listview_item_course, parent, false);
        }

        TextView areaTextView = (TextView) convertView.findViewById(R.id.areaTextView);
        areaTextView.setText("A1");

        TextView courseCodeTextView = (TextView) convertView.findViewById(R.id.courseCodeTextView);
        courseCodeTextView.setText(courses.get(position).getCode());

        TextView courseNameTextView = (TextView) convertView.findViewById(R.id.courseNameTextView);
        courseNameTextView.setText(courses.get(position).getName());

        return convertView;
    }
}
