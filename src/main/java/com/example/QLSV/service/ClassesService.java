package com.example.QLSV.service;

import com.example.QLSV.dto.classes.ClassesDTO;
import com.example.QLSV.dto.classes.ClassesMapper;
import com.example.QLSV.entity.ClassesEntity;
import com.example.QLSV.repository.IClassesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassesService {
    public final IClassesRepository repository;
    public final ClassesMapper mapper;

    public ClassesService(IClassesRepository repository, ClassesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public ClassesDTO create(ClassesDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public ClassesDTO update(ClassesDTO dto, Long id) {
        if (getById(id) == null) {
            return null;
        }
        return mapper.toDTO(repository.save(mapper.toEntity(dto, id)));
    }

    public ClassesDTO getById(Long id) {
        Optional<ClassesEntity> optional = repository.findById(id);
        return optional.map(mapper::toDTO).orElse(null);
    }

    public List<ClassesDTO> getList() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Boolean deletById(Long id) {
        repository.deleteById(id);
        return true;
    }


}
