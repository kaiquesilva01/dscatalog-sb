package com.developer.dscatalog.repositories;

import com.developer.dscatalog.entities.Role;
import com.developer.dscatalog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

}
