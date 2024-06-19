package kz.pearl.tasks_service.service.impl;

import kz.pearl.tasks_service.entity.Users;
import kz.pearl.tasks_service.repository.UserRepository;
import kz.pearl.tasks_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Users create(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return userRepository.save(users);
    }
    @Override
    public Users getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        return userRepository.findByLogin(principal.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
    }

    @Override
    public Users login(Users usersDTO) throws Exception {
        Users users = userRepository.findByLogin(usersDTO.getLogin()).orElseThrow();
        if (!(passwordEncoder.matches(usersDTO.getPassword(), users.getPassword()))) {
            throw new Exception("Неправильный пароль");
        }
        return users;
    }



}
