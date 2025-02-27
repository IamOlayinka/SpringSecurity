package com.olayinka.Controller;


import com.olayinka.Model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


   private List<Student> students = new ArrayList<>(List.of(new Student(1,"Tolu",70), new Student(2, "Olayinka", 90)));


    @GetMapping("/student")

    public List<Student> getStudent(){

        return students;
    }


    @PostMapping("/student")

    public Student postStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
