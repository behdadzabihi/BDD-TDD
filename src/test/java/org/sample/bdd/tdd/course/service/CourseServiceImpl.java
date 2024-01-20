package org.sample.bdd.tdd.course.service;


import org.sample.bdd.tdd.course.unit.Course;
import org.sample.bdd.tdd.course.unit.CreateCourse;
import org.sample.bdd.tdd.course.unit.CourseTestBuilder;
import org.sample.bdd.tdd.course.repo.CourseRepository;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;

    CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }

    public int create(CreateCourse course) {
        if(courseRepository.getBy(course.getCourseName()) != null)
            throw new IllegalArgumentException("COURSE NAME NOT BE DUPLICATE");
        Course test=new Course(course.getId(),course.getCourseName(),course.isOnline(),course.getTuition());
        courseRepository.create(test);
        return test.getId();
    }

    @Override
    public CreateCourse update(CreateCourse course) {
        CourseTestBuilder courseTestBuilder=new CourseTestBuilder();
        Course lastCourse=courseTestBuilder.build();
        lastCourse.setId(course.getId());
        lastCourse.setCourseName(course.getCourseName());
        lastCourse.setOnline(course.isOnline());
        lastCourse.setTuition(course.getTuition());
        courseRepository.save(lastCourse);
        return  course;
    }

    @Override
    public void delete(int id) {
        courseRepository.delete(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
