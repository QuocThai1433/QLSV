package com.example.QLSV.dto.student;

import com.example.QLSV.dto.classes.ClassesDTO;
import com.example.QLSV.entity.ClassesEntity;
import com.example.QLSV.entity.StudentEntity;
import com.example.QLSV.repository.IClassesRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class StudentMapper {
    public final IClassesRepository repository;

    public StudentMapper(IClassesRepository repository) {
        this.repository = repository;
    }

    public StudentEntity toEntity(StudentDTO dto) {
        return StudentEntity.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .age(dto.getAge())
                .address((dto.getAddress()))
                .score(dto.getScore())
                .dateMonth(dto.getDateMonth())
                .classes(ClassesEntity.builder().id(dto.getClassesId()).build())
                .build();
    }

    public StudentEntity toEntity(StudentDTO dto, Long id) {
        return StudentEntity.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .age(dto.getAge())
                .address((dto.getAddress()))
                .score(dto.getScore())
                .dateMonth(dto.getDateMonth())
                .classes(ClassesEntity.builder()
                        .id(dto.getClassesId())
                        .build())
                .build();
    }

    public StudentDTO toDTO(StudentEntity entity) {
//        Long classesId = null;
//        if(entity.getAddress() != null)
//        {
//            classesId = entity.getClasses().getId();
//        }

        return StudentDTO.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .age(entity.getAge())
                .address((entity.getAddress()))
                .score(entity.getScore())
                .dateMonth(entity.getDateMonth())
                //  .classesId(classesId)
                .classes(Objects.nonNull(entity.getClasses()) ? ClassesDTO.builder()
                        .id(entity.getClasses().getId())
                        .nameClasses(entity.getClasses().getNameClasses())
                        .build() : null
                )
                .build();
    }
}
