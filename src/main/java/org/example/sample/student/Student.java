package org.example.sample.student;




import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student_tbl")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstname;

    String lastname;

    String phoneNumber;
}
