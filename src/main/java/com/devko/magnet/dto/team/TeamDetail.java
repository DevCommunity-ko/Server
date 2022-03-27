package com.devko.magnet.dto.team;

import com.devko.magnet.model.entity.Team;
import com.devko.magnet.model.entity.User;
import lombok.Data;

@Data
public class TeamDetail extends TeamInfo{
    private Leader leader;

    public TeamDetail(String name, String profileURL, String introduction, String githubURL, boolean isPublic, User leader) {
        super(name, profileURL, introduction, githubURL, isPublic);
        this.leader = new Leader(leader);
    }

    public TeamDetail(Team team){
        super(team.getName(), team.getProfileURL(), team.getIntroduction(), team.getGithubURL(), team.isPublic());
        this.leader = new Leader(team.getLeader());
    }
}
