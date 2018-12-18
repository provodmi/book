package ru.provodmi.guest.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.provodmi.guest.book.service.PostService;
import ru.provodmi.guest.entity.Post;

import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;
//
//    @Autowired
//    public PostController(PostService postService) {
//        this.postService = postService;
//    }

    /*@RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView showPost() {
        ModelAndView posts = new ModelAndView("posts", "post", new Post());
        posts.addObject("posts", postService.getAllPosts());

//        posts.addObject("posts", );
        return posts;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public RedirectView submit(Post post) {

        postService.add(post.getTxt());
//        model.addAttribute("post", post.getTxt());
        RedirectView rv = new RedirectView();
        rv.setUrl("posts");
        return rv;

    }*/

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createPostPage() {
        ModelAndView mav = new ModelAndView("new-post");
//        posts.addObject("posts", postService.getAllPosts());
        mav.addObject("post", new Post());
        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Post createPost(@RequestBody Post post) {return postService.add(post);}

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Post deletePost(@PathVariable Long id) {
        return postService.delete(id);
    }


    @RequestMapping(value="", method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Post> allPosts() {
        return postService.getAll();
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView allPostsPage() {
        ModelAndView mav = new ModelAndView("all-posts");
        mav.addObject("posts",allPosts());
        return mav;
    }


    /*@RequestMapping(value = "/delete/", method = RequestMethod.GET)
//    @GetMapping("/{id}")
    public RedirectView deletePost(@RequestParam(required = true) Long id) {
        postService.delete(id);
        RedirectView rv = new RedirectView();
        rv.setUrl("/posts");
        return rv;
    }*/




}
