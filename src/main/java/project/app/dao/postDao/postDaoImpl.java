package project.app.dao.postDao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.app.dao.postDao.PostDao;
import project.app.model.post.post;

import java.util.List;
@Repository
public class postDaoImpl implements PostDao {

  private SessionFactory sessionFactory;
@Autowired
    public void setFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<post> postList() {
        Session session = sessionFactory.getCurrentSession();

        return (List<post>) session.createQuery("from post").list();
    }

    @Override
    @Transactional
    public void addPost(post post) {
     Session session = sessionFactory.getCurrentSession();
     session.save(post);
    }

    @Override
    @Transactional
    public void editPost(post post) {
     Session session = sessionFactory.getCurrentSession();
     session.update(post);
    }

    @Override
    @Transactional
    public void deletePost(post post) {
Session session = sessionFactory.getCurrentSession();
session.delete(post);
    }
}
