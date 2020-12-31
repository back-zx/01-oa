package com.oa.commons.beans;

import java.util.List;

public class NewsLabel {
    private Integer id;
    private String label_name;
    private String label_content;
    private Integer pid;
    //关联属性:当前类作为一方
    private List<NewsLabel> children;
    //关联属性:当前类作为多方
    private NewsLabel parent;

    public NewsLabel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }

    public String getLabel_content() {
        return label_content;
    }

    public void setLabel_content(String label_content) {
        this.label_content = label_content;
    }

    public List<NewsLabel> getChildren() {
        return children;
    }

    public void setChildren(List<NewsLabel> children) {
        this.children = children;
    }

    public NewsLabel getParent() {
        return parent;
    }

    public void setParent(NewsLabel parent) {
        this.parent = parent;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "NewsLabel{" +
                "id=" + id +
                ", label_name='" + label_name + '\'' +
                ", label_content='" + label_content + '\'' +
                ", pid=" + pid +
                ", children=" + children +
                ", parent=" + parent +
                '}';
    }
}
