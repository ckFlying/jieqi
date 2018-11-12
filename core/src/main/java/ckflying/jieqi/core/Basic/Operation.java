package ckflying.jieqi.core.Basic;

/**
 * create by wjwang on 2018/10/24
 */
public class Operation {
    private boolean insert;
    private boolean delete;
    private boolean edit;

    public boolean isInsert() {
        return insert;
    }

    public void setInsert(boolean insert) {
        this.insert = insert;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
}
