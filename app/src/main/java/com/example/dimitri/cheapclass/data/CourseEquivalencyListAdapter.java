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

import java.util.List;

/**
 * Created by Dimitri on 7/13/2017.
 */

public class CourseEquivalencyListAdapter extends ArrayAdapter {
    private Context context;
    private List<CourseEquivalency> equivalencies;

    public CourseEquivalencyListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<CourseEquivalency> objects){
        super(context, resource,objects);
        this.context = context;
        equivalencies = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listview_item_equivalency, parent, false);
        }
        return convertView;
    }
}
