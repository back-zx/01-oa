package com.oa.desktop.news.newslabel.handler;

import com.oa.commons.beans.NewsLabel;
import com.oa.commons.vo.Page;
import com.oa.desktop.news.newslabel.service.INewsLabelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/desktop/news")
public class NewsLabelHandler {

    @Autowired
    private INewsLabelService service;

    @RequestMapping("/queryNewsLabel")
    public String queryNewsLabel(@RequestParam(defaultValue = "1") Integer pageNum, Model model,@RequestParam(defaultValue = "0") Integer pid){
        //查询所有的栏目信息，并且分页显示
        Page<NewsLabel> page= service.findCurrentPage(pageNum,pid);
        //查询所有的一级栏目
        List<NewsLabel> parent=service.findAllParent();
        model.addAttribute("page",page);
        model.addAttribute("parent",parent);
        return "/html/news/newsLabelManager.jsp";
    }

    //删除栏目信息
    @RequestMapping("/deleteNewsLabel")
    public String deleteNewsLabel(@Param("id") Integer id){
        int manage=service.deleteNewsLabel(id);
        return "/desktop/news/queryNewsLabel";
    }

    //给添加栏目信息传递值
    @RequestMapping("/toAddNewsLabel")
    public String toAddNewsLabel(Model model){
        List<NewsLabel> newsLabelList=service.findAllNewsLabelName();
        model.addAttribute("newsLabelList",newsLabelList);
        return "/html/news/addNewsLabel.jsp";
    }

    //添加信息
    @RequestMapping("/addNewsLabel")
    public String addNewsLabel(@RequestParam("labelName") String labelName,@RequestParam("superLabelName") String superLabelName,@RequestParam("labelContent") String labelContent){
        Integer pid=service.selectIdByLabelName(superLabelName);
        NewsLabel newsLabel=new NewsLabel();
        newsLabel.setPid(pid);
        newsLabel.setLabel_content(labelContent);
        newsLabel.setLabel_name(labelName);
        service.addNewsLabel(newsLabel);
        return "/desktop/news/toAddNewsLabel";
    }

    //修改栏目信息
    @RequestMapping("/toChangeNewsLabel")
    public String  toChangeNewsLabel(Integer id,Model model){
        NewsLabel newsLabel=service.findByIdNewsLabel(id);
        List<NewsLabel> newsLabelList=service.findAllNewsLabelName();
        model.addAttribute("newsLabelList",newsLabelList);
        model.addAttribute("newsLabel",newsLabel);
        return "/html/news/changeNewsLabel.jsp";
    }
    @RequestMapping("/changeNewsLabel")
    public String changeNewsLabel(@RequestParam("id") Integer id,@RequestParam("labelName") String labelName,@RequestParam("superLabelName") String superLabelName,@RequestParam("labelContent") String labelContent){
        NewsLabel newsLabel=new NewsLabel();
        newsLabel.setId(id);
        newsLabel.setLabel_name(labelName);
        newsLabel.setLabel_content(labelContent);
        Integer pid = service.selectIdByLabelName(superLabelName);
        newsLabel.setPid(pid);
        service.changeNewsLabel(newsLabel);
        return "redirect:/desktop/news/toChangeNewsLabel?id="+id;
    }
}
