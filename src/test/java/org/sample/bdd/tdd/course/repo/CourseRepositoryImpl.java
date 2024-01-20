package org.sample.bdd.tdd.course.repo;

import org.sample.bdd.tdd.course.unit.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepositoryImpl implements CourseRepository {
    public static List<Course> courses=new ArrayList<>();

    public CourseRepositoryImpl(){
        courses.add(new Course(1,"java",true,5400));
    }


    public void create(Course course) {
       course.setId(course.getId());
       course.setCourseName(course.getCourseName());
       course.setOnline(course.isOnline());
       course.setTuition(course.getTuition());
       courses.add(course);

    }

    @Override
    public Course save(Course course) {
        course.setId(course.getId());
        course.setCourseName(course.getCourseName());
        course.setOnline(course.isOnline());
        course.setTuition(course.getTuition());
        courses.add(course);
        return course;
    }


    public List<Course> findAll() {
        return courses;
    }

    public Course findById(int id) {
        return courses.get(id);
    }

    public void delete(int id) {
        findById(id);
        courses.remove(id);
    }

    @Override
    public Course getBy(String name) {
        Optional<Course> optionalCourse=courses.stream()
                .filter(course-> course.getCourseName().equals(name))
                .findFirst();
        if(optionalCourse.isPresent())
            throw new IllegalArgumentException("Course is not null");
        return optionalCourse.get();
    }
}
