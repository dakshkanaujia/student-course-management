package com.example.studentcoursemanagement.config;

import com.example.studentcoursemanagement.model.Course;
import com.example.studentcoursemanagement.model.Student;
import com.example.studentcoursemanagement.repository.CourseRepository;
import com.example.studentcoursemanagement.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(StudentRepository studentRepository, CourseRepository courseRepository) {
        return args -> {
            // Create courses
            Course java = new Course();
            java.setCode("CS101");
            java.setName("Java Programming");
            java.setCredits(3);

            Course python = new Course();
            python.setCode("CS102");
            python.setName("Python Programming");
            python.setCredits(3);

            Course webDev = new Course();
            webDev.setCode("CS103");
            webDev.setName("Web Development");
            webDev.setCredits(4);

            Course database = new Course();
            database.setCode("CS104");
            database.setName("Database Systems");
            database.setCredits(3);

            Course algorithms = new Course();
            algorithms.setCode("CS105");
            algorithms.setName("Algorithms");
            algorithms.setCredits(4);

            courseRepository.saveAll(Arrays.asList(java, python, webDev, database, algorithms));

            // Create students
            Student john = new Student();
            john.setFirstName("John");
            john.setLastName("Doe");
            john.setEmail("john.doe@example.com");
            john.setCourses(new HashSet<>(Arrays.asList(java, python)));

            Student jane = new Student();
            jane.setFirstName("Jane");
            jane.setLastName("Smith");
            jane.setEmail("jane.smith@example.com");
            jane.setCourses(new HashSet<>(Arrays.asList(webDev, database)));

            Student bob = new Student();
            bob.setFirstName("Bob");
            bob.setLastName("Johnson");
            bob.setEmail("bob.johnson@example.com");
            bob.setCourses(new HashSet<>(Arrays.asList(algorithms, java)));

            studentRepository.saveAll(Arrays.asList(john, jane, bob));
        };
    }
}