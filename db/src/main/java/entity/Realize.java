package entity;

import java.util.Date;

public class Realize {
    private Integer realizeId;

    private String sign;

    private String signName;

    private Integer index;

    private String indexName;

    private String sql;

    private String info;

    private Date createTime;

    private Date updateTime;

    private Integer interfaceId;

    public Integer getRealizeId() {
        return realizeId;
    }

    public void setRealizeId(Integer realizeId) {
        this.realizeId = realizeId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName == null ? null : signName.trim();
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName == null ? null : indexName.trim();
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql == null ? null : sql.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }
}