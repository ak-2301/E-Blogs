package com.codewithkansal.Blog_Application.controller;

import com.codewithkansal.Blog_Application.payload.PostDTO;
import com.codewithkansal.Blog_Application.payload.PostResponse;
import com.codewithkansal.Blog_Application.service.PostService;
import com.codewithkansal.Blog_Application.utils.AppConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Tag(
        name = "CRUD REST APIs for Post Resource"
)
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //Create post
    @Operation(
            summary = "Create Post REST API",
            description = "Create Post REST API is used to save post into database"
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@Valid  @RequestBody PostDTO postDTO){
        return ResponseEntity.ok(postService.createPost(postDTO));
    }

    //Get All post
    @Operation(
            summary = "Get All Posts REST API",
            description = "Get All Posts REST API is used to fetch all the posts from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value="pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = AppConstants.DEFAULT_SORT_BY,required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ){
        return postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
    }

    //Get Post By Id
    @Operation(
            summary = "Get Post By Id REST API",
            description = "Get Post By Id REST API is used to get single post from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO>getPostById(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }


    //Update Post
    @Operation(
            summary = "update Post REST API",
            description = "Update Post REST API is used to update a particular post in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@Valid  @RequestBody PostDTO postDTO,@PathVariable Long id){
        return  ResponseEntity.ok(postService.updatePost(postDTO,id));
    }



    //Delete Post
    @Operation(
            summary = "Delete Post REST API",
            description = "Delete Post REST API is used to delete a particular post from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.ok("Post Deleted Successfully");
    }



    // Build Get Posts by Category REST API
    // http://localhost:8080/api/posts/category/3
    @GetMapping("/category/{id}")
    public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable("id") Long categoryId){
        List<PostDTO> postDtos = postService.getPostsByCategory(categoryId);
        return ResponseEntity.ok(postDtos);
    }
}
