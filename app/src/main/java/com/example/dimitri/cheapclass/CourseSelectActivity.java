package com.example.dimitri.cheapclass;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.dimitri.cheapclass.data.Course;
import com.example.dimitri.cheapclass.data.CourseDataProvider;
import com.example.dimitri.cheapclass.data.CourseSelectListAdapter;
import com.example.dimitri.cheapclass.data.DummyCourseDataProvider;

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
        courseDataProvider = new DummyCourseDataProvider();


        courseSelectListAdapter = new CourseSelectListAdapter(
                this, R.layout.listview_item_course, courseDataProvider.getCoursesInArea(major, area));
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
        ((CheapClassData) this.getApplication()).setSelectedCourse(selectedCourse.getId());
        startActivity(i);
    }

    
    private void initialize() {
        major = ((CheapClassData) this.getApplication()).getMajor();
        school = ((CheapClassData) this.getApplication()).getSchool();
        area = ((CheapClassData) this.getApplication()).getArea();
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
