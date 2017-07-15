package com.example.dimitri.cheapclass;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.dimitri.cheapclass.R;
import com.example.dimitri.cheapclass.data.CourseDataProvider;
import com.example.dimitri.cheapclass.data.CourseSelectListAdapter;
import com.example.dimitri.cheapclass.data.DummyCourseDataProvider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class CourseSelectActivity extends AppCompatActivity {

    
    CourseDataProvider courses;
    String major;
    String area;
    String school;

    SearchView searchView;

    @BindView(R.id.courseSelectList)
    ListView courseSelectList;

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

        getMetaData();
        courses = new DummyCourseDataProvider();


        CourseSelectListAdapter courseSelectListAdapter = new CourseSelectListAdapter(
                this, R.layout.listview_item_course, courses.getCoursesInArea(major, area));
        courseSelectList.setAdapter(courseSelectListAdapter);

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
        //searchView.setOnQueryTextListener(this);
                
        return super.onCreateOptionsMenu(menu);
    }

    @OnItemClick(R.id.courseSelectList)
    public void onCourseSelectItemClick(){
        Intent i = new Intent(this, EquivalencySelect.class);
        //i.putExtra("major","CS");
        //i.putExtra("school",school.getId());
        //i.putExtra("area",area.getId());
        startActivity(i);
    }

    
    private void getMetaData() {
        major = "CS";
        school = "PCC";
        area = "A1";
    }
}
