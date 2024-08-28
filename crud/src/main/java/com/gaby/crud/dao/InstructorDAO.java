package com.gaby.crud.dao;


import com.gaby.crud.entity.Course;
import com.gaby.crud.entity.Instructor;
import com.gaby.crud.entity.InstructorDetail;

import java.util.List;

public interface InstructorDAO {
    void save (Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int instructorId);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int id);
}
