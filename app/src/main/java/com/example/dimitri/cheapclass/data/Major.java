package com.example.dimitri.cheapclass.data;

/**
 * Created by Dimitri on 7/9/2017.
 */

public class Major {
    private String mCode;
    private String mName;

    Major(String code, String name){
        mCode = code;
        mName = name;
    }


    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        this.mCode = code;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }
}
