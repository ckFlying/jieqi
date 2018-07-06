package mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * create by wjwang on 2018/7/6
 */
@Service
public class MailUtil {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail() {
        //使用JavaMail的MimeMessage，支付更加复杂的邮件格式和内容
        MimeMessage msg = javaMailSender.createMimeMessage();
        //创建MimeMessageHelper对象，处理MimeMessage的辅助类
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(msg, true);
            //使用辅助类MimeMessage设定参数
            helper.setFrom("2504555829@qq.com");
            helper.setTo("2504555829@qq.com");
            helper.setSubject("测试");
            helper.setText("测试看看喽");
            //加载文件资源，作为附件
            System.out.println("fiel:"+ResourceUtils.getURL("classpath:").getPath()+"static/1.png");
            File file=new File(ResourceUtils.getURL("classpath:").getPath().replace("%20"," ")+"static/1.png");
            //加入附件
            if(file.exists()) {
                helper.addAttachment("test.png", file);
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
        }
        javaMailSender.send(msg);
    }
}
