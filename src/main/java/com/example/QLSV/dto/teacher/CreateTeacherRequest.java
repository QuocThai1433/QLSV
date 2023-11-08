package com.example.QLSV.dto.teacher;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CreateTeacherRequest {

    private String nameTeacher;

    private List<Long> classIds;
}
