package ru.provodmi.guest.book.repository;

import org.springframework.stereotype.Repository;
import ru.provodmi.guest.entity.Post;

@Repository
public class PostRepository {

    public void add (Long id, String txt) {
        Post post = new Post(id,txt);

    }

    public void delete(Long id) {

    }
}
