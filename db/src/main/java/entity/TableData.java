package entity;

/**
 * create by wjwang on 2018/10/24
 */
public class TableData {
    private int id;
    private String title;
    private String url;
    private String type;
    private String publishTime;
    private String publishStatus;
    private String pushStatus;
    private Operation operation;

    public TableData() {
        this.id = 3;
        this.title = "wwj";
        this.url = "https://item.taobao.com/item.htm?id=558559528377";
        this.type = "";
        this.publishTime = "";
        this.publishStatus = "";
        this.pushStatus = "";
        Operation operation=new Operation();
        operation.setEdit(true);
        this.operation = operation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus) {
        this.publishStatus = publishStatus;
    }

    public String getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(String pushStatus) {
        this.pushStatus = pushStatus;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
