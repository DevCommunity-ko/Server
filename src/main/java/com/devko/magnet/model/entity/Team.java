package com.devko.magnet.model.entity;

import com.devko.magnet.dto.team.TeamInfo;
import com.devko.magnet.model.entity.base.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Team extends BaseTimeEntity {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "leader_id")
    private User leader;

    @Column(name = "profile_url")
    private String profileURL;

    private String introduction;

    @Column(name = "github_url")
    private String githubURL;

    private boolean isPublic = true;

    public Team(TeamInfo teamInfo) {
        this.name = teamInfo.getName();
        this.profileURL = teamInfo.getProfileURL();
        this.introduction = teamInfo.getIntroduction();
        this.githubURL = teamInfo.getGithubURL();
        this.isPublic = teamInfo.isPublic();
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public void setPublic(boolean isPublic){
        this.isPublic = isPublic;
    }

    public void editTeam(TeamInfo teamInfo){
        this.name = teamInfo.getName();
        this.profileURL = teamInfo.getProfileURL();
        this.introduction = teamInfo.getIntroduction();
        this.githubURL = teamInfo.getGithubURL();
    }
}
