package com.example.QLSV.dto.classes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CreateClassesRequest {

    private String nameClasses;

    private List<Long> teacherIds;
}
