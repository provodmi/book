package ru.provodmi.guest.book.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.provodmi.guest.book.repository.PostRepository;
import ru.provodmi.guest.entity.Post;

import java.util.List;

@Service
@Slf4j
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void delete(Long id) {
        log.info("DELETE POST ID = {}", id);
        postRepository.delete(id);
    }

    public void add(String txt) {
        log.info("ADD POST : {}", txt);
        postRepository.add(txt);
    }

    public void getAllPosts() {
        log.info("GET ALL POSTS");
//        List<Post> posts = PostRepository.getAllPosts();
    }
}
