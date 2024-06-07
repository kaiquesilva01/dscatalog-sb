package com.developer.dscatalog.repositories;

import com.developer.dscatalog.entities.Product;
import com.developer.dscatalog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
