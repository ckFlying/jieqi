package config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * create by wjwang on ${date}
 */
@Aspect
@Component
public class DataSourceAop {
    @Before("@annotation(dataSource)")
    public void pointCut(JoinPoint joinPoint, DataSource dataSource){
        Class<?> cls=joinPoint.getTarget().getClass();
        System.out.println(cls.getName());
        System.out.println(joinPoint.getSignature().getName());
        DataSourceContextHolder.setDS(dataSource.name());
        System.out.println(dataSource.name());
    }
    @After("@annotation(config.DataSource)")
    public void after(JoinPoint point){
        DataSourceContextHolder.clearDS();
    }
}
