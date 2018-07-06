package mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;


/**
 * create by wjwang on 2018/7/6
 */

@Component
public class LogProducer implements CommandLineRunner {


    @Autowired
    private JmsTemplate jmsMessagingTemplate;

    @Autowired
    private Queue logQueue;

    @Override
    public void run(String... strings) throws Exception {
        send("This is a log message.");
    }

    public void send(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.logQueue, msg);
    }
}
