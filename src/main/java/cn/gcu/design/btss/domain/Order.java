package cn.gcu.design.btss.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/23 23:31
 */
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Id
    @Column(name = "order_id",length = 50)
    private String id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_user_id")
    private User user;
    @Column(name = "order_trx_id",length = 50)
    private String trxId;
    @Column(name = "order_down_time")
    private Date downTime;
    @Column(name = "order_pay_time")
    private Date payTime;
    @Column(name = "order_cancel_time")
    private Date cancelTime;
    @Column(name = "order_state",length = 1)
    private String state;
    @Column(name = "order_total")
    private Double total;

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", trxId='" + trxId + '\'' +
                ", downTime=" + downTime +
                ", payTime=" + payTime +
                ", cancelTime=" + cancelTime +
                ", state=" + state +
                ", total=" + total +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
