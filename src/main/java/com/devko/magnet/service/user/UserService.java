package com.devko.magnet.service.user;

import com.devko.magnet.exception.CustomException;
import com.devko.magnet.exception.ErrorCode;
import com.devko.magnet.model.entity.User;
import com.devko.magnet.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User getUser(long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);
        else
            return user.get();
    }
}
