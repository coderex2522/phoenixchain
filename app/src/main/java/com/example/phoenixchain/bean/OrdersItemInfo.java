package com.example.phoenixchain.bean;

/**
 * Created by coderex2522 on 6/20/2017.
 */

public class OrdersItemInfo {
    private String storeName;
    private String description;
    private Double price;
    private int commodityImgResId;
    private int state;

    public OrdersItemInfo(String storeName, String description, Double price, int commodityImgResId, int state) {
        this.storeName = storeName;
        this.description = description;
        this.price = price;
        this.commodityImgResId = commodityImgResId;
        this.state = state;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCommodityImgResId() {
        return commodityImgResId;
    }

    public void setCommodityImgResId(int commodityImgResId) {
        this.commodityImgResId = commodityImgResId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
