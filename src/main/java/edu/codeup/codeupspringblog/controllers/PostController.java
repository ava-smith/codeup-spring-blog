package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("")
    @ResponseBody
    public String posts() {
        return "posts index page";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String id(@PathVariable int id) {
        return "view an individual post";
    }

    @GetMapping("/create")
    @ResponseBody
    public String create() {
        return "view the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String postCreate() {
        return "create a new post";
    }
}
