package shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * create by wjwang on 2018/11/21
 */
public class MyShiroSessionListener implements SessionListener {
    @Override
    public void onStart(Session session) {
        //获取存入redis的sessionId
        System.out.println("current session: "+session.getId());
        RedisSessionIDUtil redisSessionIDUtil=RedisSessionIDUtil.getInstance();
        redisSessionIDUtil.setId( session.getId().toString());
    }

    @Override
    public void onStop(Session session) {

    }

    @Override
    public void onExpiration(Session session) {

    }
}
