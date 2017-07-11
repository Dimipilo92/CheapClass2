package com.example.dimitri.cheapclass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Dimitri on 7/8/2017.
 */

public class EquivalencySelectPageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_equivalency_select_page, container, false);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public static EquivalencySelectPageFragment newInstance(Bundle b) {

        EquivalencySelectPageFragment f = new EquivalencySelectPageFragment();
        f.setArguments(b);

        return f;
    }
}
