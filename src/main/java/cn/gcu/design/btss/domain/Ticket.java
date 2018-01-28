package cn.gcu.design.btss.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/23 23:20
 */
@Entity
@Table(name = "tb_ticket")
public class Ticket implements Serializable{
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_car_id")
    private Car car;
    @Column(name = "ticket_num",length = 2)
    private Integer num;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_traveller_id")
    private Traveller traveller;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_order_id")
    private Order order;
    @Column(name = "ticket_type",length = 1)
    private String type;
    @Column(name = "ticket_price")
    private Double price;

    @Override
    public String toString() {
        return "Ticket{" +
                "car=" + car +
                ", num=" + num +
                ", traveller=" + traveller +
                ", order=" + order +
                ", type=" + type +
                ", price=" + price +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
