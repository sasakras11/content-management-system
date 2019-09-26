package project.app.service.postService;

import project.app.model.post.post;

import java.util.List;

public interface postService {
    List<post> postList();
    void addPost(post post);
    void editPost(post post);
    void deletePost(post post);
    post getById(int id);
}
