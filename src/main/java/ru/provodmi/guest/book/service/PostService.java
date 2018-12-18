package ru.provodmi.guest.book.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.provodmi.guest.book.repository.PostRepository;
import ru.provodmi.guest.entity.Post;

import java.util.List;

@Service
@Slf4j
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post delete(Long id) {
        String str = postRepository.get(id);
        Post post = new Post(id,str);
        log.info("DELETE POST ID = {}", id);
        postRepository.delete(id);
        return post;
    }

    public Post add(Post post) {
        log.info("ADD POST : {}", post.getTxt());
        postRepository.add(post.getTxt());
        return post;
    }

    public List<Post> getAll() {
        log.info("GET ALL POSTS");
        return postRepository.getAllPosts();
    }
}
