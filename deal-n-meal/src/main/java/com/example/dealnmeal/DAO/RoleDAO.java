package com.example.dealnmeal.DAO;

import com.example.dealnmeal.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends JpaRepository<Role, Integer> {
    Role findByName(String roleName);
}
