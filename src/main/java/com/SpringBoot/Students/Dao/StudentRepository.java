package com.SpringBoot.Students.Dao;


import com.SpringBoot.Students.Model.Student;
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
                            + "from student s inner join details a "
                            + "on s.id = a.students_id "
                            + "where s.Name > :Name",
            nativeQuery = true)

    List<Student> findStudentWithSubject(@Param("Name")String Name);

}