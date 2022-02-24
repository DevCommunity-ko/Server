package com.devko.magnet.model.entity.id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class MemberId implements Serializable {
    private Long user;
    private Long team;
}
