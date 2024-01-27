package org.example.sample.student;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;

    @Override
    public Student create(Student student) {
        return repository.save(student);
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> optionalStudent=repository.findById(id);
        if(!optionalStudent.isPresent())
            throw new IllegalArgumentException("student not found");
       return optionalStudent.get();
    }

    @Override
    public Student update(Student student) {
        Student lastStudent=findById(student.getId());
        lastStudent.setFirstname(student.getFirstname());
        lastStudent.setLastname(student.getLastname());
        lastStudent.setPhoneNumber(student.getPhoneNumber());
        return repository.save(lastStudent);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }


}
