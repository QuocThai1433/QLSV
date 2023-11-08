package com.example.QLSV.dto.teacher;


import com.example.QLSV.dto.classes.ClassesMapper;
import com.example.QLSV.entity.TeacherEntity;
import com.example.QLSV.repository.IClassesRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeacherMapper {
    private final ClassesMapper classesMapper;
    private final IClassesRepository classesRepository;

    public TeacherMapper(ClassesMapper classesMapper,
                         IClassesRepository classesRepository) {
        this.classesMapper = classesMapper;

        this.classesRepository = classesRepository;
    }

    public TeacherDTO toDTO(TeacherEntity teacher) {
        return TeacherDTO.builder()
                .name(teacher.getName())
                .classesList(
                        teacher.getClassesList()
                                .stream()
                                .map(this.classesMapper::toDTO)
                                .collect(Collectors.toList())
                )
                .build();
    }

    /**
     * @param request CreateTeacherRequest
     * @return TeacherEntity
     */
    public TeacherEntity toEntity(CreateTeacherRequest request) {
        return TeacherEntity.builder()
                .name(request.getNameTeacher())
                .classesList(
                        request.getClassIds()
                                .stream()
                                .map(id -> this.classesRepository.findById(id).orElse(null))
                                .collect(Collectors.toList())
                )
                .build();
    }
}