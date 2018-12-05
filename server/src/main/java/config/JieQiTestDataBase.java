package config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * create by wjwang on ${date}
 */
@Configuration
@MapperScan("jq.server.mapper")
public class JieQiTestDataBase {
    public static final String dataBase1="jieqi";
    @Bean(name=dataBase1)
    public DataSource getDATABASE_1(){
        System.out.println("getDATABASE_1 init");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setMaxActive(60);
        dataSource.setInitialSize(10);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setMinIdle(10);
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/"+dataBase1+"?useSSL=false&useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }
    public static final String dataBase2="test2";
    @Bean(name=dataBase2)
    public DataSource getDATABASE_2(){
        System.out.println("getDATABASE_2 init");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setMaxActive(60);
        dataSource.setInitialSize(10);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setMinIdle(10);
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/"+dataBase2+"?useSSL=false&useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier(dataBase1) DataSource myTestDbDataSource,
             @Qualifier(dataBase2) DataSource myTestDb2DataSource) {
        System.out.println("DynamicDataSource init");
        DynamicDataSource dynamicDataSource=new DynamicDataSource();
        Map<Object,Object> dataSources=new HashMap<Object, Object>();
        dataSources.put(dataBase1,myTestDbDataSource);
        dataSources.put(dataBase2,myTestDb2DataSource);
        dynamicDataSource.setTargetDataSources(dataSources);
        return dynamicDataSource;
    }
    //注：重要---要使用mybatis-plus的默认CRUD需要使用MybatisSqlSessionFactoryBean，不能使用原生的SqlSessionFactoryBean
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(DynamicDataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean=new MybatisSqlSessionFactoryBean();
        //默认为jieqi数据库
        DataSourceContextHolder.setDS(dataBase1);
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }
    //分页
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
