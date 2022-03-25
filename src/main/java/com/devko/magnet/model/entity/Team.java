package com.devko.magnet.model.entity;

import java.util.ArrayList;
import java.util.List;

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

    public Team(TeamInfo teamInfo) {
        this.name = teamInfo.getName();
        this.profileURL = teamInfo.getProfileURL();
        this.introduction = teamInfo.getIntroduction();
        this.githubURL = teamInfo.getGithubURL();
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public void editTeam(TeamInfo teamInfo){
        this.name = teamInfo.getName();
        this.profileURL = teamInfo.getProfileURL();
        this.introduction = teamInfo.getIntroduction();
        this.githubURL = teamInfo.getGithubURL();
    }

    /** Project 양방향 매핑 */
    @OneToMany
    private List<Project> projects = new ArrayList<>();
}
