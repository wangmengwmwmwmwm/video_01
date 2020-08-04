package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.Course;
import com.qf.pojo.QueryVo;
import com.qf.pojo.Subject;
import com.qf.service.CourseService;
import com.qf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    /*@Autowired
    private SubjectService subjectService;*/

   /* @RequestMapping("/course/{subjectId}")
    public String course(@PathVariable String subjectId, Model model) {
        Subject subject = subjectService.selectSubjectById(subjectId);
        model.addAttribute("subject", subject);
        return "/before/course";
    }*/
    @RequestMapping("selectAll")
    public Map selectAll (Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        List<Course> courses = courseService.selectAll();

        PageInfo<Course> pageInfo = new PageInfo<>(courses);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }
    @RequestMapping("deleteCourse")
    public void deleteCourse(String name){
        int id = Integer.parseInt(name);
        courseService.deleteCourse(id);
    }
    @RequestMapping("updateCourse")
    public void updateCourse(Course course){
        System.out.println(course);
        courseService.updateCourse(course);
    }
    @RequestMapping("insertCourse")
    public void insertCourse(Course course){

        courseService.insertCourse(course);
    }
    @RequestMapping("findAll")
    public List<Course> findAll(){
        return courseService.findAll();
    }
    @RequestMapping("deleteCourses")
    public void deleteCourses(Integer[]ids){

        courseService.deleteCourses(ids);
    }


}
