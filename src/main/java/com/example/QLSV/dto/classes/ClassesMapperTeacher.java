package com.example.QLSV.dto.classes;

import com.example.QLSV.dto.teacher.TeacherMapper;
import com.example.QLSV.entity.ClassesEntity;
import com.example.QLSV.repository.ITeacherRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ClassesMapperTeacher {

    public final ITeacherRepository repository;

    public  final TeacherMapper teacherMapper;

    public ClassesMapperTeacher(ITeacherRepository repository, TeacherMapper teacherMapper) {
        this.repository = repository;
        this.teacherMapper = teacherMapper;
    }

    public ClassesEntity toEntityTeacher(CreateClassesRequest request) {
        return  ClassesEntity.builder()
                .nameClasses(request.getNameClasses())
                .teachers(
                        request.getTeacherIds()
                                .stream()
                                .map(id->repository.findById(id).orElse(null))
                                .collect(Collectors.toList())
                )
                .build();
    }

    public ClassesDTO toDtoTeacher(ClassesEntity classes) {
        return ClassesDTO.builder()
                .nameClasses(classes.getNameClasses())
                .teacherDTOList(classes
                        .getTeachers().stream()
                        .map(this.teacherMapper::toDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}
