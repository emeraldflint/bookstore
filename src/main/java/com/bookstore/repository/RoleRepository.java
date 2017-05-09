package com.bookstore.repository;

import com.bookstore.security.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by z-dus on 10.05.2017.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);

}
