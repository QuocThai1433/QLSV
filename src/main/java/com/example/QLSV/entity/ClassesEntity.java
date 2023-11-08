package com.example.QLSV.entity;

import com.example.QLSV.dto.teacher.TeacherDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "classes")
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Entity
public class ClassesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;

    @Column(name = "name")
    private String nameClasses;

    @OneToMany(mappedBy = "classes")
    @Builder.Default
    private List<StudentEntity> students = new ArrayList<>();

    @Builder.Default
    @ManyToMany(mappedBy = "classesList")
    private List<TeacherEntity> teachers = new ArrayList<>();
}
