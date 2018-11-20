package shiro;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * create by wjwang on 2018/11/19
 */
@Log4j2
public class AuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpResp = WebUtils.toHttp(response);
        HttpServletRequest httpReq = WebUtils.toHttp(request);
        log.debug("Shiro: onAccessDenied");
        /**系统重定向会默认把请求头清空，这里通过拦截器重新设置请求头，解决跨域问题*/
        httpResp.addHeader("Access-Control-Allow-Origin", httpReq.getHeader("Origin"));
        httpResp.addHeader("Access-Control-Allow-Headers", "*");
        httpResp.addHeader("Access-Control-Allow-Methods", "*");
        httpResp.addHeader("Access-Control-Allow-Credentials", "true");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returnCode", 401);
        jsonObject.put("returnMsg", "权限不足");
        WebUtils.toHttp(response).getWriter().println(jsonObject);
        return false;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        log.debug("Shiro: isAccessAllowed");
        if (request instanceof HttpServletRequest) {
            if (((HttpServletRequest) request).getMethod().toUpperCase().equals("OPTIONS")) {
                return true;
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean isLoginSubmission(ServletRequest request, ServletResponse response) {
        log.debug("Shiro: isLoginSubmission");
        return super.isLoginSubmission(request, response);
    }

    @Override
    protected boolean isLoginRequest(ServletRequest request, ServletResponse response) {
        log.debug("Shiro: isLoginRequest");
        return super.isLoginRequest(request, response);
    }

    @Bean
    public FilterRegistrationBean registration(AuthenticationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }
}
