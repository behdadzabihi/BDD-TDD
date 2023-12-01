package org.sample.bdd.tdd.course;

import org.junit.function.ThrowingRunnable;

public class Course  {
    int id;
    String courseName;
    boolean isOnline;
    long tuition;
    public Course(int id, String courseName, boolean isOnline, long tuition) {
        if(courseName == null || courseName.isEmpty()){
            throw new IllegalArgumentException("CourseName Cant Be empty Or Null");
        }
        this.id=id;
        this.courseName=courseName;
        this.isOnline=isOnline;
        this.tuition=tuition;
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



}
