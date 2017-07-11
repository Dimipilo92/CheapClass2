package com.example.dimitri.cheapclass.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dimitri on 7/9/2017.
 */

public class DummyMajorDataProvider implements MajorDataProvider {

    private List<Major> mMajors;

    public DummyMajorDataProvider() {

        mMajors = new ArrayList<Major>() {{
            add(new Major("CS", "Computer Science"));
            add(new Major("CS", "Computer Science"));
            add(new Major("CS", "Computer Science"));
            add(new Major("CS", "Computer Science"));
            add(new Major("CS", "Computer Science"));
            add(new Major("CS", "Computer Science"));
            add(new Major("CS", "Computer Science"));
            add(new Major("CS", "Computer Science"));
        }};
    }

    @Override
    public List<Major> getAllMajors() {
        return mMajors;
    }
}
