package com.devko.magnet.repository.team;

import com.devko.magnet.dto.team.TeamDetail;
import com.devko.magnet.dto.team.TeamListItem;
import com.devko.magnet.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    boolean existsByName(String name);

    @Query("SELECT new com.devko.magnet.dto.team.TeamListItem(t.id, t.name, t.profileURL) " +
            "FROM Team as t")
    List<TeamListItem> getTeamList();

    @Query("SELECT new com.devko.magnet.dto.team.TeamDetail(t.name, t.profileURL, t.introduction, t.githubURL, t.isPublic, t.leader)" +
            "FROM Team as t " +
            "WHERE t.id = :teamId")
    Optional<TeamDetail> findTeamDetailById(@Param("teamId") Long teamId);
}
