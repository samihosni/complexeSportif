package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.Courses;

import java.util.List;
import java.util.Optional;

public interface CoursesService {
    List<Courses> getAllCourses();

    Optional<Courses> getCoursesById(Long id);

    Courses saveCourses(Courses courses);

    void deleteCourses(Long id);
}
