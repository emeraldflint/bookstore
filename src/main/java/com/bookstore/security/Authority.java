package com.bookstore.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by z-dus on 12.03.2017.
 */
public class Authority implements GrantedAuthority{

    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }


    @Override
    public String getAuthority() {
        return authority;
    }
}
