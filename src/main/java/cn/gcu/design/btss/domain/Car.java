package cn.gcu.design.btss.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/23 23:13
 */
@Entity
@Table(name = "tb_car")
public class Car implements Serializable {
    @Id
    @Column(name = "car_id",length = 32)
    private String id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_source")
    private Destination source;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_destination")
    private Destination destination;
    @Column(name = "car_time")
    private Date time;
    @Column(name = "car_max",length = 2)
    private Integer max;
    @Column(name = "car_length",length = 5)
    private Integer length;
    @Column(name = "car_price")
    private Double price;

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", source=" + source +
                ", destination=" + destination +
                ", time=" + time +
                ", max=" + max +
                ", length=" + length +
                ", price=" + price +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Destination getSource() {
        return source;
    }

    public void setSource(Destination source) {
        this.source = source;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
