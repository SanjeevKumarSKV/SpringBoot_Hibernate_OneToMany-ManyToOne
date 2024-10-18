package com.SpringBoot.Students.Web;


import com.SpringBoot.Students.Model.Student;
import com.SpringBoot.Students.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();
        return studentList;
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }

    @GetMapping("subject/{subject}")
    public List<Student> findStudentWithSubject(@RequestParam String Name){
        return  studentService.findStudentWithSubject(Name);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping("{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Delete success");
    }
}