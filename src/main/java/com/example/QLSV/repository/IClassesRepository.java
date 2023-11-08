package com.example.QLSV.repository;

import com.example.QLSV.entity.ClassesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClassesRepository extends JpaRepository<ClassesEntity,Long> {

}
