package com.example.QLSV.dto.student;

import com.example.QLSV.entity.ClassesEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class StudentRequest {

    private String fullName;

    private int age;

    private String address;

    private float score;

    private Date dateMonth;

    private ClassesEntity classes;


}
