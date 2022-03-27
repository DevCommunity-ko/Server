package com.devko.magnet.dto.team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamInfo {
    private String name;
    private String profileURL;
    private String introduction;
    private String githubURL;
    private boolean isPublic = true;
}
