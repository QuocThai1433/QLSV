package com.example.QLSV.controller;

import com.example.QLSV.dto.student.StudentDTO;
import com.example.QLSV.entity.StudentEntity;
import com.example.QLSV.repository.IStudentRepository;
import com.example.QLSV.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RequestMapping("/api/v1/student/")
@RestController
public class StudentController {
    public final StudentService service;
    public final IStudentRepository repository;


    public StudentController(StudentService service, IStudentRepository repository, IStudentRepository repository1) {
        this.service = service;
        this.repository = repository1;
    }


    @PostMapping("create")
    ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("update")
    ResponseEntity<StudentDTO> update(@RequestBody StudentDTO dto, Long id) {

        return ResponseEntity.ok(service.update(dto, id));
    }

    @GetMapping("getList")
    ResponseEntity<List<StudentDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("findById")
    ResponseEntity<StudentDTO> getById(@RequestParam Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("deletById")
    ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        return ResponseEntity.ok(service.deletById(id));
    }

    @GetMapping("getListCount")
    ResponseEntity<List<StudentEntity>> studentFilter (@RequestParam String name,@RequestParam  Integer age )
    {
       return ResponseEntity.ok(repository.studentFilters(name,age ));
    }


    @PostMapping("/api/v1/createMapperClasses/")
    public ResponseEntity<StudentDTO> createMapperClasses(@RequestBody StudentDTO dto) {
        return ResponseEntity.ok(this.service.createStudentmapper(dto));
    }


}
