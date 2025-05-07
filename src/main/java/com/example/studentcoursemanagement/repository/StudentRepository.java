package com.example.studentcoursemanagement.repository;

import com.example.studentcoursemanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT DISTINCT s FROM Student s JOIN FETCH s.courses")
    List<Student> findAllWithCourses();
}