package org.sample.bdd.tdd.course.unit;

public class CourseTestBuilder {

    int id=1;
    String courseName="tdd & bdd";
    boolean isOnline=true;
    long tuition=5000;

    public Course build(){
        return new Course(id,courseName,isOnline,tuition);
    }



    public CourseTestBuilder withCourseName(String courseName){
        this.courseName=courseName;
        return this;
    }

    public CourseTestBuilder withTuition(long tuition){
        this.tuition=tuition;
        return this;
    }
    public CourseTestBuilder withId(int id) {
        this.id=id;
        return this;
    }

}
