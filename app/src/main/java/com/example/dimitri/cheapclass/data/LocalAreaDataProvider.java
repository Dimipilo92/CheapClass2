package com.example.dimitri.cheapclass.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dimitri on 7/12/2017.
 */

public class LocalAreaDataProvider implements AreaDataProvider {
    ArrayList<Area> mAreas;

    public LocalAreaDataProvider() {

        mAreas = new ArrayList<Area>() {{
            add(new Area("all","All"));
            add(new Area("core","Major-Core"));
            add(new Area("support","Major-Support"));
            add(new Area("A1","A1: Oral Communications"));
            add(new Area("A2","A2: Written Communications"));
            add(new Area("A3","A3: Critical Thinking"));
            add(new Area("B1","B1: Physical Science"));
            add(new Area("B2","B2: Biological Sciences"));
            add(new Area("B3","#"));
            add(new Area("B4","B4: Mathematics/Quantitative Reasoning"));
            add(new Area("C1","C1: Visual and Performing Arts"));
            add(new Area("C2","C2: Philosophy and Civilizations"));
            add(new Area("C3","C3: Literature and Foreign Languages"));
            add(new Area("D1","D1: U.S. History, Constitution, and American Ideals"));
            add(new Area("D2","D2: History, Economics, and Political Science"));
            add(new Area("D3","D3: Sociology, Anthropology, Ethnic and Gender Studies"));
            add(new Area("E","Lifelong Understanding and Self Development"));
        }};
    }

    public List<Area> getAllAreas() {
        return mAreas;
    }
}
