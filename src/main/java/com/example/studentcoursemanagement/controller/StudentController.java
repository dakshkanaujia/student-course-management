package com.example.studentcoursemanagement.controller;

import com.example.studentcoursemanagement.model.Student;
import com.example.studentcoursemanagement.service.CourseService;
import com.example.studentcoursemanagement.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final CourseService courseService;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("courses", courseService.getAllCourses());
        return "students/form";
    }

    @PostMapping
    public String createStudent(@Valid @ModelAttribute Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("courses", courseService.getAllCourses());
            return "students/form";
        }
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        model.addAttribute("courses", courseService.getAllCourses());
        return "students/form";
    }

    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @Valid @ModelAttribute Student student, 
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("courses", courseService.getAllCourses());
            return "students/form";
        }
        studentService.updateStudent(id, student);
        return "redirect:/students";
    }
}