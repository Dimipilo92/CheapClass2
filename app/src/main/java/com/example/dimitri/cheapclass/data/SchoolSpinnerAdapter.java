package com.example.dimitri.cheapclass.data;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dimitri.cheapclass.R;

import java.util.List;

/**
 * Created by Dimitri on 7/9/2017.
 */



public class SchoolSpinnerAdapter extends ArrayAdapter<School>{ // ArrayAdapter<School>
    private Context mContext;
    private List<School> mSchools;

    public SchoolSpinnerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<School> objects){
        super(context, resource,objects);
        mContext = context;
        mSchools = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.spinner_item_major_and_school, parent, false);
        }

        // this shoots a warning about non-conditional inflation
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setText(mSchools.get(position).getName());

        return convertView;
    }

    @NonNull
    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.spinner_item_major_and_school, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setText(mSchools.get(position).getName());
        return convertView;
    }
}
