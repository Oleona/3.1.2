package ru.javamentor.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import ru.javamentor.springboot.entity.User;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public List<User> listUsers() {
        return em.createQuery("from User ", User.class).getResultList();
    }

    @Override
    public void delete(Long userId) {
        User user = em.find(User.class, userId);
        em.remove(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public User getUserById(Long userid) {
        User user = em.find(User.class, userid);
        return user;
    }
}
