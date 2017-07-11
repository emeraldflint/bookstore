package com.bookstore.service;

import com.bookstore.domain.UserShipping;

public interface UserShippingService {
    UserShipping findById(long id);
    void removeById(Long id);
}
