package com.example.dimitri.cheapclass.data;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.dimitri.cheapclass.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dimitri on 7/14/2017.
 */

public class CourseSelectListAdapter extends ArrayAdapter implements Filterable{
    private Context context;
    private List<Course> courseList;
    private List<Course> filteredCourseList;
    private CourseFilter courseFilter;

    public CourseSelectListAdapter(
            @NonNull Context context, @LayoutRes int resource, @NonNull List<Course> objects){
        super(context, resource,objects);
        this.context = context;
        courseList = objects;
        filteredCourseList = objects;

        getFilter();
    }

    @Override
    public int getCount() {
        return filteredCourseList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return filteredCourseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
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
        courseCodeTextView.setText(filteredCourseList.get(position).getCode());

        TextView courseNameTextView = (TextView) convertView.findViewById(R.id.courseNameTextView);
        courseNameTextView.setText(filteredCourseList.get(position).getName());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (courseFilter == null) {
            courseFilter = new CourseFilter();
        }

        return courseFilter;
    }

    private class CourseFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint!=null && constraint.length()>0) {
                List<Course> resultsList = new ArrayList<>();

                for (Course course : courseList) {
                    String stringToSearch = course.getCode() + " " + course.getName();
                    if (stringToSearch.toLowerCase()
                            .contains(constraint.toString().toLowerCase().trim())) {
                        resultsList.add(course);
                    }
                }

                filterResults.count = resultsList.size();
                filterResults.values = resultsList;
            } else {
                filterResults.count = courseList.size();
                filterResults.values = courseList;
            }

            return filterResults;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredCourseList = (ArrayList<Course>) results.values;
            notifyDataSetChanged();
        }
    }
}
