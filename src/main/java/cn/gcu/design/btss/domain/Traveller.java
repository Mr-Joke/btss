package cn.gcu.design.btss.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/23 22:34
 */
@Entity
@Table(name = "tb_traveller")
public class Traveller implements Serializable {
    @Id
    @Column(name = "traveller_id",length = 18)
    private String id;
    @Column(name = "traveller_name",length = 30)
    private String name;
    @Column(name = "traveller_phone",length = 20)
    private String phone;
    @ManyToMany(mappedBy = "travellers")
    private List<User> users = new ArrayList<>();

    @Override
    public String toString() {
        return "Traveller{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
