package by.tms.dao;

import by.tms.entity.Operation;
import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HibernateUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    public User findByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("from User where username = :u", User.class);
        query.setParameter("u", username);
        User singleResult = query.getSingleResult();
        return singleResult;
    }

    public List<Operation> findAllUserByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("from User where username = :u", User.class);
        query.setParameter("u", username);
        User singleResult = query.getSingleResult();
        List<Operation> boxes = singleResult.getOperations();
        return boxes;
    }
}
