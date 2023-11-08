package com.example.QLSV.service;

import com.example.QLSV.dto.student.StudentDTO;
import com.example.QLSV.dto.student.StudentMapper;
import com.example.QLSV.dto.student.StudentRequest;
import com.example.QLSV.dto.teacher.CreateTeacherRequest;
import com.example.QLSV.dto.student.StudentDTO;
import com.example.QLSV.entity.StudentEntity;
import com.example.QLSV.entity.TeacherEntity;
import com.example.QLSV.repository.IStudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    public final IStudentRepository repository;

    public final StudentMapper mapper;




    public StudentService(IStudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;

    }

    public StudentDTO create(StudentDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public StudentDTO update(StudentDTO dto, Long id) {
        if (getById(id) == null) {
            return null;
        }
        return mapper.toDTO(repository.save(mapper.toEntity(dto, id)));
    }

    public StudentDTO getById(Long id) {
        Optional<StudentEntity> optional = repository.findById(id);
        return optional.map(mapper::toDTO).orElse(null);
    }

    public List<StudentDTO> getList() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Boolean deletById(Long id) {
        repository.deleteById(id);
        return true;
    }

    public StudentDTO createStudentmapper (StudentDTO dto) {
        StudentEntity student = this.mapper.toEntity(dto);
        student = this.repository.save(student);
        return this.mapper.toDTO(student);
    }
}
