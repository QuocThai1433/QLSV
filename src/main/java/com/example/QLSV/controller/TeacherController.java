package com.example.QLSV.controller;

import com.example.QLSV.dto.teacher.CreateTeacherRequest;
import com.example.QLSV.dto.teacher.TeacherDTO;
import com.example.QLSV.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/teacher/" )
@RestController
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/api/v1/createTeacher")
    public ResponseEntity<TeacherDTO> create(@RequestBody CreateTeacherRequest request) {
        return ResponseEntity.ok(this.teacherService.create(request));
    }
}
