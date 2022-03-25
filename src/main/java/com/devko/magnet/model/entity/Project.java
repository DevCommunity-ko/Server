package com.devko.magnet.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.devko.magnet.model.entity.timestamped.Timestamped;
import com.devko.magnet.model.enums.ProjectKind;
import com.devko.magnet.model.enums.ProjectStatus;
import com.devko.magnet.model.enums.PublishType;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Project extends Timestamped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team team;

	private String name;

	@Column(columnDefinition = "text")
	private String introduction;

	@Enumerated(EnumType.STRING)
	private ProjectStatus status;

	private int isRecruiting;

	private int isTeamProject;

	@Enumerated(EnumType.STRING)
	private PublishType publishType;

	@Enumerated(EnumType.STRING)
	private ProjectKind kind;

	@Column(columnDefinition = "text", name = "image_url")
	private String imageURL;

	@Column(columnDefinition = "text", name = "github_url")
	private String gitHubURL;

	/** Team 양방향 매핑 */
	public void setTeam(Team team) {
		if(this.team != null) {
			this.team.getProjects().remove(this);
		}

		this.team = team;
		if(!team.getProjects().contains(this)) {
			team.getProjects().add(this);
		}
	}
}
