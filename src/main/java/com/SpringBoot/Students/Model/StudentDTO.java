package com.SpringBoot.Students.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String name;

    private int RegNo;

    private String subject;
}
