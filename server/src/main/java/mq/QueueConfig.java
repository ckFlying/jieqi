package mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.jms.Queue;

/**
 * create by wjwang on 2018/7/6
 */
@Configuration
public class QueueConfig {

    @Bean("Queue")
    public Queue logQueue() {
        return new ActiveMQQueue("wwj");
    }

}
