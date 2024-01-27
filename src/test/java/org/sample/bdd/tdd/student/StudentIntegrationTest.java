package org.sample.bdd.tdd.student;

import org.example.sample.Application;
import org.example.sample.student.Student;

import org.example.sample.student.StudentService;


import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@RunWith(SpringRunner.class)
public class StudentIntegrationTest {



     @Mock
     StudentService studentService;

     @Before
     public void init(){
         MockitoAnnotations.initMocks(this);
     }



    @Test
    public void should_createNewStudent(){

        //arrange
        Student expected=new Student();
        expected.setFirstname("test");
        expected.setLastname("test");
        expected.setPhoneNumber("09307550091");

        when(studentService.create(any(Student.class))).thenReturn(expected);

        //act
        Student actual=studentService.create(expected);

        //assert
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void should_updateStudent(){

        // Arrange
        Student initialStudent = new Student();
        initialStudent.setId(1L);
        initialStudent.setFirstname("old");
        initialStudent.setLastname("old");
        initialStudent.setPhoneNumber("old");

        when(studentService.create(any(Student.class))).thenAnswer(invocation -> invocation.getArgument(0));
        // Save the initial student to the database
        Student savedStudent = studentService.create(initialStudent);

        // Create an updated student with new values
        Student updatedStudent = new Student();
        updatedStudent.setId(savedStudent.getId());
        updatedStudent.setFirstname("new");
        updatedStudent.setLastname("new");
        updatedStudent.setPhoneNumber("new");

        when(studentService.update(any(Student.class))).thenReturn(updatedStudent);

        // Act
        Student result = studentService.update(updatedStudent);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(savedStudent.getId());
        assertThat(result.getFirstname()).isEqualTo(updatedStudent.getFirstname());
        assertThat(result.getLastname()).isEqualTo(updatedStudent.getLastname());
        assertThat(result.getPhoneNumber()).isEqualTo(updatedStudent.getPhoneNumber());
    }



    @Test
    public void should_returnStudentById(){

        //arrange
        Long id=2L;
        Student expected=new Student();
        expected.setId(id);

        when(studentService.findById(id)).thenReturn(expected);

        //act
        Student actual=studentService.findById(id);

        //assert
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isEqualTo(id);
    }

    @Test
    public void should_deleteStudent(){

        //arrange
        Long id=11L;

        //act
        studentService.deleteById(id);

        //assert
        verify(studentService).deleteById(id);

    }



    //@Autowired
    //StudentService studentService;

    //
//    @Test
//    public void should_createNewStudent(){
//
//        //arrange
//        Student expected=new Student();
//        expected.setFirstname("test");
//        expected.setLastname("test");
//        expected.setPhoneNumber("09307550091");
//
//        //act
//        Student actual=studentService.create(expected);
//
//        //assert
//        assertThat(actual).isEqualTo(expected);
//
//    }



    //    @Test
//    public void should_returnStudentById(){
//
//        //arrange
//        Long id=2L;
//
//        //act
//        Student actual=studentService.findById(id);
//
//        //assert
//        assertThat(actual).isNotNull();
//        assertThat(actual.getId()).isEqualTo(id);
//    }



    //    @Test
//    public void should_updateStudent(){
//
//            // Arrange
//            Student initialStudent = new Student();
//            initialStudent.setFirstname("old");
//            initialStudent.setLastname("old");
//            initialStudent.setPhoneNumber("old");
//
//            // Save the initial student to the database
//            Student savedStudent = studentService.create(initialStudent);
//
//            // Create an updated student with new values
//            Student updatedStudent = new Student();
//            updatedStudent.setId(savedStudent.getId());
//            updatedStudent.setFirstname("new");
//            updatedStudent.setLastname("new");
//            updatedStudent.setPhoneNumber("new");
//
//            // Act
//            Student result = studentService.update(updatedStudent);
//
//            // Assert
//            assertThat(result).isNotNull();
//            assertThat(result.getId()).isEqualTo(savedStudent.getId());
//            assertThat(result.getFirstname()).isEqualTo(updatedStudent.getFirstname());
//            assertThat(result.getLastname()).isEqualTo(updatedStudent.getLastname());
//            assertThat(result.getPhoneNumber()).isEqualTo(updatedStudent.getPhoneNumber());
//    }


}
