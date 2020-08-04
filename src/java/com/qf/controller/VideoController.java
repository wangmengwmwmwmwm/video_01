package com.qf.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.Course;
import com.qf.pojo.QueryVo;
import com.qf.pojo.Speaker;
import com.qf.pojo.Video;
import com.qf.service.CourseService;
import com.qf.service.SpeakerService;
import com.qf.service.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("selectAll")
    public Map selectAll (Integer page, Integer limit){
        PageHelper.startPage(page,limit);
        List<Video> videos = videoService.selectAll();
        System.out.println(videos);
        PageInfo<Video> pageInfo = new PageInfo<>(videos);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }
    @RequestMapping("insertVideo")
    public void insertVideo(Video video){
        videoService.insertVideo(video);
    }

    @RequestMapping("/updateVideo")
    public void updateVideo(Video video) {
       videoService.updateVideo(video);
    }
    @RequestMapping("deleteVideo")
    public void deleteVideo(String name){
        int id = Integer.parseInt(name);
        videoService.deleteVideo(id);
    }
    @RequestMapping("deleteVideos")
    public void deleteVideos(Integer []ids){
        videoService.deleteVideos(ids);
    }
    @RequestMapping("fuzzySelect")
    public Map fuzzySelect(QueryVo queryVo,Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        System.out.println(queryVo);
        List<Video> videos = videoService.fuzzySelect(queryVo);
        System.out.println(videos);
        PageInfo<Video> pageInfo = new PageInfo<>(videos);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }

    @RequestMapping("/delBatchVideos")
    public String delBatchVideos(String[] ids) {
        videoService.deleteById(ids);
        return "redirect:list";
    }

    @RequestMapping("/videoDel")
    @ResponseBody
    public String videoDel(String id) {
        String[] ids = new String[1];
        ids[0] = id;
        if (videoService.deleteById(ids)) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping("/edit")
    public String edit(String id, Model model) {
        Video video = videoService.selectVideoById(id);
        model.addAttribute("video", video);
        List<Course> courseList = courseService.selectAll();
        model.addAttribute("courseList", courseList);
        List<Speaker> speakerList = speakerService.selectAll();
        model.addAttribute("speakerList", speakerList);
        return "/behind/addVideo";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Video video) {
        videoService.updateVideo(video);
        return "redirect:list";
    }

    @RequestMapping("/addVideo")
    public String addVideo(Model model) {
        List<Course> courseList = courseService.selectAll();
        model.addAttribute("courseList", courseList);
        List<Speaker> speakerList = speakerService.selectAll();
        model.addAttribute("speakerList", speakerList);
        return "/behind/addVideo";
    }
}
