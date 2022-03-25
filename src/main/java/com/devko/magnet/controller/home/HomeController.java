package com.devko.magnet.controller.home;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devko.magnet.dto.image.ImageDto;
import com.devko.magnet.response.Response;
import com.devko.magnet.response.ResponseCode;
import com.devko.magnet.response.ResponseMessage;
import com.devko.magnet.service.image.S3UploadService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

	private final Response response = new Response<>();
	private final S3UploadService s3UploadService;

	@PostMapping("image-test")
	public Response home(ImageDto projectImage) throws IOException {
		System.out.println(">>>>>>>>>>>>>>>>>> HI");
		return response.withAll(ResponseCode.SUCCESS, ResponseMessage.SUCCESS,s3UploadService.upload(projectImage.getFile(), "test"));
	}

	@GetMapping
	public ResponseEntity executeTest() {
		return new ResponseEntity("Hello, World!", HttpStatus.OK);
	}
}
