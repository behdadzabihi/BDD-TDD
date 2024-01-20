package org.sample.bdd.tdd.course.unit;

import lombok.Getter;

public class CreateCourse {

    @Getter
    private int id;
    @Getter
    private String courseName;
    private boolean isOnline;
    @Getter
    private long tuition;

    public CreateCourse(int id, String courseName, boolean isOnline, long tuition) {
        this.id = id;
        this.courseName = courseName;
        this.isOnline = isOnline;
        this.tuition = tuition;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setTuition(long tuition) {
        this.tuition = tuition;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CreateCourse))
            return false;

        return ((CreateCourse) obj).getId() == this.id;
    }
}
