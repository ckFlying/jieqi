package mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * create by wjwang on 2018/7/6
 */
@Configuration
public class MailConfig {
    @Bean("JavaMailSender")
    public JavaMailSender setJavaMailSender(){
        JavaMailSenderImpl javaMailSender=new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.qq.com");
        javaMailSender.setPassword("uqfjhblrutlddjbc");
        javaMailSender.setUsername("2504555829@qq.com");
        //加认证机制
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", true);
        javaMailProperties.put("mail.smtp.starttls.enable", true);
        javaMailProperties.put("mail.smtp.timeout", 5000);
        javaMailSender.setJavaMailProperties(javaMailProperties);
        return javaMailSender;
    }
}
