package com.bookstore.service.impl;

import com.bookstore.domain.User;
import com.bookstore.repository.PasswordResetTokenRepository;
import com.bookstore.repository.RoleRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.security.PasswordResetToken;
import com.bookstore.security.UserRole;
import com.bookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by z-dus on 09.05.2017.
 */
@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

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

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User localUser = userRepository.findByUsername(user.getUsername());

        if(localUser != null){
            //throw new Exception("user already exist. Nothing will be done");
            LOG.info("user {} already exist. Nothing will be done", user.getUsername());
        }else {
            for (UserRole ur : userRoles){
                roleRepository.save(ur.getRole());
            }
        }

            user.getUserRoles().addAll(userRoles);
        localUser = userRepository.save(user);

        return localUser;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
