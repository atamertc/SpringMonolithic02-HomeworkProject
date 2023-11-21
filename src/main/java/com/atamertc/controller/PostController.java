package com.atamertc.controller;

import com.atamertc.repository.entity.Post;
import com.atamertc.service.PostService;
import com.atamertc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.atamertc.constant.EndPoints.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService service;

    @PostMapping(SAVE)
    public ResponseEntity<String> save(Post post) {
        service.save(post);
        return ResponseEntity.ok("Post atıldı.");
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<Post>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(GETBYID)
    public ResponseEntity<Optional<Post>> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(DELETE)
    public ResponseEntity<String> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Kayıt silindi.");
    }
}
