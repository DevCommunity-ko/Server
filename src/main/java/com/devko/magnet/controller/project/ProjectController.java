package com.devko.magnet.controller.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @PostMapping
    public ResponseEntity createProject() {

        return new ResponseEntity("SUCCESS", HttpStatus.OK);
    }

}
