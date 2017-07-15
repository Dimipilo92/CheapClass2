package com.example.dimitri.cheapclass.data;

/**
 * Created by Dimitri on 7/2/2017.
 */

public class Course {

    private String id;
    private String code;
    private String name;
    private int units;
    private String description;

    public Course(String code, String name, int units, String description) {
        this.code = code;
        this.name = name;
        this.units = units;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
