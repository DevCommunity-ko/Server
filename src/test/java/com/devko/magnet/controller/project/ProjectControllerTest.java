package com.devko.magnet.controller.project;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockPart;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import com.devko.magnet.dto.project.ProjectDto;
import com.devko.magnet.model.enums.ProjectKind;
import com.devko.magnet.model.enums.ProjectStatus;
import com.devko.magnet.model.enums.PublishType;
import com.devko.magnet.service.image.S3UploadService;

// @ExtendWith(MockitoExtension.class)
public class ProjectControllerTest {

	// @InjectMocks
	// private ProjectController projectController;
	//
	// @Mock
	// private S3UploadService s3UploadService;
	//
	// private MockMvc mockMvc;
	//
	// @BeforeEach
	// public void init() {
	// 	mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
	// }
	//
	// @Test
	// @DisplayName("프로젝트 등록 테스트")
	// public void testRegisterProject() throws Exception {
	// 	// given
	// 	ProjectDto projectDto = projectDto();
	// 	MockMultipartFile testImage = new MockMultipartFile("test.png", new InputStream() {
	// 		@Override
	// 		public int read() {
	// 			return 0;
	// 		}
	// 	});
	//
	// 	doReturn("https://s3.test.com").when(s3UploadService).upload(projectDto.getImage(), "test");
	//
	// 	// when
	// 	mockMvc.perform(multipart("/project")
	// 		.file(testImage).part(new MockPart("id", "foo".getBytes(StandardCharsets.UTF_8))));
	//
	//
	// }
	//
	// private ProjectDto projectDto() throws IOException {
	// 	MockMultipartFile testImage = new MockMultipartFile("test.png", new InputStream() {
	// 		@Override
	// 		public int read() {
	// 			return 0;
	// 		}
	// 	});
	//
	// 	Map<String, List<String>> testStack = new HashMap<>();
	// 	testStack.put("backend", List.of("spring boot", "java"));
	//
	// 	Map<String, List<String>> testCharger = new HashMap<>();
	// 	testCharger.put("backend", List.of("heather", "elly"));
	//
	// 	return ProjectDto.builder()
	// 		.name("test Project")
	// 		.status(ProjectStatus.READY)
	// 		.isRecruiting(0)
	// 		.isTeamProject(0)
	// 		.publishType(PublishType.PRIVATE)
	// 		.introduction("test introduction")
	// 		.kind(ProjectKind.WEB)
	// 		.image(testImage)
	// 		.githubUrl("https://github.test.com")
	// 		.numberOfStack(1)
	// 		.stack(testStack)
	// 		.numberOfPart(1)
	// 		.charger(testCharger)
	// 		.build();
	// }

}
