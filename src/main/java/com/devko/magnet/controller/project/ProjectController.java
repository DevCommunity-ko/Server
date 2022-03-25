package com.devko.magnet.controller.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devko.magnet.dto.project.ProjectDto;
import com.devko.magnet.response.Response;
import com.devko.magnet.response.ResponseCode;
import com.devko.magnet.response.ResponseMessage;

@Controller
@RequestMapping("/project")
public class ProjectController {

	private static final Response response = new Response();

	@PostMapping
	public Response createProject(@RequestBody ProjectDto projectDto) {

		return response.withCodeAndMessage(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
	}

}
