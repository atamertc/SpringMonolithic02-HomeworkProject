package com.atamertc.controller;

import com.atamertc.dto.request.CategorySaveRequestDto;
import com.atamertc.dto.response.CategoryFindAllResponseDto;
import com.atamertc.repository.entity.Category;
import com.atamertc.service.CategoryService;
import com.atamertc.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.atamertc.constant.EndPoints.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @PostMapping(SAVE)
    public ResponseEntity<String> save(CategorySaveRequestDto dto) {
        service.saveDto(dto);
        return ResponseEntity.ok("Category Kaydı başarılı.");
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<CategoryFindAllResponseDto>> findAll() {
        return ResponseEntity.ok(service.findAllResponseDtos());
    }

    @GetMapping(GETBYID)
    public ResponseEntity<Optional<Category>> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(DELETE)
    public ResponseEntity<String> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Kayıt silindi.");
    }


}
