package com.SpringBoot.Students.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student", schema = "subject_schema")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int RegNo;

    private String Name;

    @JsonIgnore
    @OneToMany(mappedBy="student", fetch = FetchType.EAGER)
    private List<Subject> subject;


}
