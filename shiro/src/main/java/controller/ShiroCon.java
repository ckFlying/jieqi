package controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * create by wjwang on 2018/11/14
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShiroCon {
    @GetMapping("login")
    public String login(@RequestParam String username, @RequestParam String pwd){
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,pwd);
        Subject subject = SecurityUtils.getSubject();
        JSONObject jsonStr = new JSONObject();
        subject.login(usernamePasswordToken);
        jsonStr.put("code", 200);
        jsonStr.put("msg", "succcess");
        return jsonStr.toString();
    }
    @GetMapping("unauth")
    public String unauth(){
        JSONObject jsonStr = new JSONObject();
        jsonStr.put("code", 201);
        jsonStr.put("msg", "logout");
        return jsonStr.toString();
    }
    @GetMapping("unauhc")
    public void unauhc(){
        throw new UnauthorizedException();
    }
}
