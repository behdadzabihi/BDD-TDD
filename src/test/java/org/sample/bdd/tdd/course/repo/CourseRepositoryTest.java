package org.sample.bdd.tdd.course.repo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.sample.bdd.tdd.course.unit.Course;
import org.sample.bdd.tdd.course.unit.CourseTestBuilder;
import org.sample.bdd.tdd.course.unit.Section;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CourseRepositoryTest {


    CourseTestBuilder builder=new CourseTestBuilder();

    CourseRepositoryImpl courseRepositoryImpl =new CourseRepositoryImpl();
    @Test
    public void section_shouldReturnList_IsNotNullOrEmpty(){
        int id=1;
        String sectionName="tdd section";
        Section section=new Section(id,sectionName);
        Course course=builder.build();
        List<Section> sections=new ArrayList<>();
        sections.add(section);
        course.setSections(sections);
        Assertions.assertThat(sections).isEqualTo(course.getSections());
    }


    @Test
    public void should_addNewCourseTOCourseList(){
        //arrange
        Course course=builder.build();

        //act
        courseRepositoryImpl.create(course);
        //assert
        Assertions.assertThat(courseRepositoryImpl.courses).contains(course);

    }

    @Test
    public void should_equalCourseWithId(){
        //arrange
        Course course1=builder.withId(1).build();
        Course course2=builder.withId(1).build();

        //assert
        assertThat(course1).isEqualTo(course2);

    }

    @Test
    public void should_courseNotBeNull(){
        //arrange

        Course course=builder.build();

        //assert
        assertThat(course).isNotNull();

    }

    @Test
    public void should_returnAListOfCourse(){

        //act
        Collection<Course> courses= courseRepositoryImpl.findAll();

        //assert
        assertThat(courses).isEmpty();
    }

    @Test
    public void should_returnCourseById(){

        //arrange
        int id=0;
        Course course=builder.withId(id).build();
        courseRepositoryImpl.create(course);

        //act
        Course actual= courseRepositoryImpl.findById(id);

        //assert
        assertThat(actual).isNotNull();
    }

    @Test
    public void should_deleteCourseById(){

        //arrange
        int id=0;
        Course course=builder.withId(id).build();
        courseRepositoryImpl.create(course);

        //act
        courseRepositoryImpl.delete(id);

        //assert
        Assertions.assertThat(courseRepositoryImpl.courses).doesNotContain(course);
    }

}
