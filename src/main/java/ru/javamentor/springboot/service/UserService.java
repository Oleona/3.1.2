package ru.javamentor.springboot.service;


import ru.javamentor.springboot.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    void delete(Long userId);

    public void update(User user);

    public User getUserById(Long userid);

}
