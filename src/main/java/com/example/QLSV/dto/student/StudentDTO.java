package com.example.QLSV.dto.student;

import com.example.QLSV.dto.classes.ClassesDTO;
import com.example.QLSV.entity.ClassesEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class StudentDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String fullName;

    private int age;

    private String address;

    private float score;

    private Date dateMonth;

    private Long classesId;

    private ClassesDTO classes;
}
