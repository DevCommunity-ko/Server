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

import com.devko.magnet.model.enums.FileType;
import com.devko.magnet.model.enums.ProofAbout;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Proof {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "issue_id")
	private Issue issue;

	@Enumerated(EnumType.STRING)
	private ProofAbout about;

	//private FileType type;

	@Column(columnDefinition = "text")
	private String fileUrl;

	private int order;

	private int isDeleted;

}
