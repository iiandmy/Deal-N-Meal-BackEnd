package com.example.dealnmeal.DAO;

import com.example.dealnmeal.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemDAO extends JpaRepository<MenuItem, Long> {

}
