package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.qf.dao.SpeakerMapper;
import com.qf.pojo.QueryVo;
import com.qf.pojo.Speaker;
import com.qf.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerMapper speakerMapper;
    @Override
    public Page<Speaker> selectSpeakerByQueryVo(QueryVo queryVo) {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public Speaker selectSpeakerById(String id) {
        return null;
    }

    @Override
    public void saveOrUpdate(Speaker speaker) {

    }

    @Override
    public List<Speaker> selectAll() {
        return speakerMapper.selectByExample(null);
    }


}
