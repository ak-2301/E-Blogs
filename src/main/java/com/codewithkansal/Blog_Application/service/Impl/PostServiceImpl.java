package com.codewithkansal.Blog_Application.service.Impl;

import com.codewithkansal.Blog_Application.entity.Category;
import com.codewithkansal.Blog_Application.entity.Post;
import com.codewithkansal.Blog_Application.exception.ResourceNotFoundException;
import com.codewithkansal.Blog_Application.mapper.PostMapper;
import com.codewithkansal.Blog_Application.payload.PostDTO;
import com.codewithkansal.Blog_Application.payload.PostResponse;
import com.codewithkansal.Blog_Application.repository.CategoryRepository;
import com.codewithkansal.Blog_Application.repository.PostRepository;
import com.codewithkansal.Blog_Application.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.codewithkansal.Blog_Application.mapper.PostMapper.mapToDTO;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private CategoryRepository categoryRepository;

    public PostServiceImpl(PostRepository postRepository,CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository=categoryRepository;

    }


    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Category category = categoryRepository.findById(postDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", postDTO.getCategoryId()));

        //convert DTO into entity
        Post post = PostMapper.mapToEntity(postDTO);
        post.setCreatedAt(LocalDateTime.now());
        post.setCategory(category);

        Post newPost= postRepository.save(post);

        // convert entity to DTO
        PostDTO postResponse = mapToDTO(newPost);
        return postResponse;
    }


    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort= sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ?Sort.by(sortBy).ascending()
                :Sort.by(sortBy).descending();

        //Create Pagination instance
        Pageable pageable= PageRequest.of(pageNo,pageSize,sort);

        Page<Post> postPage=postRepository.findAll(pageable);

        // Get the content of the current page and map to DTOs
        List<PostDTO> content = postPage.getContent().stream()
                .map(PostMapper::mapToDTO)
                .collect(Collectors.toList());

        // Create PostResponse object with pagination details
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(postPage.getNumber());
        postResponse.setPageSize(postPage.getSize());
        postResponse.setTotalElements(postPage.getTotalElements());
        postResponse.setTotalPages(postPage.getTotalPages());
        postResponse.setLast(postPage.isLast());

        return postResponse;
//        List<Post>posts= postRepository.findAll();
//        return posts.stream().map(post-> mapToDTO(post)).collect(Collectors.toList());

    }

    @Override
    public PostDTO getPostById(Long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        return mapToDTO(post);
    }

    @Override
    public PostDTO updatePost( PostDTO postDto, Long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));

        Category category = categoryRepository.findById(postDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", postDto.getCategoryId()));

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setCategory(category);
        post = postRepository.save(post);
        return mapToDTO(post);
    }

    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
        postRepository.delete(post);
    }

    @Override
    public List<PostDTO> getPostsByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        List<Post> posts = postRepository.findByCategoryId(categoryId);

        return posts.stream().map((post) -> mapToDTO(post))
                .collect(Collectors.toList());
    }


}
