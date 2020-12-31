package com.oa.commons.vo;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
    private int pageNum;        //当前页码
    private int pageStartIndex; //当前页的起始索引
    private int pageSize;       //页面大小
    private int totalRows;      //总记录数
    private int totalPages;     //总页码数
    private List<T> datas;      //当前页所包含的具体数据
    private Integer pid;            //用于查询父栏目的子孙栏目

    public Page() {
        this.pageNum=1;
        this.pageSize=3;
        datas=new ArrayList<>();
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageStartIndex() {
        return (pageNum-1)*pageSize;
    }

    public void setPageStartIndex(int pageStartIndex) {
        this.pageStartIndex = pageStartIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalPages() {
        if (totalRows%pageSize==0){
            totalPages=totalRows/pageSize;
        }else{
            totalPages=totalRows/pageSize+1;
        }
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageStartIndex=" + pageStartIndex +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                ", totalPages=" + totalPages +
                ", datas=" + datas +
                ", pid=" + pid +
                '}';
    }
}
