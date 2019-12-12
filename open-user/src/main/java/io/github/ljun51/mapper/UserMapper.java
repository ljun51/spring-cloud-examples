package io.github.ljun51.mapper;

import io.github.ljun51.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectList(User user);

    User selectOne(@Param("id") String id);

    int insert(User user);

    int update(User user);

    int delete(String id);
}
