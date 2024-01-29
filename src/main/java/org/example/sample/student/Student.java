package org.example.sample.student;




import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student_tbl")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonDeserialize(using = NumberDeserializers.LongDeserializer.class)
    Long id;

    String firstname;

    String lastname;

    String phoneNumber;
}
