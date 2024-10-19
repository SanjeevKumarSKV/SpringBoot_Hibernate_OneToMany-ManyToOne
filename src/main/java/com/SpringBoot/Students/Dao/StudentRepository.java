package com.SpringBoot.Students.Dao;


import com.SpringBoot.Students.Model.Student;
import com.SpringBoot.Students.Model.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(
            value =
                    "select s.* "
                            + "from student s inner join subject a "
                            + "on s.id = a.student_id "
                            + "where s.name = :name",
            nativeQuery = true)

    List<Student> findStudentWithSubject(@Param("name") String name);

    @Query(
            value =
                    "select s.name as name, s.reg_no as reg_no, s.subject as subject from (select student.name as name,student.reg_no as reg_no" +
                            ",subject.subject as subject "
                            + "from student inner join subject "
                            + "on student.id = subject.student_id ) as s",
                           // + "where s.Name > :Name",
            nativeQuery = true)
    List<StudentDTO> findStudentWithSubject();

}