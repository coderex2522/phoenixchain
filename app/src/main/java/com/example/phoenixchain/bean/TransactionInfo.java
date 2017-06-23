package com.example.phoenixchain.bean;

import java.util.Date;

/**
 * Created by Sanji on 2017/6/20.
 */

public class TransactionInfo {
    private Date date;
    private int sum;
    private String toWhom;
    private String type;

    public TransactionInfo(Date date, int sum, String toWhom, String type) {
        this.date = date;
        this.sum = sum;
        this.toWhom = toWhom;
        this.type = type;
    }



    public Date getData() {

        return date;
    }

    public void setData(Date date) {

        this.date = date;
    }

    public int getSum() {

        return sum;
    }

    public void setSum(int sum) {

        this.sum = sum;
    }

    public String getToWhom() {

        return toWhom;
    }

    public void setToWhom(String toWhom) {

        this.toWhom = toWhom;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }
}
