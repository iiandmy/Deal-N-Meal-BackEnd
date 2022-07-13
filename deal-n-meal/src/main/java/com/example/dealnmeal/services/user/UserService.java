package com.example.dealnmeal.services.user;

import com.example.dealnmeal.models.Role;
import com.example.dealnmeal.models.User;
import net.sf.json.JSONObject;

import java.util.List;

public interface UserService {

    User saveUser(JSONObject userData);
    void saveRoles(JSONObject jsonRoles);
    void addRoleToUser(JSONObject jsonObject);
    User getUserByUsername(String username);
    List<User> getAllUsers();
}
