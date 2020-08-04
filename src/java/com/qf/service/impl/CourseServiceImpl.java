package com.qf.service.impl;

import com.qf.dao.CourseMapper;
import com.qf.pojo.Course;
import com.qf.pojo.QueryVo;
import com.qf.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public Course selectCourseById(String toString) {
        return null;
    }

    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }

    @Override
    public void deleteCourse(int id) {
        courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.updateByPrimaryKeyWithBLOBs(course);
    }

    @Override
    public void insertCourse(Course course) {
        courseMapper.insert(course);
    }

    @Override
    public List<Course> findAll() {
        return courseMapper.selectByExample(null);
    }

    @Override
    public void deleteCourses(Integer[] ids) {
        courseMapper.deleleteCourses(ids);
    }


}
