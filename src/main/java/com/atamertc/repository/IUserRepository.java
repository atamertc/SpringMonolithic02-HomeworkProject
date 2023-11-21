package com.atamertc.repository;

import com.atamertc.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findOptionalByEmailAndPassword(String email,String password);
    List<User> findAllByFirstNameContainingIgnoreCase(String value);
    List<User> findAllByOrderByFirstName();
    List<User> findAllByEmailContainingIgnoreCase(String value);
    List<User> findAllByEmailEndingWith(String value);
    List<User> findAllByEmailStartingWith(String value);
    @Query("select u from User  as u where length(u.password)>?1")
    List<User> passwordLongerThan(int value);

}
