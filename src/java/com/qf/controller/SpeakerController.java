package com.qf.controller;


import com.github.pagehelper.Page;
import com.qf.pojo.QueryVo;
import com.qf.pojo.Speaker;
import com.qf.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/speaker")
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("/selectAll")
    public List<Speaker> selectAll() {
        System.out.println(speakerService.selectAll());
        return speakerService.selectAll();
    }

    @RequestMapping("/speakerDel")
    @ResponseBody
    public String speakerDel(String id) {
        if (speakerService.deleteById(id)) {
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping("/addSpeaker")
    public String addSpeaker() {
        return "/behind/addSpeaker";
    }

    @RequestMapping("/edit")
    public String edit(String id, Model model) {
        Speaker speaker = speakerService.selectSpeakerById(id);
        model.addAttribute("speaker", speaker);
        return "/behind/addSpeaker";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Speaker speaker) {
        speakerService.saveOrUpdate(speaker);
        return "redirect:showSpeakerList";
    }
}
