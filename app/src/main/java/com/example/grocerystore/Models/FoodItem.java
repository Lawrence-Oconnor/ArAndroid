package com.example.grocerystore.Models;

public class FoodItem {


    private String department;
    private String departmentCode;
    private String itemDescription;
    private String itemCode;
    private String SKU;
    private float unitPriceCustomer;
    private float unitPriceFarmer;
    private float totalPrice;
    private int maxFOH;
    private int maxBOH;
    private int stockFOH;
    private int stockBOH;
    private int stockTotal;


    public FoodItem(String department, String departmentCode, String itemDescription, String itemCode, String SKU, float unitPriceCustomer,
                    float unitPriceFarmer, float totalPrice, int maxFOH, int maxBOH, int stockFOH, int stockBOH, int stockTotal) {

        //do we need these
        this.department = department;
        this.departmentCode = departmentCode;

        this.itemDescription = itemDescription;

        //do we need these
        this.itemCode = itemCode;
        this.SKU = SKU;
        this.unitPriceCustomer = unitPriceCustomer;
        this.unitPriceFarmer = unitPriceFarmer;

        this.totalPrice = totalPrice;
        this.maxFOH = maxFOH;
        this.maxBOH = maxBOH;
        this.stockFOH = stockFOH;
        this.stockBOH = stockBOH;
        this.stockTotal = stockTotal;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
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
}