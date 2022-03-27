package com.devko.magnet.dto.team;

import lombok.Data;

@Data
public class TeamListItem {
    private final Long id;

    private final String name;

    private final String profileURL;
}
