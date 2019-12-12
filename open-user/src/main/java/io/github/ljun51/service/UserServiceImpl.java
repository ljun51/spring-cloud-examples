package io.github.ljun51.service;

import io.github.ljun51.mapper.UserMapper;
import io.github.ljun51.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> selectList(User user) {
        return userMapper.selectList(user);
    }

    @Override
    public boolean insert(User user) {
        user.setId(String.valueOf(System.currentTimeMillis()));
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return 1 == userMapper.insert(user);
    }

    @Override
    public boolean update(User user) {
        User bo = getUserById(user.getId());
        bo.setUsername(user.getUsername());
        bo.setPassword(user.getPassword());
        bo.setUpdateTime(new Date());
        return 1 == userMapper.update(bo);
    }

    @Override
    public boolean delete(String id) {
        return 1 == userMapper.delete(id);
    }

    @Override
    public User getUserById(String id) {
        return userMapper.selectOne(id);
    }
}
