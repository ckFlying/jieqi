package Config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * create by wjwang on ${date}
 */
@Configuration
@MapperScan("mapper")
public class JieQiTestDataBase {
    public static final String dataBase1="test";
    @Bean(name="test")
    public DataSource getDATABASE_1(){
        System.out.println("getDATABASE_1 init");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setMaxActive(60);
        dataSource.setInitialSize(10);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setMinIdle(10);
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test??useSSL=false&useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }
    public static final String dataBase2="test2";
    @Bean(name="test2")
    public DataSource getDATABASE_2(){
        System.out.println("getDATABASE_2 init");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setMaxActive(60);
        dataSource.setInitialSize(10);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setMinIdle(10);
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test2?useSSL=false&useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("test") DataSource myTestDbDataSource,
             @Qualifier("test2") DataSource myTestDb2DataSource) {
        System.out.println("DynamicDataSource init");
        DynamicDataSource dynamicDataSource=new DynamicDataSource();
        Map<Object,Object> dataSources=new HashMap<Object, Object>();
        dataSources.put(dataBase1,myTestDbDataSource);
        dataSources.put(dataBase2,myTestDb2DataSource);
        dynamicDataSource.setTargetDataSources(dataSources);
        return dynamicDataSource;
    }
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(DynamicDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }
}
