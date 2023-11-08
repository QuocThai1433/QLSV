package com.example.QLSV.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Table(name = "students")
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Entity
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;

    @Column(name = "name")
    private String fullName;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "score")
    private float score;

    @Column(name = "date_month")
    private Date dateMonth;

    @ManyToOne
    @JoinColumn(name = "classes_id", updatable = false)
    private ClassesEntity classes;
}
