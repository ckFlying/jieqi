package service;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import entity.Diary;
import entity.Operation;
import entity.Result;
import entity.TableData;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * create by wjwang on ${date}
 */
@Service
public class DbService {
    public List<TableData> getSqlInfo(String url, String userName, String pwd){
        List<TableData> tableDatas=new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            tableDatas=null;
        }
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection=DriverManager.getConnection(url,userName,pwd);
            statement=connection.createStatement();
            String sql="select TABLE_NAME as tableName,TABLE_COMMENT as tableComment from information_schema.`TABLES` where TABLE_SCHEMA = '" + url.substring(url.lastIndexOf('/')+1,url.indexOf('?')) + "'";
            resultSet=statement.executeQuery(sql);
            int i=0;
            if(resultSet!=null){
                while (resultSet.next()){
                    TableData tableData=new TableData();
                    tableData.setTitle(resultSet.getString("tableName"));
                    Operation op=new Operation();
                    op.setGenerator(true);
                    tableData.setOperation(op);
                    tableData.setId(i);
                    i++;
                    tableDatas.add(tableData);
                }
            }
        } catch (SQLException e) {
            tableDatas=null;
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return tableDatas;
    }
    public Result Generator(String url, String userName, String pwd,String outDir,String[] tables) {
        List<TableFill> tableFillList = new ArrayList<TableFill>();
        Result result=new Result();
        DataSourceConfig da = new DataSourceConfig().setDbType(DbType.MYSQL)// 数据库类型
                .setTypeConvert(new MySqlTypeConvert() {
                    // 自定义数据库表字段类型转换【可选】
                    @Override
                    public DbColumnType processTypeConvert(String fieldType) {
                        System.out.println("转换类型：" + fieldType);
                        if (fieldType.toLowerCase().contains("tinyint")) {
                            return DbColumnType.BOOLEAN;
                        } else if (fieldType.toLowerCase().contains("char")) {
                            return DbColumnType.STRING;
                        } else if (fieldType.toLowerCase().contains("datetime")) {
                            return DbColumnType.DATE;
                        }
                        return super.processTypeConvert(fieldType);
                    }
                }).setDriverName("com.mysql.jdbc.Driver").setUsername(userName).setPassword(pwd).setUrl(url);
        if (da.getConn() == null) {
                result.setCode(404);
                result.setStatus("mysql NOT FOUND");
        } else {
            List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
            focList.add(new FileOutConfig("/templates/controller.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return "E:\\db\\generator\\controller\\" + tableInfo.getEntityName() + "Controller.java";
                }
            });
            // 代码生成器
            AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
                    // 全局配置
                    new GlobalConfig().setOutputDir(outDir)// 输出目录
                            .setFileOverride(true)// 是否覆盖文件
                            .setActiveRecord(true)// 开启 activeRecord 模式
                            .setEnableCache(false)// XML 二级缓存
                            .setBaseResultMap(false)// XML ResultMap
                            .setBaseColumnList(true)// XML columList
                            .setAuthor("ckFlying")
                            // 自定义文件命名，注意 %s 会自动填充表实体属性！
                            .setXmlName("%sMapper").setMapperName("%sMapper")
                            .setServiceName("%sService")
                            .setServiceImplName("%sServiceImpl")
                            .setControllerName("%sController")
            ).setDataSource(
                    // 数据源配置
                    da)
                    .setStrategy(
                            // 策略配置
                            new StrategyConfig()
                                    // .setCapitalMode(true)// 全局大写命名
                                    .setDbColumnUnderline(true)// 全局下划线命名
                                    // .setTablePrefix(new String[]{"unionpay_"})// 此处可以修改为您的表前缀
                                    .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                                    .setInclude(tables) // 需要生成的表
                                    // .setExclude(new String[]{"test"}) // 排除生成的表
                                    // 自定义实体，公共字段
                                    // .setSuperEntityColumns(new String[]{"test_id"})
                                    .setTableFillList(tableFillList)
                                    // 自定义实体父类
                                    // .setSuperEntityClass("com.baomidou.demo.common.base.BsBaseEntity")
                                    // // 自定义 mapper 父类
                                    // .setSuperMapperClass("com.baomidou.demo.common.base.BsBaseMapper")
                                    // // 自定义 service 父类
                                    // .setSuperServiceClass("com.baomidou.demo.common.base.BsBaseService")
                                    // // 自定义 service 实现类父类
                                    // .setSuperServiceImplClass("com.baomidou.demo.common.base.BsBaseServiceImpl")
                                    // 自定义 controller 父类
                                    // .setSuperControllerClass("com.baomidou.demo.TestController")
                                    // 【实体】是否生成字段常量（默认 false）
                                    // public static final String ID = "test_id";
                                    .setEntityColumnConstant(true)
                                    // 【实体】是否为构建者模型（默认 false）
                                    // public User setName(String name) {this.name = name; return this;}
                                    .setEntityBuilderModel(true)
                                    // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                                    .setEntityLombokModel(true)
                            // Boolean类型字段是否移除is前缀处理
                            // .setEntityBooleanColumnRemoveIsPrefix(true)
                            // .setRestControllerStyle(true)
                            // .setControllerMappingHyphenStyle(true)
                    ).setPackageInfo(
                            // 包配置
                            new PackageConfig()
                                    .setModuleName("generator").setParent("db")// 自定义包路径
                                    .setController("controller")// 这里是控制器包名，默认 web
                                    .setXml("service.mapper.xml").setMapper("service.mapper").setEntity("service.model").setService("service").setServiceImpl("service.impl")

                    ).setCfg(new InjectionConfig() {
                        @Override
                        public void initMap() {
                        }
                    }.setFileOutConfigList(focList)).setTemplate(new TemplateConfig().setController(null));
            // 执行生成
            mpg.execute();
            result.setCode(200);
        }
        return result;
    }
    public static void InvokeToFile(Object object){
        Class<?> cls=object.getClass();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            // 得到成员变量的类型的类类型
            if(method.getName().contains("get") && !"getClass".equals(method.getName()) ){
                System.out.println(method.getName());

            }
        }
    }

    public static void main(String[] args) {
        InvokeToFile(new Diary());
    }
}
