package ckflying.jieqi.core.Controller;


import config.DataSource;
import entity.Result;
import jq.server.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import jq.server.service.UserService;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author ckFlying
* @since 2018-11-27
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    @DataSource(name="jieqi")
    public Result register(User user) {
        return userService.register(user);
    }
}

