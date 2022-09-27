package com.example.yujublog.Service;

import com.example.yujublog.model.RoleType;
import com.example.yujublog.model.User;
import com.example.yujublog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void 회원가입(User user) {
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }


}
