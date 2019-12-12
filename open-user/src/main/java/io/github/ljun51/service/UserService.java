package io.github.ljun51.service;

import io.github.ljun51.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectList(User user);

    boolean insert(User user);

    boolean update(User user);

    boolean delete(String id);

    User getUserById(String id);
}
