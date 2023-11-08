package com.example.QLSV.dto.classes;

import com.example.QLSV.entity.ClassesEntity;
import org.springframework.stereotype.Component;

@Component
public class ClassesMapper {
    public ClassesEntity toEntity(ClassesDTO dto) {
        return ClassesEntity.builder()
                .id(dto.getId())
                .nameClasses(dto.getNameClasses())
                .build();
    }

    public ClassesEntity toEntity(ClassesDTO dto,Long id) {
        return ClassesEntity.builder()
                .id(dto.getId())
                .nameClasses(dto.getNameClasses())
                .build();
    }

    public ClassesDTO toDTO(ClassesEntity entity)
    {
        return  ClassesDTO.builder()
                .id(entity.getId())
                .nameClasses(entity.getNameClasses())
                .build();
    }

}
