package com.bookstore.service;

import com.bookstore.domain.User;
import com.bookstore.security.PasswordResetToken;

/**
 * Created by z-dus on 09.05.2017.
 */
public interface UserService {
    PasswordResetToken getPasswordResetToken(final String token);

    void createPasswordResetTokenForUser(final User user, final String token);

    User findByUserName(String username);

    User findByEmail(String email);
}
