package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.model.Post;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostRepository postsDao;

    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    @GetMapping("")
    public String indexPage(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        if(postsDao.existsById(id)) {
            Post post = postsDao.findById(id).get();
            model.addAttribute("post", post);
            return "posts/show";
        }
        return "redirect:/posts";
    }

    @GetMapping("/create")
    public String showCreatePostView() {
        return "posts/create";
    }


    @PostMapping("/create")
    public String createPost(
            @RequestParam(name = "post-title") String title,
            @RequestParam(name = "post-description") String body
    ) {
        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setBody(body);
        postsDao.save(newPost);
        return "redirect:/posts";
    }
}
