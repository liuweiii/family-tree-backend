package org.liuwei.familytree.utils;

import java.util.List;

/**
 * Created by apple on 2017/3/23.
 */
public class Paginate<T> {
    private int total;
    private List<T> data;

    public Paginate(int total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public List<T> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Paginate{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }
}
