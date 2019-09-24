package project.app.dao.userDao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.app.model.post.post;
import project.app.model.user.User;

import java.util.List;
@Repository
public class UserDaoImpl implements userDao {
   private SessionFactory sessionFactory;


    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

@Transactional
    @Override
    public List<User> users_list() {
        Session session = sessionFactory.getCurrentSession();
        return (List<User>) session.createQuery("from post").list();
    }
@Transactional
    @Override
    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
session.save(user);
    }
@Transactional
    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
             session.delete(user);
    }
    @Override
    @Transactional
    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();
       session.update(user);




    }
    @Override
    @Transactional
    public boolean validation(User user) {         //VALIDATION
        Session session = sessionFactory.getCurrentSession();
Query query = session.createQuery("from User where name=:NameParam AND pass=:PassParam");
query.setParameter("NameParam",user.getName());
query.setParameter("PassParam",user.getPass());

int f  = query.list().size();
        return f==1;

    }

@Transactional
    @Override
    public User getByName(String name) {
        Session session= sessionFactory.getCurrentSession();
               Query query = session.createQuery("from User where name=:name");
        query.setParameter("name", name);

        return (User)query.uniqueResult();

    }
    @Transactional
    @Override
    public User getById(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class,id);
    }
@Transactional
    @Override
    public boolean IsNameFree(String name) {
        Session session = sessionFactory.getCurrentSession();
        List result = session.createQuery("from User where name=:name").setParameter("name",name).list();


    return result.isEmpty();
    }


}
