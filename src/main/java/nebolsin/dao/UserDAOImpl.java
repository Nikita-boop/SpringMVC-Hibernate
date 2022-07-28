package nebolsin.dao;

import nebolsin.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class UserDAOImpl implements UserDAO {
    private EntityManager entityManager;

    @PersistenceContext
    public void setSessionFactory(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(getUser(user.getId()));
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }
}
