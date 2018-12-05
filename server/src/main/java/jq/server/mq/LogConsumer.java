package jq.server.mq;

import org.springframework.stereotype.Component;
//import org.springframework.jms.annotation.JmsListener;

/**
 * create by wjwang on 2018/7/6
 */

@Component
public class LogConsumer {

//    @JmsListener(destination = "wwj")
    public void receivedQueue(String msg) {
        System.out.println("Has received from " + "wwj" + ", msg: " + msg);
    }
}
