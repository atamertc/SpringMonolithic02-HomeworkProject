package com.atamertc.repository;

import com.atamertc.repository.entity.Category;
import com.atamertc.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
