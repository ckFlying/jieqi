package shiro;

/**
 * create by wjwang on 2018/11/21
 */
public class RedisSessionIDUtil {
    private String id;
    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }
    private static RedisSessionIDUtil redisSessionIDUtil;
    public static RedisSessionIDUtil getInstance(){
        if(redisSessionIDUtil==null){
            synchronized (RedisSessionIDUtil.class) {
                if (redisSessionIDUtil == null) {
                    redisSessionIDUtil = new RedisSessionIDUtil();
                }
            }
        }
        return redisSessionIDUtil;
    }
}
