package kz.pearl.tasks_service.controller;

import kz.pearl.tasks_service.entity.Users;
import kz.pearl.tasks_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public Users signUp(@RequestBody Users users) {
        return userService.create(users);
    }
    @PostMapping("/login")
    public Users login(@RequestBody Users users) throws Exception {
        return userService.login(users);
    }
    @GetMapping("/me")
    public Users getCurrentUser() {
        return userService.getCurrentUser();
    }


}
