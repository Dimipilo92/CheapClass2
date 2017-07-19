package com.example.dimitri.cheapclass;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.dimitri.cheapclass.data.Course;
import com.example.dimitri.cheapclass.data.CourseDataProvider;
import com.example.dimitri.cheapclass.data.CourseSelectListAdapter;
import com.example.dimitri.cheapclass.data.DummyCourseDataProvider;
import com.example.dimitri.cheapclass.data.FirebaseCourseDataProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class CourseSelectActivity extends AppCompatActivity
        implements SearchView.OnQueryTextListener{

    CourseDataProvider courseDataProvider;
    CourseSelectListAdapter courseSelectListAdapter;

    String major;
    String area;
    String school;

    SearchView searchView;

    @BindView(R.id.courseSelectListView)
    ListView courseSelectListView;

    @BindView(R.id.emptyCourseSelectListView)
    LinearLayout emptyCourseSelectListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        initialize();
        courseDataProvider = new DummyCourseDataProvider();


        courseSelectListAdapter = new CourseSelectListAdapter(
                this, R.layout.listview_item_course, courseDataProvider.getCoursesInMajor(major));

        courseSelectListView.setAdapter(courseSelectListAdapter);
        courseSelectListView.setEmptyView(emptyCourseSelectListView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        MenuItem searchMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) searchMenuItem.getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
                
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        courseSelectListAdapter.getFilter().filter(newText);
        return true;
    }

    @OnItemClick(R.id.courseSelectListView)
    public void onCourseSelectItemClick(int position){
        Intent i = new Intent(this, EquivalencySelectActivity.class);
        Course selectedCourse = (Course) courseSelectListAdapter.getItem(position);
        ((CourseBridgeData) this.getApplication()).setSelectedCourse(selectedCourse.getId());
        startActivity(i);
    }

    
    private void initialize() {
        major = ((CourseBridgeData) this.getApplication()).getMajor();
        school = ((CourseBridgeData) this.getApplication()).getSchool();
        area = ((CourseBridgeData) this.getApplication()).getArea();
    }

    /*
    @Override
    public void onContentChanged() {
        super.onContentChanged();
        if (courseSelectListView != null) {
            courseSelectListView.setEmptyView(emptyCourseSelectListView);
        }
    }*/
}
