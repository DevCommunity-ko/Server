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

import com.devko.magnet.model.entity.base.BaseTimeEntity;
import com.devko.magnet.model.enums.IssueStatus;
import com.devko.magnet.model.enums.PublishType;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Issue extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private Project project;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Enumerated(EnumType.STRING)
	private PublishType publishType;

	private IssueStatus status;

	private String field;

	@Column(columnDefinition = "text")
	private String problem;

	@Column(columnDefinition = "text")
	private String cause;

	@Column(columnDefinition = "text")
	private String solution;

}
