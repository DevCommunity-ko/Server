package com.devko.magnet.service.team;

import com.devko.magnet.dto.team.TeamDetail;
import com.devko.magnet.dto.team.TeamInfo;
import com.devko.magnet.dto.team.TeamListItem;
import com.devko.magnet.exception.CustomException;
import com.devko.magnet.exception.StatusCode;
import com.devko.magnet.model.entity.Team;
import com.devko.magnet.model.entity.User;
import com.devko.magnet.repository.team.TeamRepository;
import com.devko.magnet.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.devko.magnet.exception.StatusCode.*;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    public long createTeam(long leaderId, TeamInfo teamInfo){
        if(teamRepository.existsByName(teamInfo.getName()))
            throw new CustomException(DUPLICATE_TEAM);
        Optional<User> leader = userRepository.findById(leaderId);
        if(leader.isEmpty())
            throw new CustomException(MEMBER_NOT_FOUND);
        Team team = new Team(teamInfo);
        team.setLeader(leader.get());
        team = teamRepository.save(team);
        return team.getId();
    }

    @Transactional
    public TeamDetail editTeam(long teamId, TeamInfo teamInfo){
        Optional<Team> team = teamRepository.findById(teamId);
        if(team.isEmpty())
            throw new CustomException(TEAM_NOT_FOUND);
        if(!teamInfo.getName().equals(team.get().getName()) && teamRepository.existsByName(teamInfo.getName()))
            throw new CustomException(DUPLICATE_TEAM);
        team.get().editTeam(teamInfo);
        return new TeamDetail(team.get());
    }

    public List<TeamListItem> getTeamList(){
        return teamRepository.getTeamList();
    }

    public TeamDetail getTeam(Long teamId){
        Optional<TeamDetail> teamDetail = teamRepository.findTeamDetailById(teamId);
        if(teamDetail.isEmpty())
            throw new CustomException(TEAM_NOT_FOUND);
        return teamDetail.get();
    }

    public void deleteTeam(Long teamId){
        teamRepository.deleteById(teamId);
    }

    @Transactional
    public TeamDetail changeTeamPublicOption(Long teamId, boolean isPublic){
        Optional<Team> team = teamRepository.findById(teamId);
        if(team.isEmpty())
            throw new CustomException(TEAM_NOT_FOUND);
        team.get().setPublic(isPublic);
        return new TeamDetail(team.get());
    }
}
