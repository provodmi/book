package ru.provodmi.guest.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.provodmi.guest.book.service.PostService;
import ru.provodmi.guest.entity.Post;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/{txt}")
    protected ModelAndView addPost(@PathVariable String txt) {
        ModelAndView posts = new ModelAndView("post");
        postService.add(txt);
//        GuestBook.addPost(post);
        return posts;
    }

    @DeleteMapping("/{id}")
    public ModelAndView deletePost(@PathVariable Long id) {
        ModelAndView posts = new ModelAndView("post");
        postService.delete(id);
//        GuestBook.deletePost(Integer.parseInt(request.getParameter("id")));
        return posts;
    }

    @GetMapping("/")
    public ModelAndView findAll() {
        ModelAndView posts = new ModelAndView("post");
        postService.getAllPosts();

        //        request.setAttribute("posts", GuestBook.getAllPosts() );
        return posts;
    }


}
