package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("")
    public String indexPage(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Hello", "Hello world"));
        posts.add(new Post("Test", "testing"));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        Post post = new Post();
        post.setTitle("New post");
        post.setBody("This is the description");
        model.addAttribute("post", post);

        return "posts/show";
    }

    @GetMapping("/create")
    @ResponseBody
    public String showCreatePostView() {
        return "view the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }
}
