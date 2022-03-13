package com.devko.magnet.controller.team;

import com.devko.magnet.dto.team.TeamInfo;
import com.devko.magnet.model.entity.Team;
import com.devko.magnet.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("team")
public class TeamController {
    private final TeamService teamService;

    @PostMapping("{leaderId}")
    public ResponseEntity<Map<String, Object>> createTeam(@PathVariable("leaderId") Long leaderId, @RequestBody TeamInfo teamInfo){
        Map<String, Object> result = new HashMap<>();
        long id = teamService.createTeam(leaderId, teamInfo);
        result.put("teamId", id);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PatchMapping("{teamId}")
    public ResponseEntity<Team> editTeam(@PathVariable("teamId") Long teamId, @RequestBody TeamInfo teamInfo){
        Team team = teamService.editTeam(teamId, teamInfo);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }
}
