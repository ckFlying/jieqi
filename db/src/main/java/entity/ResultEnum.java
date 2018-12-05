package entity;

/**
 * create by wjwang on 2018/11/27
 */
public enum ResultEnum {
    RESULT_ENUM_10000(10000,"注册失败"),
    RESULT_ENUM_10001(200,"注册成功");

    private int code;
    private String msg;
    ResultEnum(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public int code(){
        return this.code;
    }
    public String msg(){
        return this.msg;
    }
}
