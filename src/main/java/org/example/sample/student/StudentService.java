package org.example.sample.student;

public interface StudentService {

    Student create(Student student);

    Student findById(Long id);

    Student update(Student student);

    void deleteById(Long id);
}
