package entity;

import java.util.List;

/**
 * create by wjwang on 2018/10/10
 */
public class Page<T> {
    private int size;
    private List<T> list;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
