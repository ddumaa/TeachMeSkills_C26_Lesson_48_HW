package by.tms.dao;

import by.tms.entity.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HibernateOperationDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Operation operation) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(operation);
    }

    public List<Operation> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Operation> fromBox = currentSession.createQuery("from Operation", Operation.class);
        List<Operation> resultList = fromBox.getResultList();
        return resultList;
    }

}
