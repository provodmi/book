package ru.provodmi.guest.book.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.provodmi.guest.book.repository.PostRepository;
import ru.provodmi.guest.entity.Post;

@Service
@Slf4j
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void delete(Long id) {
        log.info("DELETE POST ID = {}", id);
        postRepository.delete(id);
    }

    public void add(Post post) {
        log.info("ADD POST : {}", post);
    }

    public void getAllPosts() {
        log.info("GET ALL POSTS");
    }
}
