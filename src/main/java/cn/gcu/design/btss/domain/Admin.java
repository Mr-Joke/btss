package cn.gcu.design.btss.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/23 22:08
 */
@Entity
@Table(name = "tb_admin")
public class Admin implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "admin_id")
    private Integer id;
    @Column(name = "admin_uname",length = 30)
    @Length(min = 1,max = 30,message = "用户名长度为1到30之间")
    private String uname;
    @Column(name = "admin_name",length = 20)
    @Length(min = 1,max = 20,message = "姓名长度为1到20之间")
    private String name;
    @Column(name = "admin_password",length = 16)
    @Length(min = 6,max = 16,message = "密码长度为6到16之间")
    private String password;
    @Column(name = "admin_level",length = 3)
    private String level;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", level=" + level +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
