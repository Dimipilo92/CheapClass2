package com.example.dimitri.cheapclass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.dimitri.cheapclass.data.Area;
import com.example.dimitri.cheapclass.data.AreaDataProvider;
import com.example.dimitri.cheapclass.data.DummyMajorDataProvider;
import com.example.dimitri.cheapclass.data.DummySchoolDataProvider;
import com.example.dimitri.cheapclass.data.LocalAreaDataProvider;
import com.example.dimitri.cheapclass.data.Major;
import com.example.dimitri.cheapclass.data.MajorDataProvider;
import com.example.dimitri.cheapclass.data.School;
import com.example.dimitri.cheapclass.data.SchoolDataProvider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dimitri on 7/8/2017.
 */

public class MajorAndSchoolSelectActivity extends AppCompatActivity {

    private MajorDataProvider mMajors;
    private SchoolDataProvider mSchools;
    private AreaDataProvider mAreas;

    @BindView(R.id.majorSpinner)
    Spinner majorSpinner;

    @BindView(R.id.schoolSpinner)
    Spinner schoolSpinner;

    @BindView(R.id.areaSpinner)
    Spinner areaSpinner;

    @BindView(R.id.nextButton)
    Button nextButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_major_school_and_area_select);

        mMajors = new DummyMajorDataProvider();
        mSchools = new DummySchoolDataProvider();
        mAreas = new LocalAreaDataProvider();

        ButterKnife.bind(this);

        ArrayAdapter<Major> majorAdapter = new ArrayAdapter<Major>(this, // create custom adapter class to use custom layout.
                android.R.layout.simple_spinner_item, mMajors.getAllMajors());
        majorSpinner.setAdapter(majorAdapter);

        ArrayAdapter<School> schoolAdapter = new ArrayAdapter<School>(this,
                android.R.layout.simple_spinner_item, mSchools.getAllSchools());
        schoolSpinner.setAdapter(schoolAdapter);

        ArrayAdapter<Area> areaAdapter = new ArrayAdapter<Area>(this,
                android.R.layout.simple_spinner_item, mAreas.getAllAreas());
        areaSpinner.setAdapter(areaAdapter);
    }

    @OnClick(R.id.nextButton)
    public void onNextButtonClick(){

    }
}