package com.example.dimitri.cheapclass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Spinner;

import com.example.dimitri.cheapclass.data.DummyMajorDataProvider;
import com.example.dimitri.cheapclass.data.DummySchoolDataProvider;
import com.example.dimitri.cheapclass.data.MajorDataProvider;
import com.example.dimitri.cheapclass.data.MajorSpinnerAdapter;
import com.example.dimitri.cheapclass.data.SchoolDataProvider;
import com.example.dimitri.cheapclass.data.SchoolSpinnerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dimitri on 7/8/2017.
 */

public class MajorAndSchoolSelectActivity extends AppCompatActivity {

    private MajorDataProvider mMajors;
    private SchoolDataProvider mSchools;

    @BindView(R.id.majorSpinner)
    Spinner majorSpinner;

    @BindView(R.id.schoolSpinner)
    Spinner schoolSpinner;

    @BindView(R.id.nextButton)
    Button nextButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_major_and_school_select);

        mMajors = new DummyMajorDataProvider();
        mSchools = new DummySchoolDataProvider();

        ButterKnife.bind(this);

        MajorSpinnerAdapter majorSpinnerAdapter = new MajorSpinnerAdapter(
                this, R.layout.spinner_item_major_and_school, mMajors.getAllMajors());
        majorSpinner.setAdapter(majorSpinnerAdapter);

        SchoolSpinnerAdapter schoolSpinnerAdapter = new SchoolSpinnerAdapter(
                this, R.layout.spinner_item_major_and_school, mSchools.getAllSchools());
        schoolSpinner.setAdapter(majorSpinnerAdapter);
    }

    @OnClick(R.id.nextButton)
    public void onNextButtonClick(){

    }
}