package com.devko.magnet.controller.myPage;

import com.devko.magnet.model.Message;
import com.devko.magnet.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.devko.magnet.exception.StatusCode.SUCCESS;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @GetMapping("{userId}")
    public ResponseEntity<Message> getUser(@PathVariable Long userId){
        return new Message(SUCCESS, userService.getUser(userId)).toResponseEntity();
    }
}
