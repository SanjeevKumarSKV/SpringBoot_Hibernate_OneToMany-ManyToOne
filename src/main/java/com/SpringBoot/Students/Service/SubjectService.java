package com.SpringBoot.Students.Service;


import com.SpringBoot.Students.Dao.SubjectRepository;
import com.SpringBoot.Students.Model.Student;
import com.SpringBoot.Students.Model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentService studentService;


    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();

    }

    public List<Subject> getAllSubjectsByName(String name){
        return subjectRepository.findAllBySubject(name);

    }

    public Subject getSubject(Long id){
        Optional<Subject> sub = subjectRepository.findById(id);
        return sub.orElse(null);
    }

    public Subject createSubject(Subject subject, Long studentId) {
        Student student = studentService.getStudent(studentId);
    subject.setStudent(student);  // Sanjeev SK
    return subjectRepository.save(subject);
}


    public Subject updateSubject(Long id, Subject subject){
        boolean SubjectExist = subjectRepository.existsById(id);

        if (SubjectExist){
            return subjectRepository.save(subject);
        }
        return null;
    }
    public void deleteSubject(Long id){
        boolean SubjectExist = subjectRepository.existsById(id);



        if (SubjectExist){
            subjectRepository.deleteById(id);
        }
    }
}
