package com.example.slstudiomini.service;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.slstudiomini.exception.MyLessonNotFoundException;
import com.example.slstudiomini.model.Course;
import com.example.slstudiomini.model.Lesson;
import com.example.slstudiomini.repository.LessonRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseService courseService;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Lesson> findAllLessons() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Lesson>cq = cb.createQuery(Lesson.class);
        Root<Lesson>lesson = cq.from(Lesson.class);

        cq.select(lesson);
        cq.where(cb.isNotNull(lesson.get("deletedAt")));

        return entityManager.createQuery(cq).getResultList();
    }
        
    // public List<Lesson> findAllLessons() {
    //     return lessonRepository.findAll();
    // }

    public Lesson findLessonById(Long id)throws MyLessonNotFoundException {
       CriteriaBuilder cb = entityManager.getCriteriaBuilder();
       CriteriaQuery<Lesson>cq = cb.createQuery(Lesson.class);
       Root<Lesson>lesson = cq.from(Lesson.class);

       cq.select(lesson);
       cq.where(cb.equal(lesson.get("id"),id));

       return entityManager.createQuery(cq).getResultStream().findFirst().orElseThrow(()-> new MyLessonNotFoundException("null",id));

    }
    // public Lesson findLessonById(Long id) {
    //     return lessonRepository.findById(id)
    //         .orElseThrow(() -> new EntityNotFoundException("Lesson Not Found With id= " + id));
    // }

    @Transactional
    public Lesson save(Lesson lesson) {
        lesson.setCreatedAt(LocalDateTime.now());
        return lessonRepository.save(lesson);
    }

    @Transactional
    public Lesson update(Lesson updateLesson) throws MyLessonNotFoundException{
        Lesson lesson = findLessonById(updateLesson.getId());

        lesson.setUpdatedAt(LocalDateTime.now());
        lesson.setName(updateLesson.getName());
        lesson.setContent(updateLesson.getContent());
        lesson.setDescription(updateLesson.getDescription());
        lesson.setUpdatedAt(LocalDateTime.now());

        Course course = courseService.findCourseById(updateLesson.getCourse().getId());
        lesson.setCourse(course);
        return lessonRepository.save(lesson);
    }
}