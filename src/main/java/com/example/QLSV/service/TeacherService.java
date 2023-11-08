package com.example.QLSV.service;


import com.example.QLSV.dto.teacher.CreateTeacherRequest;
import com.example.QLSV.dto.teacher.TeacherDTO;
import com.example.QLSV.dto.teacher.TeacherMapper;
import com.example.QLSV.entity.TeacherEntity;
import com.example.QLSV.repository.ITeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherMapper teacherMapper;
    private final ITeacherRepository teacherRepository;

    public TeacherService(TeacherMapper teacherMapper, ITeacherRepository teacherRepository) {
        this.teacherMapper = teacherMapper;
        this.teacherRepository = teacherRepository;
    }


    public TeacherDTO create( CreateTeacherRequest request) {
        TeacherEntity teacher = this.teacherMapper.toEntity(request);
        teacher = this.teacherRepository.save(teacher);
        return this.teacherMapper.toDTO(teacher);
    }
}
