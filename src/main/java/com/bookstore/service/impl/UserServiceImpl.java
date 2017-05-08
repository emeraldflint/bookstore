package com.bookstore.service.impl;

import com.bookstore.domain.User;
import com.bookstore.repository.PasswordResetTokenRepository;
import com.bookstore.security.PasswordResetToken;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by z-dus on 09.05.2017.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public PasswordResetToken getPasswordResetToken(final String token) {
        return passwordResetTokenRepository.findByToken(token);
    }

    @Override
    public void createPasswordResetTokenForUser(final User user, final String token) {
          final PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(myToken);

    }
}
