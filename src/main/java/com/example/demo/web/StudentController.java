package com.example.demo.web;

import com.example.demo.data.StudentDataGenerator;
import com.example.demo.data.StudentRepository;
import com.example.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
    public List<Student> listStudents() {
        System.out.println("SIZE::: " + studentRepository.findAll().size());
        return studentRepository.findAll();
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        studentRepository.save(student);
        System.out.println("SIZE::: " + studentRepository.findAll().size());
        return student;
    }

    @DeleteMapping(path = { "/{id}" })
    public boolean delete(@PathVariable("id") Long id) {
        boolean isStudentDeleted = false;
        if(studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            isStudentDeleted = true;
        }
        return isStudentDeleted;
    }
}
