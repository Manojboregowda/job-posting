package com.manojspring.joblisting.controller;

import com.manojspring.joblisting.repository.PostRepository;
import com.manojspring.joblisting.model.Post;
import com.manojspring.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;

    // "/posts" endpoint to get all the posts.
    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return repo.findAll();
    }

    // to search by text on the endpoint
    // "/posts/java"
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }

    // "/addPost" endpoint to post the joblist.
    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }
}
