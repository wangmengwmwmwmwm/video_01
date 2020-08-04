package com.qf.service;

import com.qf.pojo.Subject;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SubjectService {
    Subject selectSubjectById(String subjectId);

    List<Subject> selectAll();
}
