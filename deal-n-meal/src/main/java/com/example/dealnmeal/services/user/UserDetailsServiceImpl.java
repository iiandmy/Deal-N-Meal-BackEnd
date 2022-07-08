package com.example.dealnmeal.services.user;

import com.example.dealnmeal.DAO.UserDAO;
import com.example.dealnmeal.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user with username: " + username);
        }
        return new CustomUserDetails(user);
    }
}
