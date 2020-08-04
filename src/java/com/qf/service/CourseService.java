package com.qf.service;

import com.qf.pojo.Course;
import com.qf.pojo.QueryVo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    Course selectCourseById(String toString);

    List<Course> selectAll();

    void deleteCourse(int id);

    void updateCourse(Course course);

    void insertCourse(Course course);

    List<Course> findAll();

    void deleteCourses(Integer[] ids);


}
