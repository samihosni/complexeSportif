package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.ComplexeSportif;
import com.example.complexeSportif.entities.Courses;
import com.example.complexeSportif.repositories.ComplexeSportifRepo;
import com.example.complexeSportif.repositories.CoursesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoursesServiceImp implements CoursesService {
    @Autowired
    private CoursesRepo coursesRepo;
    @Override
    public List<Courses> getAllCourses() {
        return coursesRepo.findAll();
    }
    @Override

    public Optional<Courses> getCoursesById(Long id) {
        return coursesRepo.findById(id);
    }
    @Override

    public Courses saveCourses(Courses courses) {
        return coursesRepo.save(courses);
    }
    @Override

    public void deleteCourses(Long id) {
        coursesRepo.deleteById(id);
    }

}
