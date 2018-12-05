package service;

/**
 * create by wjwang on 2018/11/12
 */
public class GeneratorTest {
    public static void main(String[] args) {
        DbService dbService=new DbService();
        dbService.Generator("jdbc:mysql://localhost:3306/jieqi?useSSL=false&amp;serverTimezone=Asia/Shanghai&amp;useUnicode=true&amp;characterEncoding=UTF-8&amp;rewriteBatchedStatements=true",
                "root",
        "123456",
        "E:\\", new String[]{"user"});
    }
}
