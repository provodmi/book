package ru.provodmi.guest.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import ru.provodmi.guest.book.service.PostService;
import ru.provodmi.guest.book.entity.Post;

@Controller
public class IndexController {

    private final PostService postService;

    @Value("${welcome.message}")
    private String message;

    @Autowired
    public IndexController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.GET)
    public ModelAndView createPostPage() {
        ModelAndView mav = new ModelAndView("addPost");
//        posts.addObject("posts", postService.getAllPosts());
        mav.addObject("pPost", new Post());
        return mav;
    }

    @RequestMapping(value="/postlist", method=RequestMethod.GET)
    public ModelAndView allPostsPage() {
        ModelAndView mav = new ModelAndView("postList");
        mav.addObject("posts", postService.getAll());
        return mav;
    }
}
