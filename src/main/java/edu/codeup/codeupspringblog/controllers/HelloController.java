package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world")
    //if there is a get request to /hello/world it will print the line "Hello, World!"
    @ResponseBody
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/{name}")
    @ResponseBody
    public String helloName(@PathVariable String name) {
        return String.format("Hello, %s!", name);
    }

}
