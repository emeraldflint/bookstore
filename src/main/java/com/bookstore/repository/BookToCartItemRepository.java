package com.bookstore.repository;

import com.bookstore.domain.BookToCartItem;
import org.springframework.data.repository.CrudRepository;

public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {
}
