package com.devko.magnet.controller.auth;

import com.devko.magnet.dto.auth.AdditionalInfo;
import com.devko.magnet.dto.auth.LoginParamDto;
import com.devko.magnet.dto.auth.LoginUser;
import com.devko.magnet.service.auth.NaverLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class LoginController {
    private final NaverLoginService loginService;

    @PostMapping("{type}")
    public ResponseEntity<Map<String, Object>> login(@PathVariable("type") String type, @RequestBody LoginParamDto loginParamDto){
        LoginUser user = new LoginUser();
        ResponseEntity<Map<String, Object>> responseEntity;
        switch (type){
            case "naver" :
                Map<String, String> access = loginService.getAccessToken(loginParamDto.getCode(), loginParamDto.getState());
                user = loginService.getUserInfo(access.get("access_token"));
                user.setRefreshToken(access.get("refresh_token"));
                break;
        }

        user.setLoginType(type);
        if(user.getId() == null)
            responseEntity = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        else {
            responseEntity = loginService.isNewUser(user);
        }
        return responseEntity;
    }

    @DeleteMapping("{userId}")
    public ResponseEntity logout(@PathVariable Long userId){
        //TODO:: provider에 따라 다르게 적용
        String accessToken = loginService.renewalAccessToken(userId);
        loginService.logout(accessToken);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping("info/{userId}")
    public ResponseEntity saveAdditionalInfo(@PathVariable Long userId, @Valid AdditionalInfo info){
        loginService.setAdditionalInfo(userId, info);
        return new ResponseEntity(HttpStatus.OK);
    }
}
