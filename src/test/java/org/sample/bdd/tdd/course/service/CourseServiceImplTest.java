package org.sample.bdd.tdd.course.service;

import org.assertj.core.api.ThrowableAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.sample.bdd.tdd.course.unit.Course;
import org.sample.bdd.tdd.course.unit.CourseTestBuilder;
import org.sample.bdd.tdd.course.unit.CreateCourse;
import org.sample.bdd.tdd.course.repo.CourseRepositoryImpl;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceImplTest {

    @Mock
    CourseRepositoryImpl courseRepository;

    @InjectMocks
    CourseServiceImpl courseServiceImpl;

    @Test
    public void should_createNewCourse() {
        // Arrange
        CreateCourse createCourse=new CreateCourse(1,"java",true,500);

        // Act
        courseServiceImpl.create(createCourse);

        // Assert
        verify(courseRepository, times(1)).create(any(Course.class));
    }

    @Test
    public void should_createNewCourseAndReturnCourseID() {
        // Arrange
        CreateCourse createCourse=new CreateCourse(1,"java",true,500);

        // Act
        int id= courseServiceImpl.create(createCourse);

        // Assert
        assertThat(id).isEqualTo(createCourse.getId());
    }

    @Test
    public void should_throwExceptionWhenCourseNameIsDuplicated() {
        // Arrange
        CreateCourse createCourse=new CreateCourse(1,"java",true,500);

        //The reason for this is that if we don't do this because our Mock object was created
        // from the repository, and it is not real, then we have to initialize it with the
        // course data to understand that it has already been created and return it to us.
        CourseTestBuilder builder=new CourseTestBuilder();
        Course course=builder.build();
        when(courseRepository.getBy(any(String.class))).thenReturn(course);

        // Act
        ThrowableAssert.ThrowingCallable actual = () -> courseServiceImpl.create(createCourse);

        // Assert
        assertThatThrownBy(actual)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void should_updateCourse(){
        //arrange
        CreateCourse createCourse=new CreateCourse(1,"java",true,500);

        //act
        CreateCourse course=courseServiceImpl.update(createCourse);

        //assert
        Assert.assertEquals(course.getId(), createCourse.getId());
    }

    @Test
    public void should_deleteCourse(){
        //arrange
       int id=12;

        //act
       courseServiceImpl.delete(id);

    }

    @Test
    public void should_returnAListOfCourses(){

        //act
        List<Course> expectedList=courseServiceImpl.findAll();

        assertThat(expectedList).isEmpty();
    }
}
