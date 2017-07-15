package com.example.dimitri.cheapclass.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dimitri on 7/9/2017.
 */

public class DummySchoolDataProvider implements SchoolDataProvider {
    ArrayList<School> schools;

    public DummySchoolDataProvider() {

        schools = new ArrayList<School>() {{
            add(new School("PCC", "Pasadena City College"));
            add(new School("MTSAC", "Mount San Antonio College"));
        }};
    }

    @Override
    public List<School> getAllSchools() {
        return schools;
    }
}
