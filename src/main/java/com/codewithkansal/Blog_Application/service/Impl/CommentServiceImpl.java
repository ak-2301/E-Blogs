package com.codewithkansal.Blog_Application.service.Impl;

import com.codewithkansal.Blog_Application.entity.Comment;
import com.codewithkansal.Blog_Application.entity.Post;
import com.codewithkansal.Blog_Application.mapper.CommentMapper;
import com.codewithkansal.Blog_Application.payload.CommentDTO;
import com.codewithkansal.Blog_Application.repository.CommentRepository;
import com.codewithkansal.Blog_Application.repository.PostRepository;
import com.codewithkansal.Blog_Application.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.codewithkansal.Blog_Application.mapper.CommentMapper.mapToEntity;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository,PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository=postRepository;
    }


    //Create Comment
    @Override
    public CommentDTO createComment(long postId, CommentDTO commentDTO) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Comment comment = CommentMapper.mapToEntity(commentDTO);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        return CommentMapper.mapToDTO(savedComment);

    }

    //Get comments list by post ID
    @Override
    public List<CommentDTO> getCommentsByPostId(long postId) {
        List<Comment> comments=commentRepository.findByPostId(postId);
        return comments.stream()
                .map(CommentMapper::mapToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public CommentDTO getCommentById(Long postId, Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        return CommentMapper.mapToDTO(comment);
    }

    @Override
    public CommentDTO updateComment(Long postId, long commentId, CommentDTO commentDTO) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        // Ensure the comment belongs to the post
        if (!comment.getPost().getId().equals(post.getId())) {
            throw new RuntimeException("Comment does not belong to the post");
        }

        comment.setName(commentDTO.getName());
        comment.setEmail(commentDTO.getEmail());
        comment.setBody(commentDTO.getBody());

        Comment updatedComment = commentRepository.save(comment);
        return CommentMapper.mapToDTO(updatedComment);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        commentRepository.delete(comment);
    }

}
