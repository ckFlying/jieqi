package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * create by wjwang on ${date}
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private RedisSessionDAO redisSessionDAO;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        UserInfo userInfo  = (UserInfo)principals.getPrimaryPrincipal();
//        for(SysRole role:userInfo.getRoleList()){
//            authorizationInfo.addRole(role.getRole());
//            for(SysPermission p:role.getPermissions()){
//                authorizationInfo.addStringPermission(p.getPermission());
//            }
//        }
        authorizationInfo.addRole("admin:find");
        return authorizationInfo;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        Object username = (Object)token.getPrincipal();
        //单用户登录
        //处理session
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        MySessionManager sessionManager = (MySessionManager) securityManager.getSessionManager();
        //获取当前已登录的用户session列表
        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();
        for(Session session : sessions) {
            //清除该用户以前登录时保存的session，强制退出
            Object attribute = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (attribute == null) {
                continue;
            }
            else{
                if( attribute.toString().equals(username.toString()) ){
                    sessionManager.getSessionDAO().delete(session);
                }
            }
        }
        //获取用户的输入的账号.
        System.out.println(token.getCredentials().toString());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//        UserInfo userInfo = userInfoService.findByUsername(username);
//        System.out.println("----->>userInfo="+userInfo);
//        if(userInfo == null){
//            return null;
//        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                "wwj", //用户名
                "5d03440be75ed3c2c11d07bfbce911b0", //密码
                ByteSource.Util.bytes("http"),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    public static void main(String[] args) {
       String s= new SimpleHash("md5", "123", "http", 2).toHex();
        System.out.println(s);
    }
}
