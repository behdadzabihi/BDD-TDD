package org.sample.bdd.tdd.course.repo;


import org.sample.bdd.tdd.course.unit.Course;

import java.util.List;


public interface CourseRepository {


    void create(Course course);
    Course save(Course course);


    List<Course> findAll();

     Course findById(int id);

     void delete(int id);

     Course getBy(String name);
}
