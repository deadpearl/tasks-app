package kz.pearl.tasks_service.service;


import kz.pearl.tasks_service.entity.Users;

public interface UserService {
    Users getCurrentUser();
    Users login(Users users) throws Exception;
    Users create(Users users);

}
