package com.devko.magnet.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.devko.magnet.model.entity.base.BaseTimeEntity;
import com.devko.magnet.model.entity.id.PositionId;

@Entity
@IdClass(PositionId.class)
public class Position extends BaseTimeEntity {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private Project project;

	@Id
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String position;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	private User creator;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modifier_id")
	private User modifier;

}
