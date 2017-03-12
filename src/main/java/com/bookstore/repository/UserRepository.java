package com.bookstore.repository;

import com.bookstore.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by z-dus on 13.03.2017.
 */
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);

}
