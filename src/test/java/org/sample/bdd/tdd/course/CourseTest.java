package org.sample.bdd.tdd.course;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

public class CourseTest {

    @Test
    public void constructor_shouldReturnCourseProperty() {

        int id=1;
        String courseName="tdd & bdd";
        boolean isOnline=true;
        long tuition=5000;
        Course course=new Course(id,courseName,isOnline,tuition);
        assertThat(id).isEqualTo(course.id);
        assertThat(courseName).isEqualTo(course.courseName);
        assertThat(isOnline).isEqualTo(course.isOnline);
        assertThat(tuition).isEqualTo(course.tuition);
//        Assert.assertEquals(id,course.id);
//        Assert.assertEquals(courseName,course.courseName);
//        Assert.assertEquals(isOnline,course.isOnline);
//        Assert.assertEquals(tuition,course.tuition);
    }

    @Test
    public void constructor_shouldReturnException_when_courseNameNotGivenProperty() throws Throwable {
        int id=1;
        String courseName="";
        boolean isOnline=true;
        long tuition=5000;
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Course(id,courseName,isOnline,tuition))
                .withMessage("CourseName Cant Be empty Or Null");
//        assertThrows(RuntimeException.class, () -> new Course(id,courseName,isOnline,tuition));

    }
}
