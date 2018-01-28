package cn.gcu.design.btss.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/23 23:41
 */
@Entity
@Table(name = "tb_menu")
public class Menu implements Serializable {
    @Id
    @Column(name = "menu_id",length = 3)
    private String id;
    @Column(name = "menu_name",length = 50)
    private String name;
    @Column(name = "menu_type",length = 20)
    private String type;
    @Column(name = "menu_url",length = 2048)
    private String url;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_top")
    private Menu top;

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", top='" + top + '\'' +
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Menu getTop() {
        return top;
    }

    public void setTop(Menu top) {
        this.top = top;
    }
}
