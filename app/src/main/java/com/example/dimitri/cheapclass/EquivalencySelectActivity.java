package com.example.dimitri.cheapclass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
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
        selectedCourse = ((CheapClassData) this.getApplication()).getSelectedCourse();
    }
}