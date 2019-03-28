package ru.provodmi.guest.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.provodmi.guest.book.service.PostService;
import ru.provodmi.guest.book.entity.Post;

@RestController
@RequestMapping("/")
public class IndexController {

    private final PostService postService;

    @Autowired
    public IndexController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createPostPage() {
        ModelAndView mav = new ModelAndView("new-post");
//        posts.addObject("posts", postService.getAllPosts());
        mav.addObject("pPost", new Post());
        return mav;
    }

    @RequestMapping(value="/all-posts", method=RequestMethod.GET)
    public ModelAndView allPostsPage() {
        ModelAndView mav = new ModelAndView("all-posts");
        mav.addObject("posts", postService.getAll());
        return mav;
    }
}
