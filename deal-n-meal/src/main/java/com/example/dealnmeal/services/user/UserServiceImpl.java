package com.example.dealnmeal.services.user;

import com.example.dealnmeal.DAO.RoleDAO;
import com.example.dealnmeal.DAO.UserDAO;
import com.example.dealnmeal.models.Role;
import com.example.dealnmeal.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDAO userDAO;
    private final RoleDAO roleDAO;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);
        if (user == null) {
            log.error("UserDetailsService.loadUserByUsername: user not found. username: " + username);
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }
        else {
            log.info("UserDetailsService.loadUserByUsername: user found. username: " + username);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }

    @Override
    public User saveUser(JSONObject userData) {
        User newUser = new User();
        newUser.setName(userData.getString("name"));
        newUser.setSurname(userData.getString("surname"));
        newUser.setEmail(userData.getString("email"));
        newUser.setContactNumber(userData.getString("contactNumber"));
        newUser.setBirthDate(new Date(userData.getString("birthDate")));
        newUser.setRegistrationDate(new Date());
        newUser.setUsername(userData.getString("username"));
        newUser.setPassword(passwordEncoder.encode(userData.getString("password")));
        Role userRight = roleDAO.findByName("ROLE_USER");
        newUser.setRoles(Arrays.asList(userRight));
        return userDAO.save(newUser);
    }

    @Override
    public void saveRoles(JSONObject jsonRoles) {
        JSONArray roles = jsonRoles.getJSONArray("role_names");
        for (int i = 0; i < roles.size(); i++) {
            Role role = new Role();
            role.setName(roles.getString(i));
            roleDAO.save(role);
        }
    }

    @Override
    public void addRoleToUser(JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        JSONArray roles = jsonObject.getJSONArray("roles");
        System.out.println(username);
        System.out.println(roles);
        User user = userDAO.findByUsername(username);
        for(int i = 0; i < roles.size(); i++) {
            Role role = roleDAO.findByName(roles.getString(i));
            user.getRoles().add(role);
        }
    }

    @Override
    public User getUserByUsername(String username) {
        log.info("Getting user by username: {}", username);
        return userDAO.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Getting all users");
        return userDAO.findAll();
    }
}

