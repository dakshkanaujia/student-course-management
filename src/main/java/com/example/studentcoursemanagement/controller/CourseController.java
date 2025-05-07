package com.example.studentcoursemanagement.controller;

import com.example.studentcoursemanagement.model.Course;
import com.example.studentcoursemanagement.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("course", new Course());
        return "courses/form";
    }

    @PostMapping
    public String createCourse(@Valid @ModelAttribute Course course, BindingResult result) {
        if (result.hasErrors()) {
            return "courses/form";
        }
        courseService.createCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "courses/form";
    }

    @PostMapping("/{id}")
    public String updateCourse(@PathVariable Long id, @Valid @ModelAttribute Course course, 
                             BindingResult result) {
        if (result.hasErrors()) {
            return "courses/form";
        }
        courseService.updateCourse(id, course);
        return "redirect:/courses";
    }
}