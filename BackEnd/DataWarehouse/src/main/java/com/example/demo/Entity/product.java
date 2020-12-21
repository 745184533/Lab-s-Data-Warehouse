package com.example.demo.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class product {
    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY) //配置主键的生成策略
    @Column(name="productID") //指定和表中cust_id字段的映射关系
    private String productID;

    @Column(name="movieID")
    private Integer movieID;

    @Column(name="timeID")
    private Integer timeID;

    @Column(name="type")
    private String type;

    @Column(name="format")
    private String format;

    @Column(name="price")
    private float price;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public Integer getTimeID() {
        return timeID;
    }

    public void setTimeID(Integer timeID) {
        this.timeID = timeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
