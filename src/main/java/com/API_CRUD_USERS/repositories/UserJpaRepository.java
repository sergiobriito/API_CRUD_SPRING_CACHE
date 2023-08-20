package com.API_CRUD_USERS.repositories;

import com.API_CRUD_USERS.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserJpaRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findById(UUID id);
    Optional<UserModel> findByUsername(String username);

    @Query(value = "SELECT * FROM TB_USER " +
            "WHERE " +
            "LOWER(username) LIKE '%' || LOWER(:reference) || '%' " +
            "OR " +
            "LOWER(name) LIKE '%' || LOWER(:reference) || '%' " +
            "OR " +
            "LOWER(stack) LIKE '%' || LOWER(:reference) || '%' " +
            "LIMIT 50",
            nativeQuery = true)
    List<UserModel> getUsersByReference(@Param("reference") String reference);

}
