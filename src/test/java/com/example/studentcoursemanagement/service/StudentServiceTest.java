package com.example.studentcoursemanagement.service;

import com.example.studentcoursemanagement.model.Student;
import com.example.studentcoursemanagement.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
        student.setId(1L);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
    }

    @Test
    void getAllStudents_ShouldReturnListOfStudents() {
        when(studentRepository.findAllWithCourses()).thenReturn(Arrays.asList(student));
        
        List<Student> result = studentService.getAllStudents();
        
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(studentRepository).findAllWithCourses();
    }

    @Test
    void getStudentById_WithValidId_ShouldReturnStudent() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        
        Student result = studentService.getStudentById(1L);
        
        assertNotNull(result);
        assertEquals("John", result.getFirstName());
    }

    @Test
    void getStudentById_WithInvalidId_ShouldThrowException() {
        when(studentRepository.findById(99L)).thenReturn(Optional.empty());
        
        assertThrows(EntityNotFoundException.class, () -> studentService.getStudentById(99L));
    }

    @Test
    void createStudent_ShouldReturnSavedStudent() {
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        
        Student result = studentService.createStudent(student);
        
        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        verify(studentRepository).save(student);
    }

    @Test
    void updateStudent_WithValidId_ShouldReturnUpdatedStudent() {
        Student updatedStudent = new Student();
        updatedStudent.setFirstName("Jane");
        updatedStudent.setLastName("Doe");
        updatedStudent.setEmail("jane.doe@example.com");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(studentRepository.save(any(Student.class))).thenReturn(updatedStudent);

        Student result = studentService.updateStudent(1L, updatedStudent);

        assertNotNull(result);
        assertEquals("Jane", result.getFirstName());
        verify(studentRepository).save(any(Student.class));
    }
}