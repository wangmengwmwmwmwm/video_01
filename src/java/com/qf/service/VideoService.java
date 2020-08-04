package com.qf.service;

import com.qf.pojo.Course;
import com.qf.pojo.QueryVo;
import com.qf.pojo.Video;

import java.util.List;


public interface VideoService {
    Video selectVideoById(String videoId);

    void updateVideo(Video video);

    boolean deleteById(String[] ids);


    List<Video> selectAll();

    void insertVideo(Video video);

    void deleteVideo(int id);

    void deleteVideos(Integer[] ids);
    List<Video> fuzzySelect(QueryVo queryVo);
}
