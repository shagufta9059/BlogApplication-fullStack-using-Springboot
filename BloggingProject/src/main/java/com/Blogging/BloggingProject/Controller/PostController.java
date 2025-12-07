package com.Blogging.BloggingProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.Blogging.BloggingProject.BlogRepo.BlogRepo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Blogging.BloggingProject.model.Post;

@Controller
public class PostController {

    @Autowired
    BlogRepo repo;
    
    @GetMapping("/")
    public String viewHome(Model model){
        model.addAttribute("listPosts",repo.findAll());
        return "index";
    }
    @GetMapping("/new")
    public String addPost(Model model){
        model.addAttribute("post",new Post());
        return "new_Post";
    }
    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post){
        repo.save(post);
        return "redirect:/";
    }
      @GetMapping("/edit/{id}")
    public String editPost(@PathVariable int id,Model model){
        model.addAttribute("post",repo.findById(id));
        return "edit_post";
    }
    @PostMapping("/update")
    public String updatePost(@ModelAttribute("post") Post post){
        repo.save(post);
        return "redirect:/";

    }
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable int id){
        repo.deleteById(id);
        return "redirect:/";
    }

}
