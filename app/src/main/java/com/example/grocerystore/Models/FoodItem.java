package com.example.grocerystore.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodItem implements Parcelable {


    private int department;
    private String itemName;
    private float unitPriceCustomer;
    private float unitPriceFarmer;
    private float totalPrice;
    private int maxFOH;
    private int maxBOH;
    private int stockFOH;
    private int stockBOH;
    private int stockTotal;

    public FoodItem(int department, String itemName, float unitPriceCustomer, float unitPriceFarmer, float totalPrice,
                    int maxFOH, int maxBOH, int stockFOH, int stockBOH, int stockTotal) {
        this.department = department;
        this.itemName = itemName;
        this.unitPriceCustomer = unitPriceCustomer;
        this.unitPriceFarmer = unitPriceFarmer;
        this.totalPrice = totalPrice;
        this.maxFOH = maxFOH;
        this.maxBOH = maxBOH;
        this.stockFOH = stockFOH;
        this.stockBOH = stockBOH;
        this.stockTotal = stockTotal;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getUnitPriceCustomer() {
        return unitPriceCustomer;
    }

    public void setUnitPriceCustomer(float unitPriceCustomer) {
        this.unitPriceCustomer = unitPriceCustomer;
    }

    public float getUnitPriceFarmer() {
        return unitPriceFarmer;
    }

    public void setUnitPriceFarmer(float unitPriceFarmer) {
        this.unitPriceFarmer = unitPriceFarmer;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getMaxFOH() {
        return maxFOH;
    }

    public void setMaxFOH(int maxFOH) {
        this.maxFOH = maxFOH;
    }

    public int getMaxBOH() {
        return maxBOH;
    }

    public void setMaxBOH(int maxBOH) {
        this.maxBOH = maxBOH;
    }

    public int getStockFOH() {
        return stockFOH;
    }

    public void setStockFOH(int stockFOH) {
        this.stockFOH = stockFOH;
    }

    public int getStockBOH() {
        return stockBOH;
    }

    public void setStockBOH(int stockBOH) {
        this.stockBOH = stockBOH;
    }

    public int getStockTotal() {
        return stockTotal;
    }

    public void setStockTotal(int stockTotal) {
        this.stockTotal = stockTotal;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.department);
        dest.writeString(this.itemName);
        dest.writeFloat(this.unitPriceCustomer);
        dest.writeFloat(this.unitPriceFarmer);
        dest.writeFloat(this.totalPrice);
        dest.writeInt(this.maxFOH);
        dest.writeInt(this.maxBOH);
        dest.writeInt(this.stockFOH);
        dest.writeInt(this.stockBOH);
        dest.writeInt(this.stockTotal);
    }

    protected FoodItem(Parcel in) {
        this.department = in.readInt();
        this.itemName = in.readString();
        this.unitPriceCustomer = in.readFloat();
        this.unitPriceFarmer = in.readFloat();
        this.totalPrice = in.readFloat();
        this.maxFOH = in.readInt();
        this.maxBOH = in.readInt();
        this.stockFOH = in.readInt();
        this.stockBOH = in.readInt();
        this.stockTotal = in.readInt();
    }

    public static final Parcelable.Creator<FoodItem> CREATOR = new Parcelable.Creator<FoodItem>() {
        @Override
        public FoodItem createFromParcel(Parcel source) {
            return new FoodItem(source);
        }

        @Override
        public FoodItem[] newArray(int size) {
            return new FoodItem[size];
        }
    };
}