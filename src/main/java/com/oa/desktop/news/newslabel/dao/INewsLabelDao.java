package com.oa.desktop.news.newslabel.dao;

import com.oa.commons.beans.NewsLabel;
import com.oa.commons.vo.Page;

import java.util.List;

public interface INewsLabelDao {

    //查询所有的栏目数
    int selectAllCount(Page<NewsLabel> page);

    //查询当前页码数
    List<NewsLabel> selectCurrentPageNewsLabels(Page<NewsLabel> page);

    //根据栏目名称查询：查询出所有的一级栏目
    List<NewsLabel> selectAllParent();

    //查询所有的栏目信息
    List<NewsLabel> selectAllNewsLabel();

    //删除所选栏目
    int deleteNewsLabel(Integer id);

    //通过id查询栏目信息
    NewsLabel selectByIdNewsLabel(Integer id);

    //修改栏目信息
    void updateNewsLabel(NewsLabel newsLabel);

    //添加栏目信息：通过栏目名称获取栏目的id
    Integer selectIdByLabelName(String label_name);

    //插入新的栏目信息
    void insertNewsLabel(NewsLabel newsLabel);
}
