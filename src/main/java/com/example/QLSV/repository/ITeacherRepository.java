package com.example.QLSV.repository;

import com.example.QLSV.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
