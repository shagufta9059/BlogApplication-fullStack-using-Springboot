package com.Blogging.BloggingProject.BlogRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blogging.BloggingProject.model.Post;

public interface BlogRepo extends JpaRepository<Post, Integer>{

}
