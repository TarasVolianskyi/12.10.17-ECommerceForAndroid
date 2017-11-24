package com.volianskyi.taras.a121017_ecommerceforandroid.pojo;

/**
 * Created by tarasvolianskyi on 14.10.17.
 */

public class Item {

    private String name;
    private String price;
    private String prevoiusPrice;

    private int imageDRW;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrevoiusPrice() {
        return prevoiusPrice;
    }

    public void setPrevoiusPrice(String prevoiusPrice) {
        this.prevoiusPrice = prevoiusPrice;
    }

    public int getImageDRW() {
        return imageDRW;
    }

    public void setImageDRW(int imageDRW) {
        this.imageDRW = imageDRW;
    }
}
