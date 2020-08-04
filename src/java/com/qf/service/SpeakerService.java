package com.qf.service;

import com.github.pagehelper.Page;
import com.qf.pojo.QueryVo;
import com.qf.pojo.Speaker;

import java.util.List;

public interface SpeakerService {
    Page<Speaker> selectSpeakerByQueryVo(QueryVo queryVo);

    boolean deleteById(String id);

    Speaker selectSpeakerById(String id);

    void saveOrUpdate(Speaker speaker);

    List<Speaker> selectAll();
}
