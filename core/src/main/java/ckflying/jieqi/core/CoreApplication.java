package ckflying.jieqi.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan({"ckflying.jieqi.core.Controller","Config","service","mapper","shiro","mail"})
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }
}
