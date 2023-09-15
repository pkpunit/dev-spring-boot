package com.pktech.demo.rest;

import com.pktech.demo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    static List<Student> studentList;

    @GetMapping("/students")
    public List<Student>  getStudents(){

        studentList = new ArrayList<>();
        studentList.add(new Student("Archit" , "patel"));
        studentList.add(new Student("Atul" , "Pandey"));
        studentList.add(new Student("Ankit" , "Singh"));

        return studentList;
    }

    @GetMapping("students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if(studentId >= studentList.size() || studentId < 0){
            throw new StudentNotFoundException("Student ID not found :" + studentId);
        }
        return studentList.get(studentId);
    }


}







