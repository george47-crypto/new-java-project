package com.upgrad.course.controller;

import com.upgrad.course.dto.entity.CommentDto;
import com.upgrad.course.dto.entity.PostDto;
import com.upgrad.course.entity.PostEntity;
import com.upgrad.course.repository.PostRepository;
import com.upgrad.course.service.PostService;
import com.upgrad.course.service.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.HttpConstraintElement;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }


    // TODO: Define an API Endpoint for getting details of a post by postId
	//  The end point should be exposed as "/posts/{postId}"
    //  Use @RequestMapping annotation with value and method arguments for defining the API
    //  Define "postId" as a path parameter

    @RequestMapping(value = "/posts/{postId}")
    public ResponseEntity<PostDto> getPostDetails(@PathVariable(name = "postId") Long postId) {
        Optional<PostDto> postDto = postService.getPost(postId);
        if (postId == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }



        // TODO: Call service method to get the details of a post using postId
        //  Return 404 NOT_FOUND response when service empty Optional response
        //  Otherwise return 200 OK response with PostDto as body


    // TODO: Define an API Endpoint for getting comments of a post with a limit
	//  The end point should be exposed as "/posts/{postId}/comments"
    //  Define "postId" as a path parameter
    //  Define "limit" as a query parameter and use appropriate annotation to receive it as a method argument
    public ResponseEntity<List<CommentDto>> getCommentsForPostWithLimit( Long postId, int limit) {


        // TODO: Call service method to get the comments of a post using postId and limit
        //  Return 200 OK response with the body as List<Comment> got from the service
        return null;
    }
}
