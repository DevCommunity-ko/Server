package com.devko.magnet.service.team;

import com.devko.magnet.dto.team.TeamInfo;
import com.devko.magnet.exception.CustomException;
import com.devko.magnet.exception.ErrorCode;
import com.devko.magnet.model.entity.Team;
import com.devko.magnet.model.entity.User;
import com.devko.magnet.repository.team.TeamRepository;
import com.devko.magnet.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    public long createTeam(long leaderId, TeamInfo teamInfo){
        if(teamRepository.existsByName(teamInfo.getName()))
            throw new CustomException(ErrorCode.DUPLICATE_TEAM);
        Optional<User> leader = userRepository.findById(leaderId);
        if(leader.isEmpty())
            throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);
        Team team = new Team(teamInfo);
        team.setLeader(leader.get());
        team = teamRepository.save(team);
        return team.getId();
    }

    public Team editTeam(long teamId, TeamInfo teamInfo){
        Optional<Team> team = teamRepository.findById(teamId);
        if(team.isEmpty())
            throw new CustomException(ErrorCode.TEAM_NOT_FOUND);
        if(!teamInfo.getName().equals(team.get().getName()) && teamRepository.existsByName(teamInfo.getName()))
            throw new CustomException(ErrorCode.DUPLICATE_TEAM);
        team.get().editTeam(teamInfo);
        return teamRepository.save(team.get());
    }
}
