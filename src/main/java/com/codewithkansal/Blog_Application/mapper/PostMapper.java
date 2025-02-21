package com.codewithkansal.Blog_Application.mapper;

import com.codewithkansal.Blog_Application.entity.Post;
import com.codewithkansal.Blog_Application.payload.PostDTO;

import java.util.stream.Collectors;

public class PostMapper {
    // Convert Post entity to PostDTO
    public static PostDTO mapToDTO(Post post) {
        if (post == null) {
            return null;
        }

        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        postDTO.setContent(post.getContent());
        postDTO.setCreatedAt(post.getCreatedAt());
        postDTO.setCategoryId(post.getCategory() != null ? post.getCategory().getId() : null);

        // Map comments if they exist
        if (post.getComments() != null) {
            postDTO.setComments(
                    post.getComments().stream()
                            .map(comment -> CommentMapper.mapToDTO(comment))
                            .collect(Collectors.toSet())
            );
        }

        return postDTO;
    }

    // Convert PostDTO to Post entity
    public static Post mapToEntity(PostDTO postDTO) {
        if (postDTO == null) {
            return null;
        }

        Post post = new Post();
        post.setId(postDTO.getId());
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        post.setCreatedAt(postDTO.getCreatedAt());

        // Comments and category can be set later in the service layer if needed
        return post;
    }
}
