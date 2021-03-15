package com.example.securitypractise.demo.controller;

import com.example.securitypractise.demo.exception.StudentException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students/")
public class StudentController {

    private final List<Student> l= Arrays.asList(
            new Student(1,"Suman"),
            new Student(2,"Pujan"),
            new Student(3,"Rishu")
    );

    @GetMapping("{id}")
    public Student getStudent(@PathVariable int id) throws StudentException {
        return l.stream().filter(student->
                    id== student.getId()
                ).findFirst()
                .orElseThrow(()->new StudentException("user not found"));

    }
}
