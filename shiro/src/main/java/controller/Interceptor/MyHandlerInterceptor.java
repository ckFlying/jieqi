package controller.Interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * create by wjwang on 2018/11/19
 */
public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");

        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");

        httpServletResponse.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");

        httpServletResponse.setHeader("X-Powered-By","Jetty");


        String method= httpServletRequest.getMethod();
        System.out.println("wdad"+method);
        if (method.equals("OPTIONS")){
            httpServletResponse.setStatus(200);
            return true;
        }

        return true;
    }
}
