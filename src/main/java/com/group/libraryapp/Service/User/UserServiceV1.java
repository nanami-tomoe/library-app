package com.group.libraryapp.Service.User;

import com.group.libraryapp.Repository.user.UserJdbcRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    public void saveUser(UserCreateRequest request) {
        userJdbcRepository.saveUser(request.getName(), request.getAge());
    }

    public List<UserResponse> getUsers() {
        return userJdbcRepository.getUserResponses();
    }

    public void updateUser(UserUpdateRequest request) {
        if (userJdbcRepository.IsUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }

        userJdbcRepository.updateUserName(request.getName(), request.getId());
    }

    public void deleteUser(String name) {
        if (userJdbcRepository.IsUserNotExist(name)) {
            throw new IllegalArgumentException();
        }

        userJdbcRepository.deleteUserByName(name);
    }
}
