package com.devko.magnet.model.entity;

import com.devko.magnet.dto.auth.AdditionalInfo;
import com.devko.magnet.dto.auth.LoginUser;
import com.devko.magnet.model.entity.base.BaseTimeEntity;
import com.devko.magnet.model.enums.UserStatus;
import com.devko.magnet.model.enums.converter.UserStatusAttributeConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseTimeEntity {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String userName;

    @Column(name = "email", unique = true)
    private String email;

    @JsonIgnore
    @NonNull
    private String password;

    @NonNull
    private String nickname;

    private Date birthday;

    private String phone;

    private String sex;

    @Column(name = "profile_url")
    private String profileURL;

    @Column(name = "github_url")
    private String githubURL;

    @Column(name = "blog_url")
    private String blogURL;

    @Column(name = "contact_url")
    private String contactURL;

    @Column(name = "final_background")
    private String finalBackground;

    private String job;

    private String field;

    private int career;

    @Enumerated(value = EnumType.STRING)
    @Convert(converter = UserStatusAttributeConverter.class)
    private UserStatus status = UserStatus.N;

    @JsonIgnore
    @Column(name = "sns_type")
    private String snsType;

    @JsonIgnore
    @Column(name = "sns_id")
    private String snsId;

    @JsonIgnore
    @Column(name = "sns_refresh_token")
    private String snsRefreshToken;

    @JsonIgnore
    @Column(name = "sns_connected_at")
    private LocalDateTime snsConnectedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "leader")
    private List<Team> ownTeams;

    public User(LoginUser loginUser){
        this.userName = loginUser.getName();
        this.nickname = loginUser.getNickname();
        this.email = loginUser.getEmail();
        this.sex = loginUser.getGender();
        this.birthday = java.sql.Date.valueOf(loginUser.getBirthyear() + "-" + loginUser.getBirthday());
        this.profileURL = loginUser.getProfile_image();
        this.phone = loginUser.getMobile();
        this.snsType = loginUser.getLoginType();
        this.snsId = loginUser.getId();
        this.snsRefreshToken = loginUser.getRefreshToken();
        this.snsConnectedAt = LocalDateTime.now();
    }

    public void addOwnTeam(Team team){
        ownTeams.add(team);
        team.setLeader(this);
    }

    public void resetUserInfo(LoginUser loginUser){
        this.userName = loginUser.getName();
        this.email = loginUser.getEmail();
        this.phone = loginUser.getMobile();
        this.snsRefreshToken = loginUser.getRefreshToken();
    }

    public void agreePolicy(){
        this.status = UserStatus.M;
    }

    public void setAdditionalInfo(AdditionalInfo info){
        this.job = info.getJob();
        this.field = info.getField();
        this.career = info.getCareer();
    }
}