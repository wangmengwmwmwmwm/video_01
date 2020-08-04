package com.qf.service.impl;

import com.qf.dao.VideoMapper;
import com.qf.pojo.Course;
import com.qf.pojo.QueryVo;
import com.qf.pojo.Video;
import com.qf.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public Video selectVideoById(String videoId) {
        return null;
    }

    @Override
    public void updateVideo(Video video) {
        videoMapper.updateByPrimaryKey(video);
    }

    @Override
    public boolean deleteById(String[] ids) {
        return false;
    }

    @Override
    public List<Video> selectAll() {
        return videoMapper.selectAll();
    }

    @Override
    public void insertVideo(Video video) {
        videoMapper.insert(video);
    }

    @Override
    public void deleteVideo(int id) {
        videoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteVideos(Integer[] ids) {
        videoMapper.deleteVideos(ids);
    }
    @Override
    public List<Video> fuzzySelect(QueryVo queryVo) {
        return videoMapper.fuzzySelect(queryVo);
    }
}
