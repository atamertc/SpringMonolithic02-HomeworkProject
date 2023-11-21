package com.atamertc.controller;

import com.atamertc.dto.request.LoginRequestDto;
import com.atamertc.dto.request.RegisterRequestDto;
import com.atamertc.dto.response.LoginResponseDto;
import com.atamertc.exception.EErrorType;
import com.atamertc.exception.ResourceNotFoundException;
import com.atamertc.repository.entity.User;
import com.atamertc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.atamertc.constant.EndPoints.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping(FINDALL)
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(SAVE)
    public ResponseEntity<?> createUser(String firstName, String lastName, String email, String password) {
        User user = User.builder().firstName(firstName).lastName(lastName).email(email).password(password).build();
        try {
            service.save(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(user);
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping(LOGIN)
    public ResponseEntity<?> login(LoginRequestDto dto) {
        LoginResponseDto user = null;
        try {
            user = service.login(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Hata olustu:" + e.getMessage());
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping(REGISTER)
    public ResponseEntity<User> register(RegisterRequestDto dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    @GetMapping(ORDER_BY_NAME)
    public ResponseEntity<List<User>> findAllByOrderByName() {
        return ResponseEntity.ok(service.findAllByOrderByName());
    }

    @GetMapping(CONTAINS_NAME)
    public ResponseEntity<?> findAllByNameContainingIgnoreCase(String value) {
        try {
            return ResponseEntity.ok(service.findAllByNameContainingIgnoreCase(value));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Hata olustu:" + e.getMessage());
        }
    }

    @GetMapping(CONTAINS_EMAIL)
    public ResponseEntity<List<User>> findAllByEmailContainingIgnoreCase(String value) {
        return ResponseEntity.ok(service.findAllByEmailContainingIgnoreCase(value));
    }

    @GetMapping(END_WITH_EMAIL)
    public ResponseEntity<List<User>> findAllByEmailEndingWith(String value) {
        return ResponseEntity.ok(service.findAllByEmailEndingWith(value));
    }

    @GetMapping(PASSWORD_CONTROL)
    public ResponseEntity<List<User>> passwordLongerThan(int value) {
        return ResponseEntity.ok(service.passwordLongerThan(value));
    }


}
