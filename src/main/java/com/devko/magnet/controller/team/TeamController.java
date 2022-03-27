package com.devko.magnet.controller.team;

import com.devko.magnet.dto.team.TeamDetail;
import com.devko.magnet.dto.team.TeamInfo;
import com.devko.magnet.dto.team.TeamListItem;
import com.devko.magnet.model.Message;
import com.devko.magnet.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.devko.magnet.exception.StatusCode.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("teams")
public class TeamController {
    private final TeamService teamService;

    @PostMapping("{leaderId}")
    public ResponseEntity<Message> createTeam(@PathVariable("leaderId") Long leaderId, @RequestBody TeamInfo teamInfo){
        Map<String, Object> result = new HashMap<>();
        long id = teamService.createTeam(leaderId, teamInfo);
        result.put("teamId", id);
        return new Message(CREATE_NEW, result).toResponseEntity();
    }

    @PutMapping("{teamId}")
    public ResponseEntity<Message> editTeam(@PathVariable("teamId") Long teamId, @RequestBody TeamInfo teamInfo){
        TeamDetail team = teamService.editTeam(teamId, teamInfo);
        return new Message(SUCCESS, team).toResponseEntity();
    }

    @GetMapping
    public ResponseEntity<Message> getTeamList(){
        List<TeamListItem> teamList = teamService.getTeamList();
        return new Message(SUCCESS, teamList).toResponseEntity();
    }

    @GetMapping("{teamId}")
    public ResponseEntity<Message> getTeam(@PathVariable("teamId") Long teamId){
        TeamDetail team = teamService.getTeam(teamId);
        return new Message(SUCCESS, team).toResponseEntity();
    }

    @DeleteMapping("{teamId}")
    public ResponseEntity<Message> deleteTeam(@PathVariable("teamId") Long teamId){
        teamService.deleteTeam(teamId);
        return new Message(DELETE).toResponseEntity();
    }

    @PatchMapping("{teamId}")
    public ResponseEntity<Message> changeTeamPublicOption(@PathVariable("teamId") Long teamId, @RequestBody Map<String, Boolean> param){
        TeamDetail team = teamService.changeTeamPublicOption(teamId, param.get("isPossible"));
        return new Message(SUCCESS, team).toResponseEntity();
    }
}
