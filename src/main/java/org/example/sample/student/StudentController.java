package org.example.sample.student;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.List;


@RestController
@AllArgsConstructor
public class StudentController {


   private StudentService service;

    @PostMapping(value = "/create")
    public ResponseEntity<Student> create(@RequestBody Student student){
        Student createdStudent = service.create(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping("/findBy/{id}")
    public ResponseEntity<Student> findBy(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> update(@RequestBody Student student){
        return ResponseEntity.ok(service.update(student));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
//    @Produces(value = MediaType.APPLICATION_JSON)
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
