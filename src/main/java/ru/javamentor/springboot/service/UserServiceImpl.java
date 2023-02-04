package ru.javamentor.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.springboot.dao.UserDao;
import ru.javamentor.springboot.entity.User;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }


    @Override
    public void delete(Long userId) {
        userDao.delete(userId);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User getUserById(Long userid) {
        return userDao.getUserById(userid);
    }
}
