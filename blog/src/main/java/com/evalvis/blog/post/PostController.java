package com.evalvis.blog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import protobufs.PostRequest;

@RestController
@RequestMapping("posts")
final class PostController {

    private final PostRepository postRepository;

    @Autowired
    PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping(value = "/create")
    ResponseEntity<PostRepository.PostEntry> create(@RequestBody PostRequest postRequest)
    {
        return ResponseEntity.ok(
                postRepository.save(
                        new SpringPostRepository.PostEntry(
                                postRequest.getAuthor(),
                                postRequest.getTitle(),
                                postRequest.getContent()
                        )
                )
        );
    }
}
