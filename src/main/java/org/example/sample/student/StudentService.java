package org.example.sample.student;

import java.util.List;

public interface StudentService {

    Student create(Student student);

    Student findById(Long id);

    Student update(Student student);

    void deleteById(Long id);

    List<Student> findAll();
}
