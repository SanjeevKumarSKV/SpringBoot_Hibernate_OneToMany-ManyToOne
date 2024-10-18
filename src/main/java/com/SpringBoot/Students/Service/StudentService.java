package com.SpringBoot.Students.Service;

import com.SpringBoot.Students.Dao.StudentRepository;
import com.SpringBoot.Students.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudent(Long id){
//        Optional<Student> s = studentRepository.findById(id);
//        if(!s.isEmpty()){
//            Student student = s.get();
//            student.getSubject().forEach(subject-> System.out.println(subject));
//        }
//        return s.orElse(null);
//    }
        Optional<Student> maybeStudents = studentRepository.findById(id);
        return maybeStudents.orElse(null);
    }

    public List<Student> findStudentWithSubject(String Name){
        return  studentRepository.findStudentWithSubject(Name);
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student){
        boolean StudentsExist = studentRepository.existsById(id);

        if (StudentsExist){
            return studentRepository.save(student);
        }
        return null;
    }

    public void deleteStudent(Long id){
        boolean StudentsExist = studentRepository.existsById(id);

        if (StudentsExist){
            studentRepository.deleteById(id);
        }

    }

}
