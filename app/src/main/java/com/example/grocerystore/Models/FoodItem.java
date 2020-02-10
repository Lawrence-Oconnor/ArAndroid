package com.example.grocerystore.Models;

public class FoodItem {


    private String department;
    private String departmentCode;
    private String itemDescription;
    private String itemCode;
    private String SKU;
    int totalInitialQuantity;
    private float unitPriceCustomer;
    private float unitPriceFarmer;
    private float totalPrice;

    public FoodItem(String department, String departmentCode, String itemDescription, String itemCode, String SKU, int totalInitialQuantity, float unitPriceCustomer, float unitPriceFarmer, float totalPrice) {
        this.department = department;
        this.departmentCode = departmentCode;
        this.itemDescription = itemDescription;
        this.itemCode = itemCode;
        this.SKU = SKU;
        this.totalInitialQuantity = totalInitialQuantity;
        this.unitPriceCustomer = unitPriceCustomer;
        this.unitPriceFarmer = unitPriceFarmer;
        this.totalPrice = totalPrice;
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

    public int getTotalInitialQuantity() {
        return totalInitialQuantity;
    }

    public void setTotalInitialQuantity(int totalInitialQuantity) {
        this.totalInitialQuantity = totalInitialQuantity;
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
}