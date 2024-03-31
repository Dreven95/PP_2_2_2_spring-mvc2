package web.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import web.models.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery("from User", User.class);
        List<User> allUsers = query.getResultList();

        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        User user = session.get(User.class, id);

        return user;
    }

    @Override
    public void deleteUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery("delete  from User " +
                "where  id =: userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}
