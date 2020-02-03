package com.example.grocerystore.Models;

public class FoodItem {
    private String name;
    private double price;
    private int stockTime;
    private int amount;
    private int maximumStock;

    public FoodItem (){
        //args
    }

    public FoodItem(String name, double price, int stockTime, int amoun, int maximumStock) {
        this.name = name;
        this.price = price;
        this.stockTime = stockTime;
        this.amount = amount;
        this.maximumStock = maximumStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockTime() {
        return stockTime;
    }

    public void setStockTime(int stockTime) {
        this.stockTime = stockTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMaximumStock() {
        return maximumStock;
    }

    public void setMaximumStock(int maximumStock) {
        this.maximumStock = maximumStock;
    }
}
