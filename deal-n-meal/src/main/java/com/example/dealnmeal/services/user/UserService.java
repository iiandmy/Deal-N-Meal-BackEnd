package com.example.dealnmeal.services.user;

import com.example.dealnmeal.DAO.RoleDAO;
import com.example.dealnmeal.DAO.UserDAO;
import com.example.dealnmeal.models.Role;
import com.example.dealnmeal.models.User;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final RoleDAO roleDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserDAO userDAO, RoleDAO roleDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(JSONObject userData) {
        User newUser = new User();
        newUser.setName(userData.getString("name"));
        newUser.setSurname(userData.getString("surname"));
        newUser.setEmail(userData.getString("email"));
        newUser.setContactNumber(userData.getString("contactNumber"));
        newUser.setBirthDate(new Date(userData.getString("birthDate")));
        newUser.setRegistrationDate(new Date());
        newUser.setUsername(userData.getString("username"));
        newUser.setPassword(passwordEncoder.encode(userData.getString("password")));
        Role userRight = roleDAO.findByName("USER");
        newUser.setRolesSet(Arrays.asList(userRight));
        userDAO.save(newUser);
    }
}
