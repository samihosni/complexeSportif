package com.example.complexeSportif.services.Impl;

import com.example.complexeSportif.entities.Courses;
import com.example.complexeSportif.entities.SalleMuscu;
import com.example.complexeSportif.repositories.CoursesRepo;
import com.example.complexeSportif.repositories.SalleMuscuRepo;
import com.example.complexeSportif.services.AffectCourseToEntraineur;
import com.example.complexeSportif.user.User;
import com.example.complexeSportif.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AffectCourseToEntraineurImp implements AffectCourseToEntraineur {
    private final CoursesRepo courseRepository;
    private final UserRepo userRepository;
    private final SalleMuscuRepo salleMuscuRepository;

    @Override
    public Courses assignCourseToTrainer(Long trainerId, Long salleMuscuId, Courses course) {
        User trainer = userRepository.findById(trainerId)
                .orElseThrow(() -> new IllegalArgumentException("Entraîneur non trouvé"));

        SalleMuscu salleMuscu = salleMuscuRepository.findById(salleMuscuId)
                .orElseThrow(() -> new IllegalArgumentException("Salle de musculation non trouvée"));

        course.setTrainer(trainer);
        course.setSalleMuscu(salleMuscu);

        return courseRepository.save(course);
    }



}
