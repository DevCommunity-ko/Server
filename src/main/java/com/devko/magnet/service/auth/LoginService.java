package com.devko.magnet.service.auth;

import com.devko.magnet.dto.auth.AdditionalInfo;
import com.devko.magnet.dto.auth.LoginUser;
import com.devko.magnet.exception.CustomException;
import com.devko.magnet.exception.ErrorCode;
import com.devko.magnet.model.entity.User;
import com.devko.magnet.model.enums.UserStatus;
import com.devko.magnet.repository.user.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

abstract public class LoginService {
    protected UserRepository userRepository;
    protected final ObjectMapper mapper = new ObjectMapper();
    protected MultiValueMap<String, String> params;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    abstract public Map<String, String> getAccessToken(String code, String state);
    abstract public LoginUser getUserInfo(String accessToken);
    abstract public String renewalAccessToken(Long userId);
    abstract public void logout(String refreshToken);

    public ResponseEntity<Map<String, Object>> isNewUser(LoginUser loginUser){
        Optional<User> user = userRepository.findBySnsId(loginUser.getId());
        Map<String, Object> info = new HashMap<>();
        HttpStatus httpStatus = HttpStatus.OK;
        boolean isNew = false;
        if(user.isEmpty() || user.get().getStatus().equals(UserStatus.N)){
            if(user.isEmpty())
                user = Optional.of(userRepository.save(new User(loginUser)));
            httpStatus = HttpStatus.CREATED;
            isNew = true;
        }
        else{
            user.get().resetUserInfo(loginUser);
            userRepository.save(user.get());
        }
        info.put("userId", user.get().getId());
        info.put("newMember", isNew);
        return new ResponseEntity<>(info, httpStatus);
    }

    @Transactional
    public void agreePolicy(long userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty())
            throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);
        user.get().agreePolicy();
    }

    @Transactional
    public void setAdditionalInfo(long userId, AdditionalInfo info){
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty())
            throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);
        user.get().setAdditionalInfo(info);
        userRepository.save(user.get());
    }
}
