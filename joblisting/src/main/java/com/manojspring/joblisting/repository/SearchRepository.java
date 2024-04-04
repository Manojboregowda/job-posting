package com.manojspring.joblisting.repository;

import com.manojspring.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);
}
