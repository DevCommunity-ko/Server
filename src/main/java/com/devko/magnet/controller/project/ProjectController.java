package com.devko.magnet.controller.project;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devko.magnet.dto.project.ProjectDto;
import com.devko.magnet.response.Response;
import com.devko.magnet.response.ResponseCode;
import com.devko.magnet.response.ResponseMessage;
import com.devko.magnet.service.image.S3UploadService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {

	private static final Response response = new Response();
	private final S3UploadService s3UploadService;

	@PostMapping
	public Response createProject(@RequestBody ProjectDto projectDto) throws IOException {
		s3UploadService.upload(projectDto.getImage(), "test");
		return response.withCodeAndMessage(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
	}

}
