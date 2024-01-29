package org.example.sample.student;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

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

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }


}
