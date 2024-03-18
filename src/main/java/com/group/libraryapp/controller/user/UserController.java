package com.group.libraryapp.controller.user;

import com.group.libraryapp.Service.User.UserServiceV2;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceV2 UserService;

    public UserController(UserServiceV2 UserService)  {
        this.UserService = UserService;
    }

    @PostMapping("/user") // POST
    // /user
    public void saveUser(@RequestBody UserCreateRequest request) {
        UserService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return UserService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        UserService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        UserService.deleteUser(name);
    }

}
