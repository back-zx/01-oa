package com.oa.desktop.news.newslabel.service;

import com.oa.commons.beans.NewsLabel;
import com.oa.commons.vo.Page;

import java.util.List;

public interface INewsLabelService {

    //查询当前页码数
    Page<NewsLabel> findCurrentPage(Integer pageNum,Integer pid);

    //查询所有的一级栏目
    List<NewsLabel> findAllParent();

    //删除所选栏目
    int deleteNewsLabel(Integer id);

    //添加栏目中：找到所有的栏目名称
    List<NewsLabel> findAllNewsLabelName();

    //添加栏目信息
    void addNewsLabel(NewsLabel newsLabel);

    //通过id查询栏目信息
    NewsLabel findByIdNewsLabel(Integer id);

    //修改栏目信息
    void changeNewsLabel(NewsLabel newsLabel);

    //通过栏目名称获取栏目的id
    Integer selectIdByLabelName(String label_name);
}
