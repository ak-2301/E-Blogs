package com.codewithkansal.Blog_Application.controller;

import com.codewithkansal.Blog_Application.payload.CommentDTO;
import com.codewithkansal.Blog_Application.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //Create Comment API
    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@PathVariable(value = "postId") long postId,
                                                    @Valid  @RequestBody  CommentDTO commentDTO){
        return new ResponseEntity<>(commentService.createComment(postId, commentDTO), HttpStatus.CREATED);
    }

    //Get comments for a particular post
    @GetMapping
    public ResponseEntity<List<CommentDTO>> getCommentsByPostId(@PathVariable(value = "postId")long postId){
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }

    // Get a comment by ID
    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable(value = "postId") Long postId,@PathVariable(value = "commentId") Long commentId) {
        return ResponseEntity.ok(commentService.getCommentById(postId,commentId));
    }

    // Update a comment by ID
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(
            @PathVariable Long postId,
            @PathVariable Long commentId,
            @Valid   @RequestBody CommentDTO commentDTO) {
        CommentDTO updatedComment = commentService.updateComment(postId, commentId, commentDTO);
        return ResponseEntity.ok(updatedComment);
    }

    // Delete a comment
    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,@PathVariable(value = "commentId") Long commentId) {
        commentService.deleteComment(postId,commentId);
        return ResponseEntity.ok("Comment Deleted Successfully");
    }
}
