package com.volianskyi.taras.a121017_ecommerceforandroid.pojo;

/**
 * Created by tarasvolianskyi on 18.12.17.
 */

public class OneOrderPojo {

    private int idInsideOfOrder;
    private int orderIdOrder;
    private int productIdOrder;
    private String productNameOrder;
    private int productQuantityOrder;
    private int priceOfProdOrder;

    public OneOrderPojo(){}

    public OneOrderPojo(int idInsideOfOrder, int orderIdOrder, int productIdOrder, String productNameOrder, int productQuantityOrder, int priceOfProdOrder) {
        this.idInsideOfOrder = idInsideOfOrder;
        this.orderIdOrder = orderIdOrder;
        this.productIdOrder = productIdOrder;
        this.productNameOrder = productNameOrder;
        this.productQuantityOrder = productQuantityOrder;
        this.priceOfProdOrder = priceOfProdOrder;
    }

    public int getIdInsideOfOrder() {
        return idInsideOfOrder;
    }

    public void setIdInsideOfOrder(int idInsideOfOrder) {
        this.idInsideOfOrder = idInsideOfOrder;
    }

    public int getOrderIdOrder() {
        return orderIdOrder;
    }

    public void setOrderIdOrder(int orderIdOrder) {
        this.orderIdOrder = orderIdOrder;
    }

    public int getProductIdOrder() {
        return productIdOrder;
    }

    public void setProductIdOrder(int productIdOrder) {
        this.productIdOrder = productIdOrder;
    }

    public String getProductNameOrder() {
        return productNameOrder;
    }

    public void setProductNameOrder(String productNameOrder) {
        this.productNameOrder = productNameOrder;
    }

    public int getProductQuantityOrder() {
        return productQuantityOrder;
    }

    public void setProductQuantityOrder(int productQuantityOrder) {
        this.productQuantityOrder = productQuantityOrder;
    }

    public int getPriceOfProdOrder() {
        return priceOfProdOrder;
    }

    public void setPriceOfProdOrder(int priceOfProdOrder) {
        this.priceOfProdOrder = priceOfProdOrder;
    }
}
