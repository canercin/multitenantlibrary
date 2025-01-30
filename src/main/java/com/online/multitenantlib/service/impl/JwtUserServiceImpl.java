package com.online.multitenantlib.service.impl;

import com.online.multitenantlib.model.JwtUserDetails;
import com.online.multitenantlib.repo.JwtUserRepository;
import com.online.multitenantlib.service.JwtUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class JwtUserServiceImpl implements JwtUserService {

    @Autowired
    private JwtUserRepository jwtUserRepository;

    @Override
    public List<JwtUserDetails> getAllUsers() {
        return jwtUserRepository.findAll();
    }

    @Override
    public Optional<JwtUserDetails> getUserByMail(String email) {
        return jwtUserRepository.findByEmail(email);
    }

    @Override
    public JwtUserDetails saveUser(JwtUserDetails jwtUserDetails) {
        return jwtUserRepository.save(jwtUserDetails);
    }

    @Override
    public JwtUserDetails updateUser(JwtUserDetails jwtUserDetails) {
        return jwtUserRepository.save(jwtUserDetails);
    }

    @Override
    public void deleteUser(JwtUserDetails jwtUserDetails) {
        jwtUserRepository.delete(jwtUserDetails);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                return jwtUserRepository.findByUsername(email).orElse(null);
            }
        };
    }

    @Override
    public Optional<JwtUserDetails> getUserByUsername(String email) {
        return jwtUserRepository.findByUsername(email);
    }
}
