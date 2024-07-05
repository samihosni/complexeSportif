package com.example.complexeSportif.restController;

import com.example.complexeSportif.entities.Courses;
import com.example.complexeSportif.services.AffectCourseToEntraineur;
import com.example.complexeSportif.services.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseToEntraineur {
    private final AffectCourseToEntraineur affectCourseToEntraineur;
    @PostMapping("/courseToTrainer")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Courses> assignCourseToTrainer(
            @RequestParam Long trainerId,
            @RequestParam Long salleMuscuId,
            @RequestBody Courses course) {
        Courses assignedCourse = affectCourseToEntraineur.assignCourseToTrainer(trainerId, salleMuscuId, course);
        return ResponseEntity.ok(assignedCourse);
    }

}
