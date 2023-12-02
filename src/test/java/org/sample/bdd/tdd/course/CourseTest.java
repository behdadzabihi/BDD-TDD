package org.sample.bdd.tdd.course;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<Section> sections=new ArrayList<>();
        Course course=new Course(id,courseName,isOnline,tuition);

        //with AssertJ
        assertThat(id).isEqualTo(course.getId());
        assertThat(courseName).isEqualTo(course.getCourseName());
        assertThat(isOnline).isEqualTo(course.isOnline());
        assertThat(tuition).isEqualTo(course.getTuition());
        assertThat(sections).isEqualTo(course.getSections()).isEmpty();
    //with Assert class
//        Assert.assertEquals(id,course.id);
//        Assert.assertEquals(courseName,course.courseName);
//        Assert.assertEquals(isOnline,course.isOnline);
//        Assert.assertEquals(tuition,course.tuition);
    }

    @Test
    public void constructor_shouldReturnException_when_courseNameNotGivenProperty()  {
        CourseTestBuilder courseTestBuilder=new CourseTestBuilder();
        //with AssertJ
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> courseTestBuilder.withCourseName("").build())
                .withMessage("CourseName Cant Be empty Or Null");

        //with Assert class
//        assertThrows(RuntimeException.class, () -> courseTestBuilder.withCourseName("").build());

    }

    @Test
    public void constructor_shouldReturnException_when_Tuition_isZero_or_lessThan_zero(){
        CourseTestBuilder courseTestBuilder=new CourseTestBuilder();
        //with AssertJ
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> courseTestBuilder.withTuition(0).build())
                .withMessage("Tuition Can Not Be Zero Or LessThan Zero");

        //with Assert class
//        assertThrows(RuntimeException.class, () -> courseTestBuilder.withTuition(0).build());
    }
}
