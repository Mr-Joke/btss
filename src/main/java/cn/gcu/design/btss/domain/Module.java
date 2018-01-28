package cn.gcu.design.btss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/23 22:29
 */
@Entity
@Table(name = "tb_module")
public class Module implements Serializable {
    @Id
    @Column(name = "module_id",length = 3)
    private String id;
    @Column(name = "module_name",length = 50)
    private String name;
    @Column(name = "module_url",length = 2048)
    private String url;
    @Column(name = "module_level",length = 3)
    private String level;
    @ManyToOne
    @JoinColumn(name = "module_top",
            insertable = false,
            updatable = false)
    private Module top;

    @Override
    public String toString() {
        return "Module{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", level='" + level + '\'' +
                ", top=" + top +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Module getTop() {
        return top;
    }

    public void setTop(Module top) {
        this.top = top;
    }
}
