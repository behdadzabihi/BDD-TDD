package org.sample.bdd.tdd.course;

import org.junit.function.ThrowingRunnable;

import java.util.ArrayList;
import java.util.List;

public class Course  {
    private int id;
    private String courseName;
    private boolean isOnline;
    private long tuition;

    private List<Section> sections;



    public Course(int id, String courseName, boolean isOnline, long tuition) {
        checkValidationForCourseName(courseName);
        checkValidationForTuition(tuition);
        this.id=id;
        this.courseName=courseName;
        this.isOnline=isOnline;
        this.tuition=tuition;
        sections=new ArrayList<>();
}



    public void checkValidationForCourseName(String courseName){
        if(courseName == null || courseName.isEmpty())
            throw new IllegalArgumentException("CourseName Cant Be empty Or Null");
    }


    public void checkValidationForTuition(long tuition){
        if(tuition <= 0)
            throw new IllegalArgumentException("Tuition Can Not Be Zero Or LessThan Zero");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public long getTuition() {
        return tuition;
    }

    public void setTuition(long tuition) {
        this.tuition = tuition;
    }


    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
