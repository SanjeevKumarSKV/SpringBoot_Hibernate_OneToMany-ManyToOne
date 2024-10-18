package com.SpringBoot.Students.Web;


import com.SpringBoot.Students.Model.Subject;
import com.SpringBoot.Students.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;


    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubject(){
        List<Subject> SubjectList = subjectService.getAllSubject();
        return ResponseEntity.ok(SubjectList);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Subject>> getAllSubjectsByName(@RequestParam("name") String name){
        List<Subject> SubjectList = subjectService.getAllSubjectsByName(name);         //SanjeevSK
        return ResponseEntity.ok(SubjectList);
    }


    @GetMapping("{id}")
    public ResponseEntity<Subject> getSubject(@PathVariable Long id){
        Subject subject = subjectService.getSubject(id);
        return ResponseEntity.ok(subject);
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject,@RequestParam Long studentid){
        return subjectService.createSubject(subject,studentid);
    }

    @PutMapping("{id}")
    public Subject updateSubject(@PathVariable Long id, @RequestBody Subject subject){
        return subjectService.updateSubject(id, subject);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable Long id){
        subjectService.deleteSubject(id);
        return ResponseEntity.ok("Delete Success");
    }
}
