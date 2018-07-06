package ckflying.jieqi.core.Controller;

import Config.DataSource;
import Config.JieQiTestDataBase;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TestService;

import javax.jms.Queue;

/**
 * create by wjwang on ${date}
 */
@RestController
@RequestMapping("test")
public class TestCon {
    @Autowired
    private TestService testService;
    @GetMapping("start1")
    @DataSource(name=JieQiTestDataBase.dataBase1)
    public String start(String name){
        testService.getFace();
        return "1";
    }
    @GetMapping("start2")
    @DataSource(name=JieQiTestDataBase.dataBase2)
    public String start2(String name){
        testService.getFace();
        return "1";
    }
    @GetMapping("login")
    private String login(String name,String pwd){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(name,pwd);
        subject.login(token);
        return "login";
    }
}
