package com.codewithkansal.Blog_Application.mapper;

import com.codewithkansal.Blog_Application.entity.Comment;
import com.codewithkansal.Blog_Application.payload.CommentDTO;

public class CommentMapper {
    // Convert Comment entity to CommentDTO
    public static CommentDTO mapToDTO(Comment comment) {
        if (comment == null) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setName(comment.getName());
        commentDTO.setEmail(comment.getEmail());
        commentDTO.setBody(comment.getBody());

        return commentDTO;
    }

    // Convert CommentDTO to Comment entity
    public static Comment mapToEntity(CommentDTO commentDTO) {
        if (commentDTO == null) {
            return null;
        }

        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setName(commentDTO.getName());
        comment.setEmail(commentDTO.getEmail());
        comment.setBody(commentDTO.getBody());

        return comment;
    }
}
