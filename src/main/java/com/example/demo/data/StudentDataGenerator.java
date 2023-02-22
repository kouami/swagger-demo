package com.example.demo.data;

import com.example.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class StudentDataGenerator {

    public CommandLineRunner loadData(StudentRepository studentRepository) {
        return args -> {
            Student s1 = new Student();
            //s1.setId(100);
            s1.setGender("M");
            s1.setName("Emmanuel");

            Student s2 = new Student();
            //s2.setId(200);
            s2.setGender("F");
            s2.setName("Ashok");

            studentRepository.save(s1);
            studentRepository.save(s2);
        };
    }
}
