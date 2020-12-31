package com.oa.desktop.news.newslabel.service;

import com.oa.commons.beans.NewsLabel;
import com.oa.commons.vo.Page;
import com.oa.desktop.news.newslabel.dao.INewsLabelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsLabelServiceImpl implements INewsLabelService {

    @Autowired
    private INewsLabelDao dao;

    //查询当前页码数
    @Override
    public Page<NewsLabel> findCurrentPage(Integer pageNum,Integer pid) {
        Page<NewsLabel> page=new Page<>();
        page.setPageNum(pageNum);
        page.setPid(pid);
        int totalRows=dao.selectAllCount(page);
        page.setTotalRows(totalRows);

        List<NewsLabel> datas=dao.selectCurrentPageNewsLabels(page);
        page.setDatas(datas);
        return page;
    }

    //查询所有的一级栏目
    @Override
    public List<NewsLabel> findAllParent() {

        List<NewsLabel> parent=dao.selectAllParent();
        return parent;
    }

    //删除所选栏目
    @Override
    public int deleteNewsLabel(Integer id) {
        int manage=dao.deleteNewsLabel(id);
        return manage;
    }

    //添加栏目中：找到所有的栏目名称
    @Override
    public List<NewsLabel> findAllNewsLabelName() {
        List<NewsLabel> newsLabelList=dao.selectAllNewsLabel();
        return newsLabelList;
    }

    //添加栏目信息
    @Override
    public void addNewsLabel(NewsLabel newsLabel) {
        dao.insertNewsLabel(newsLabel);
    }

    //通过id查询栏目信息
    @Override
    public NewsLabel findByIdNewsLabel(Integer id) {
        NewsLabel newsLabel=dao.selectByIdNewsLabel(id);
        return newsLabel;
    }

    //修改栏目信息
    @Override
    public void changeNewsLabel(NewsLabel newsLabel) {
        dao.updateNewsLabel(newsLabel);
    }

    //通过栏目名称获取栏目的id
    @Override
    public Integer selectIdByLabelName(String label_name) {
        Integer id=dao.selectIdByLabelName(label_name);
        return id;
    }


}
