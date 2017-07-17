package com.example.dimitri.cheapclass;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

public class MajorSchoolAndAreaSelectActivity extends AppCompatActivity {

    private MajorDataProvider majorDataProvider;
    private SchoolDataProvider schoolDataProvider;
    private AreaDataProvider areaDataProvider;

    ArrayAdapter<Major> majorAdapter;
    ArrayAdapter<School> schoolAdapter;
    ArrayAdapter<Area> areaAdapter;

    @BindView(R.id.majorAutoCompleteView)
    AutoCompleteTextView majorAutoCompleteView;

    @BindView(R.id.schoolSpinner)
    Spinner schoolSpinner;

    @BindView(R.id.areaSpinner)
    Spinner areaSpinner;

    @BindView(R.id.nextButton)
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major_school_and_area_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        ButterKnife.bind(this);

        majorDataProvider = new DummyMajorDataProvider();
        schoolDataProvider = new DummySchoolDataProvider();
        areaDataProvider = new LocalAreaDataProvider();

        majorAdapter = new ArrayAdapter<Major>(this, // create custom adapter class to use custom layout.
                android.R.layout.simple_spinner_item, majorDataProvider.getAllMajors());
        majorAutoCompleteView.setAdapter(majorAdapter);

        schoolAdapter = new ArrayAdapter<School>(this,
                android.R.layout.simple_spinner_item, schoolDataProvider.getAllSchools());
        schoolSpinner.setAdapter(schoolAdapter);

        areaAdapter = new ArrayAdapter<Area>(this,
                android.R.layout.simple_spinner_item, areaDataProvider.getAllAreas());
        areaSpinner.setAdapter(areaAdapter);
    }

    @OnClick(R.id.majorAutoCompleteView)
    public void onMajorAutoCompleteViewClick (){
        majorAutoCompleteView.showDropDown();
    }

    @OnClick(R.id.nextButton)
    public void onNextButtonClick(){

        //String majorName = (String) majorAutoCompleteView.getText();
        School school = (School)schoolSpinner.getSelectedItem();
        Area area = (Area) areaSpinner.getSelectedItem();

        Intent i = new Intent(this, CourseSelectActivity.class);
        ((CheapClassData) this.getApplication()).setMajor("CS");
        ((CheapClassData) this.getApplication()).setSchool(school.getId());
        ((CheapClassData) this.getApplication()).setArea(area.getId());
        startActivity(i);
    }
}
