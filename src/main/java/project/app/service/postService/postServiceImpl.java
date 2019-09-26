package project.app.service.postService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.app.model.post.post;
import project.app.dao.postDao.PostDao;
import project.app.dao.postDao.postDaoImpl;
import project.app.service.postService.postService;


import javax.transaction.Transactional;
import java.util.List;
@Service
public class postServiceImpl implements postService {

    private PostDao postDao = new postDaoImpl();
    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    @Transactional
    public List<post> postList() {
     return    postDao.postList();
    }

    @Override
@Transactional
    public void addPost(post post) {
postDao.addPost(post);
    }

    @Override
    @Transactional
    public void editPost(post post) {
postDao.editPost(post);
    }

    @Override
    @Transactional
    public void deletePost(post post) {
        postDao.deletePost(post);
    }

    @Override
    public post getById(int id) {
        return postDao.getById(id);
    }
}
