package com.devko.magnet.dto.team;

import com.devko.magnet.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Leader {
    private Long id;

    private String nickname;

    private String email;

    private String profile_url;

    public Leader(User user){
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.profile_url = user.getProfileURL();
    }
}
