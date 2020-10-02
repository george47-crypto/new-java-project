package com.upgrad.course.service;

import com.upgrad.course.dto.entity.CommentDto;
import com.upgrad.course.dto.entity.PostDto;
import com.upgrad.course.entity.CommentEntity;
import com.upgrad.course.entity.PostEntity;
import com.upgrad.course.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // TODO: Implement getPost() method to return Optional<PostDto>
    //  Use repository method to fetch the post using postId

    public List<CommentDto> getCommentsForPostWithLimit(Long postId, int limit) {
        Optional<PostEntity> mayBePost = postRepository.findById(postId);
        List<CommentEntity> commentEntities = mayBePost
                .map(PostEntity::getCommentEntities)
                .orElse(Collections.emptyList());

        List<CommentDto> commentDtos = null;

        // TODO: Convert the List of CommentEntity to List of CommentDto using CommentDto method
        //  and assign it to commentDtos variable

        return commentDtos.stream().limit(limit).collect(Collectors.toList());
    }

    @Override
    public Optional<PostDto> getPost(Long postId) {
        return Optional.empty();
    }
}
