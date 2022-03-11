package com.devko.magnet.controller.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devko.magnet.dto.project.ProjectDto;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @PostMapping
    public ResponseEntity createProject(@RequestBody ProjectDto projectDto) {

        return new ResponseEntity("SUCCESS", HttpStatus.OK);
    }

}
