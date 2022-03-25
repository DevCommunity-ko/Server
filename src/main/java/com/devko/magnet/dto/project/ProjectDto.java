package com.devko.magnet.dto.project;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.devko.magnet.model.enums.ProjectKind;
import com.devko.magnet.model.enums.ProjectStatus;
import com.devko.magnet.model.enums.PublishType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectDto {

	@Size(max = 20, message = "이름을 20자 이내여야 합니다.")
	private String name;
	private ProjectStatus status;
	private int isRecruiting;
	private int isTeamProject;
	private PublishType publishType;
	private String introduction;
	private ProjectKind kind;
	private MultipartFile image;
	private String githubUrl;
	private int numberOfStack;
	private Map<String, List<String>> stack; //(part, [stacks]), (other part, [stacks]) ...
	private int numberOfPart;
	private Map<String, List<String>> charger; //(position, [team member]), (other position, [team member]) ...

}
