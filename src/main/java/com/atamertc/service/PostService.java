package com.atamertc.service;

import com.atamertc.dto.request.PostSaveRequestDto;
import com.atamertc.dto.response.PostFindAllResponseDto;
import com.atamertc.mapper.IPostMapper;
import com.atamertc.repository.IPostRepository;
import com.atamertc.repository.entity.Post;
import com.atamertc.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService extends ServiceManager<Post, Long> {

    private final IPostRepository repository;

    public PostService(IPostRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public void saveDto(PostSaveRequestDto dto){
        save(IPostMapper.INSTANCE.saveFromRequestsDto(dto));
    }
    public List<PostFindAllResponseDto> findAllResponseDtos(){
        List<PostFindAllResponseDto> liste=new ArrayList<>();
        findAll().forEach(x->{
            liste.add(IPostMapper.INSTANCE.fromPost(x));
        });
        return liste;
    }

    public Optional<Post> findById(Long id) {
        return repository.findById(id);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Post update(Long postId, Post updatedPost) {
        Post existingPost = repository.findById(postId).orElse(null);
        if (existingPost != null) {
            // Gerekli güncellemeleri yapın
            existingPost.setContent(updatedPost.getContent());
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setUser(updatedPost.getUser());
            existingPost.setPublishedAt(updatedPost.getPublishedAt());
            // Güncellenmiş kullanıcıyı kaydet
            return repository.save(existingPost);
        } else {
            return null; // Kullanıcı bulunamadı
        }
    }

}
