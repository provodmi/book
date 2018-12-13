package ru.provodmi.guest.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.provodmi.guest.book.service.PostService;
import ru.provodmi.guest.entity.Post;

import javax.validation.Valid;

@RestController
//@RequestMapping("/posts")
public class PostController {

    @Autowired
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
//    @GetMapping("")
    public ModelAndView showPost() {
        ModelAndView posts = new ModelAndView("posts", "post", new Post());
        posts.addObject("posts", postService.getAllPosts());

//        posts.addObject("posts", );
        return posts;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    @PostMapping("/add")
    public RedirectView submit(Post post) {

        postService.add(post.getTxt());
//        model.addAttribute("post", post.getTxt());
        RedirectView rv = new RedirectView();
        rv.setUrl("posts");
        return rv;

    }

    @RequestMapping(value = "/delete/", method = RequestMethod.GET)
//    @GetMapping("/{id}")
    public RedirectView deletePost(@RequestParam(required = true) Long id) {
        postService.delete(id);
        RedirectView rv = new RedirectView();
        rv.setUrl("/posts");
        return rv;
    }




}
