package com.atamertc.service;

import com.atamertc.dto.request.LoginRequestDto;
import com.atamertc.dto.request.RegisterRequestDto;
import com.atamertc.dto.response.LoginResponseDto;
import com.atamertc.mapper.IUserMapper;
import com.atamertc.repository.IUserRepository;
import com.atamertc.repository.entity.User;
import com.atamertc.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends ServiceManager<User, Long> {

    private final IUserRepository repository;

    public UserService(IUserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public LoginResponseDto login(LoginRequestDto dto) {
        Optional<User> user = repository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (user.isEmpty()) {
            throw new RuntimeException("Kullancı adı veya şifre hatalı");
        }
        return IUserMapper.INSTANCE.toLoginResponseDto(user.get());
    }

    public User register(RegisterRequestDto registerRequestDto) {
        User user = IUserMapper.INSTANCE.toUser(registerRequestDto);
        return repository.save(user);

    }

    public List<LoginResponseDto> findAllByNameContainingIgnoreCase(String value) {
        List<User> list = repository.findAllByFirstNameContainingIgnoreCase(value);
        if (list.isEmpty()) {
            throw new RuntimeException("Aranan kriterde herhangi bir kullanıcı bulunamadı");
        }
        return IUserMapper.INSTANCE.toLoginResponseDtos(list);
    }

    public List<User> findAllByOrderByName() {
        return repository.findAllByOrderByFirstName();
    }

    public List<User> findAllByEmailContainingIgnoreCase(String value) {
        return repository.findAllByEmailContainingIgnoreCase(value);
    }

    public List<User> findAllByEmailEndingWith(String value) {
        return repository.findAllByEmailEndingWith(value);
    }

    public List<User> passwordLongerThan(int value) {
        return repository.passwordLongerThan(value);
    }
}
