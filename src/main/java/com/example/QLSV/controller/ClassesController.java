package com.example.QLSV.controller;

import com.example.QLSV.dto.classes.ClassesDTO;
import com.example.QLSV.dto.classes.ClassesDTO;
import com.example.QLSV.repository.IClassesRepository;
import com.example.QLSV.service.ClassesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/classes/")
@RestController
public class ClassesController {
    public final ClassesService service;
    public final IClassesRepository repository;

    public ClassesController(ClassesService service, IClassesRepository repository) {
        this.service = service;
        this.repository = repository;
    }
    @PostMapping("create")
    ResponseEntity<ClassesDTO> create(@RequestBody ClassesDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("update")
    ResponseEntity<ClassesDTO> update(@RequestBody ClassesDTO dto, Long id) {

        return ResponseEntity.ok(service.update(dto, id));
    }

    @GetMapping("getList")
    ResponseEntity<List<ClassesDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("findById")
    ResponseEntity<ClassesDTO> getById(@RequestParam Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("deletById")
    ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        return ResponseEntity.ok(service.deletById(id));
    }


}
