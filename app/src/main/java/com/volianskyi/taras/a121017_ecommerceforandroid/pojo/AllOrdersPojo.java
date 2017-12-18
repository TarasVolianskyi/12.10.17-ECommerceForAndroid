package com.volianskyi.taras.a121017_ecommerceforandroid.pojo;

/**
 * Created by tarasvolianskyi on 18.12.17.
 */

public class AllOrdersPojo {

    private int ordersIdOrders;
    private String userNameOrders;
    private int totalAmountOfOneOrderOrders;

    public AllOrdersPojo(){}

    public AllOrdersPojo(int ordersIdOrders, String userNameOrders, int totalAmountOfOneOrderOrders) {
        this.ordersIdOrders = ordersIdOrders;
        this.userNameOrders = userNameOrders;
        this.totalAmountOfOneOrderOrders = totalAmountOfOneOrderOrders;
    }

    public int getOrdersIdOrders() {
        return ordersIdOrders;
    }

    public void setOrdersIdOrders(int ordersIdOrders) {
        this.ordersIdOrders = ordersIdOrders;
    }

    public String getUserNameOrders() {
        return userNameOrders;
    }

    public void setUserNameOrders(String userNameOrders) {
        this.userNameOrders = userNameOrders;
    }

    public int getTotalAmountOfOneOrderOrders() {
        return totalAmountOfOneOrderOrders;
    }

    public void setTotalAmountOfOneOrderOrders(int totalAmountOfOneOrderOrders) {
        this.totalAmountOfOneOrderOrders = totalAmountOfOneOrderOrders;
    }
}
