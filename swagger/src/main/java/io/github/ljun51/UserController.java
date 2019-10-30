package io.github.ljun51;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/user")
@Api(tags = "用户相关接口", description = "提供用户相关的Rest API")
public class UserController {

    @ApiOperation("新增用户接口")
    @PostMapping()
    public boolean addUser(@RequestBody User user) {
        return false;
    }

    @ApiOperation("查看用户接口")
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") int id,
                         @RequestParam(defaultValue = "1") String page) {
        return new User();
    }

    @PutMapping()
    @ApiImplicitParam
    public boolean update(@RequestBody User user) {
        return true;
    }

    @ApiIgnore
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return true;
    }
}
