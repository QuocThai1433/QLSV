package com.example.QLSV.repository;

import com.example.QLSV.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity,Long> {
    @Query(value = "select * from students order by id asc limit :count",nativeQuery = true)
    List<StudentEntity> studentList (@Param("count") Integer count);


    @Query(value = "SELECT * FROM students WHERE  if(:findName is null, true, name LIKE CONCAT('%', :findName, '%'))  and if(:age is null, true,age = :age) ",
            nativeQuery = true)
    List<StudentEntity> studentFilters (@Param("findName") String name, @Param("age") Integer age);

    @Query(value = "SELECT std.name, tc.class_id, tc.teacher_id FROM teacher_class tc right join teacher t on tc.teacher_id = t.id left join students std on std.classes_id = tc.class_id) ",
            nativeQuery = true)
    List<StudentEntity> studentFilterByClassesTeacher (@Param("findName") String name, @Param("age") Integer age);
}
