package com.example.dimitri.cheapclass.data;

/**
 * Created by Dimitri on 7/12/2017.
 */

public abstract class SimpleSchoolAttribute {

    private String mCode;
    private String mName;
    SimpleSchoolAttribute(String code, String name){
        mCode = code;
        mName = name;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String mCode) {
        this.mCode = mCode;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    @Override
    public String toString() {
        return mName;
    }

}
