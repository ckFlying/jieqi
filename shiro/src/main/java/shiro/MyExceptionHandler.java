package shiro;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * create by wjwang on 2018/11/14
 */
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        ModelAndView mv=new ModelAndView();
        FastJsonJsonView fastJsonJsonView=new FastJsonJsonView();
        Map<String,Object> attributes=new HashMap<>();
        if (ex instanceof UnauthenticatedException) {
            attributes.put("code", "1000001");
            attributes.put("msg", "token错误"+ex.getMessage());
        } else if (ex instanceof UnauthorizedException) {
            attributes.put("code", "1000002");
            attributes.put("msg", "用户无权限");
        } else {
            attributes.put("code", "1000003");
            attributes.put("msg", ex.getMessage()+","+ex.getCause());
        }

        fastJsonJsonView.setAttributesMap(attributes);
        mv.setView(fastJsonJsonView);
        return mv;
    }
}
