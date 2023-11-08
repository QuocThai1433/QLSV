package com.example.QLSV.dto.teacher;

import com.example.QLSV.dto.classes.ClassesDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class TeacherDTO {
    private Long id;

    private String name;

    private List<ClassesDTO> classesList;
}
