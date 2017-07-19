package com.example.dimitri.cheapclass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.dimitri.cheapclass.data.CourseEquivalencyDataProvider;
import com.example.dimitri.cheapclass.data.CourseEquivalencyListAdapter;
import com.example.dimitri.cheapclass.data.CourseSelectListAdapter;
import com.example.dimitri.cheapclass.data.DummyCourseEquivalencyDataProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EquivalencySelectActivity extends AppCompatActivity {


    CourseEquivalencyDataProvider courseEquivalencyDataProvider;
    CourseSelectListAdapter courseSelectListAdapter;

    String selectedCourse;

    @BindView(R.id.courseEquivalencyListView)
    ListView courseEquivalencyListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equivalency_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);
        initialize();

        courseEquivalencyDataProvider = new DummyCourseEquivalencyDataProvider();

        CourseEquivalencyListAdapter courseEquivalencyListAdapter =
                new CourseEquivalencyListAdapter(this, R.layout.listview_item_equivalency,
                        courseEquivalencyDataProvider.getCourseEquivalencies(selectedCourse));
        courseEquivalencyListView.setAdapter(courseEquivalencyListAdapter);
    }

    private void initialize() {
        selectedCourse = ((CourseBridgeData) this.getApplication()).getSelectedCourse();
    }
}