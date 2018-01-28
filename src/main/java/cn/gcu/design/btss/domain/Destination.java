package cn.gcu.design.btss.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/23 22:18
 */
@Entity
@Table(name = "tb_destination")
public class Destination implements Serializable {
    @Id
    @Column(name = "destination_id",length = 5)
    private String id;
    @Column(name = "destination_name",length = 255)
    private String name;
    @Column(name = "destination_level",length = 1)
    private String level;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination_top",
            insertable = false,
            updatable = false)
    private Destination top;

    @Override
    public String toString() {
        return "Destination{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Destination getTop() {
        return top;
    }

    public void setTop(Destination top) {
        this.top = top;
    }
}
