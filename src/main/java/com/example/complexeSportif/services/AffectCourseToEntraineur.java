package com.example.complexeSportif.services;

import com.example.complexeSportif.entities.Courses;

public interface AffectCourseToEntraineur {
    Courses assignCourseToTrainer(Long trainerId, Long salleMuscuId, Courses course);
}
