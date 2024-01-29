package org.example.sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.sample.student.Student;
import org.example.sample.student.StudentController;
import org.example.sample.student.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void should_createNewStudent() throws Exception {
        Student student = new Student();
        student.setId(12L);
        student.setFirstname("John");
        student.setLastname("Doe");
        student.setPhoneNumber("1234567890");

        // Act
         mockMvc.perform(post("/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andReturn();

    }


    @Test
    public void should_returnAStudentById() throws Exception {
        Long id=1L;
        Student student = new Student();
        student.setId(id);
        student.setFirstname("John");
        student.setLastname("Doe");
        student.setPhoneNumber("1234567890");

        when(service.findById(id)).thenReturn(student);

        mockMvc.perform(get("/findBy/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void should_updateStudent() throws Exception {
        Long studentId = 2L;
        Student oldStudent = new Student();
        oldStudent.setId(studentId);
        oldStudent.setFirstname("Old");
        oldStudent.setLastname("Student");
        oldStudent.setPhoneNumber("1234567890");

        Student newStudent = new Student();
        newStudent.setId(studentId);
        newStudent.setFirstname("New");
        newStudent.setLastname("Student");
        newStudent.setPhoneNumber("0987654321");
        given(service.update(any(Student.class))).willReturn(newStudent);

        mockMvc.perform(put("/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(newStudent)));

    }

    @Test
    public void should_deleteStudentWithId() throws Exception {
        Long id=1L;

        doNothing().when(service).deleteById(any(Long.class));

        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    public void should_returnListOfAllStudent() throws Exception {
        //arrange
        List<Student> students=new ArrayList<>();
        Student student1 = new Student();
        student1.setId(1L);
        student1.setFirstname("John");
        student1.setLastname("Doe");
        student1.setPhoneNumber("1234567890");
        Student student2 = new Student();
        student2.setId(2L);
        student2.setFirstname("Johmn");
        student2.setLastname("Dmoe");
        student2.setPhoneNumber("12345167890");
        students.add(student1);
        students.add(student2);

        //act
        when(service.findAll()).thenReturn(students);

        mockMvc.perform(get("/findAll"))
                .andExpect(status().isOk())
                .andReturn();
    }
}

