package io.github.ljun51.web;

import io.github.ljun51.pojo.User;
import io.github.ljun51.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> selectList(@RequestParam(required = false) String username) {
        return userService.selectList(new User.Builder().username(username).build());
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping()
    public boolean insert(@Valid @RequestBody User user) {
        return userService.insert(user);
    }

    @PutMapping("/{id}")
    public boolean update(@Valid @RequestBody User user, @PathVariable String id) {
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {
        return userService.delete(id);
    }
}
