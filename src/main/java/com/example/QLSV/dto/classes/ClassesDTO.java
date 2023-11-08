package com.example.QLSV.dto.classes;

import com.example.QLSV.dto.teacher.TeacherDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class ClassesDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String nameClasses;

    @JsonIgnore
    private List<TeacherDTO> teacherDTOList;
}