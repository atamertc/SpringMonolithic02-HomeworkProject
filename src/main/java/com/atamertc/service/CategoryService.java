package com.atamertc.service;

import com.atamertc.dto.request.CategorySaveRequestDto;
import com.atamertc.dto.response.CategoryFindAllResponseDto;
import com.atamertc.mapper.ICategoryMapper;
import com.atamertc.repository.ICategoryRepository;
import com.atamertc.repository.entity.Category;
import com.atamertc.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService extends ServiceManager<Category, Long> {

    private final ICategoryRepository repository;

    public CategoryService(ICategoryRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public void saveDto(CategorySaveRequestDto dto){
        save(ICategoryMapper.INSTANCE.saveFromRequestsDto(dto));
    }
    public List<CategoryFindAllResponseDto> findAllResponseDtos(){
        List<CategoryFindAllResponseDto> liste=new ArrayList<>();
        findAll().forEach(x->{
            liste.add(
                    ICategoryMapper.INSTANCE.fromUser(x));
        });
        return liste;
    }
    public Optional<Category> findById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public Category update(Long categoryId, Category updatedCategory) {
        Category existingCategory = repository.findById(categoryId).orElse(null);
        if (existingCategory != null) {
            // Gerekli güncellemeleri yapın
            existingCategory.setDescription(updatedCategory.getDescription());
            existingCategory.setName(updatedCategory.getName());
            // Güncellenmiş kullanıcıyı kaydet
            return repository.save(existingCategory);
        } else {
            return null; // Kullanıcı bulunamadı
        }
    }
}
