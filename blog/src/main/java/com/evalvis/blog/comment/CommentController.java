package com.evalvis.blog.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")
final class CommentController {
    private final CommentRepository commentRepository;

    @Autowired
    CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping(value = "/list-comments/{postId}")
    ResponseEntity<List<CommentRepository.CommentEntry>> commentsOfPost(@PathVariable String postId) {
        return ResponseEntity.ok(commentRepository.findCommentEntriesByPostEntryId(postId));
    }

    @PostMapping(value = "/create")
    ResponseEntity<CommentRepository.CommentEntry> create(@RequestBody Comment comment)
    {
        return ResponseEntity.ok(comment.save(commentRepository));
    }
}
