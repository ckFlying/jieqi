package Config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * create by wjwang on ${date}
 */
@Component
public class SpringUtil implements ApplicationContextAware{
//,BeanFactoryPostProcessor,BeanDefinitionRegistryPostProcessor,InitializingBean {
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
        System.out.println("---------------------------------------------------------------------");

        System.out.println("---------------------------------------------------------------------");

        System.out.println("---------------me.shijunjie.util.SpringUtil------------------------------------------------------");

        System.out.println("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="+SpringUtil.applicationContext+"========");

        System.out.println("---------------------------------------------------------------------");
    }
    private static ApplicationContext applicationContext;
    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean.
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
    //可以用于修改spring中bean 的属性信息
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//
//    }
//    //在bena加载之前执行
//    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//        System.out.println("BeanDefinitionRegistry init");
//        registry.registerBeanDefinition("sqlSessionFactory", getDefinition(SqlSessionFactoryBean.class));
//    }
//    private BeanDefinition getDefinition(Class<?> cls) {
//        GenericBeanDefinition definition = new GenericBeanDefinition();
//        System.out.println(cls.getSimpleName());
//        if("SqlSessionFactoryBean".equals(cls.getSimpleName())){
//            Field f = null;
//            try {
//                // 调用getDeclaredField("name") 取得name属性对应的Field对象
//                f = cls.getDeclaredField("dataSource");
//                // 取消属性的访问权限控制，即使private属性也可以进行访问。
//                f.setAccessible(true);
//                f.set(cls.newInstance(),DataSourceContextHolder.getDS());
//
//            } catch (NoSuchFieldException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            }
//        }
//        definition.setBeanClass(cls);    //设置类
//        definition.setScope("singleton");       //设置scope
//        definition.setLazyInit(false);          //设置是否懒加载
//        definition.setAutowireCandidate(true);  //设置是否可以被其他对象自动注入
//        return definition;
//    }
//
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("初始化多数据源");
//        try {
////            initailizeMutiDataSource();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        System.out.println("多数据源加入spring容器中成功!");
//    }
}
