package com.codewithkansal.Blog_Application.service;

import com.codewithkansal.Blog_Application.payload.PostDTO;
import com.codewithkansal.Blog_Application.payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDTO getPostById(Long id);

    PostDTO updatePost(PostDTO postDto,Long id);

    void deletePost(Long id);

    List<PostDTO> getPostsByCategory(Long categoryId);
}
