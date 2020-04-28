package com.jigglejam.traintrax.authentication;

import com.jigglejam.traintrax.user.ApplicationUser;
import com.jigglejam.traintrax.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AuthUserDetailsService implements UserDetailsService {
    @Autowired
    private ApplicationUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<ApplicationUser> maybeUser = userRepository.findByEmail(email);
        if (!maybeUser.isPresent()) {
            throw new UsernameNotFoundException(email);
        } else {
            ApplicationUser user = maybeUser.get();
            return new User(user.getEmail(), user.getPassword(), Collections.emptyList());
        }
    }
}