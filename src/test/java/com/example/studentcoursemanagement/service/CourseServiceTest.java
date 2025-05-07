package com.example.studentcoursemanagement.service;

import com.example.studentcoursemanagement.model.Course;
import com.example.studentcoursemanagement.repository.CourseRepository;
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
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService;

    private Course course;

    @BeforeEach
    void setUp() {
        course = new Course();
        course.setId(1L);
        course.setCode("CS101");
        course.setName("Java Programming");
        course.setCredits(3);
    }

    @Test
    void getAllCourses_ShouldReturnListOfCourses() {
        when(courseRepository.findAll()).thenReturn(Arrays.asList(course));
        
        List<Course> result = courseService.getAllCourses();
        
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(courseRepository).findAll();
    }

    @Test
    void getCourseById_WithValidId_ShouldReturnCourse() {
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        
        Course result = courseService.getCourseById(1L);
        
        assertNotNull(result);
        assertEquals("CS101", result.getCode());
    }

    @Test
    void getCourseById_WithInvalidId_ShouldThrowException() {
        when(courseRepository.findById(99L)).thenReturn(Optional.empty());
        
        assertThrows(EntityNotFoundException.class, () -> courseService.getCourseById(99L));
    }

    @Test
    void createCourse_ShouldReturnSavedCourse() {
        when(courseRepository.save(any(Course.class))).thenReturn(course);
        
        Course result = courseService.createCourse(course);
        
        assertNotNull(result);
        assertEquals("CS101", result.getCode());
        verify(courseRepository).save(course);
    }

    @Test
    void updateCourse_WithValidId_ShouldReturnUpdatedCourse() {
        Course updatedCourse = new Course();
        updatedCourse.setCode("CS102");
        updatedCourse.setName("Python Programming");
        updatedCourse.setCredits(4);

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(courseRepository.save(any(Course.class))).thenReturn(updatedCourse);

        Course result = courseService.updateCourse(1L, updatedCourse);

        assertNotNull(result);
        assertEquals("CS102", result.getCode());
        verify(courseRepository).save(any(Course.class));
    }
}