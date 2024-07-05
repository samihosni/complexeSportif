package com.example.complexeSportif.restController;

import com.example.complexeSportif.entities.Courses;
import com.example.complexeSportif.services.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CoursesREST {

    private final CoursesService coursesService;

    @GetMapping("/all")
    public ResponseEntity<List<Courses>> getAllCourses() {
        List<Courses> courses = coursesService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Courses> getCoursesById(@PathVariable Long id) {
        Optional<Courses> courses = coursesService.getCoursesById(id);
        return courses.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Courses> createCourses(@RequestBody Courses courses) {
        Courses savedCourses = coursesService.saveCourses(courses);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourses);

    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Courses> updateCourses(@PathVariable Long id, @RequestBody Courses courses) {
        if (!coursesService.getCoursesById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        courses.setId(id);
        Courses updatedCourses = coursesService.saveCourses(courses);
        return ResponseEntity.ok(updatedCourses);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteCourses(@PathVariable Long id) {
        if (!coursesService.getCoursesById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        coursesService.deleteCourses(id);
        return ResponseEntity.noContent().build();
    }
}
