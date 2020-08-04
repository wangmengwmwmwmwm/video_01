package com.qf.service.impl;

import com.qf.dao.SubjectMapper;
import com.qf.pojo.Subject;
import com.qf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;
    @Override
    public Subject selectSubjectById(String subjectId) {
        return null;
    }

    @Override
    public List<Subject> selectAll() {
        return subjectMapper.selectByExample(null);
    }
}
