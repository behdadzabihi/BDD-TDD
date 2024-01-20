package org.sample.bdd.tdd.course.service;

import org.sample.bdd.tdd.course.unit.Course;
import org.sample.bdd.tdd.course.unit.CreateCourse;

import java.util.List;

public interface CourseService {

    int create(CreateCourse course);

    CreateCourse update(CreateCourse course);

    void delete(int id);

    List<Course> findAll();
}
