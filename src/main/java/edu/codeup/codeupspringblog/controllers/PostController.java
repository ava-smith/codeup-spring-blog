package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.model.Post;
import edu.codeup.codeupspringblog.model.User;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import edu.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostRepository postsDao;
    private UserRepository usersDao;

    public PostController(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
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
    public String showCreatePostView(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post) {
        User currentUser = usersDao.findById(1L).get();
        Post postToSave = new Post(
                post.getTitle(),
                post.getBody(),
                currentUser
        );
        postsDao.save(postToSave);
        return "redirect:/posts";
    }
}
