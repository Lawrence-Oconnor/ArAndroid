package com.example.grocerystore.Models;

import java.util.ArrayList;

//This class is used to initialize a day in the store - add emplyees
//Stock and money to be manipulated in the main Activity
public class Store {
    private int storeDay;
    private int cash;
    private int dayHours;
    private int fullTimePay;
    private int partTimePay;
    private int shift;

    private ArrayList <String> departments;
    private ArrayList<Employee> employees;
    private ArrayList<FoodItem> foodItems;

    public Store(int storeDay, int shift, int cash, int dayHours, int fullTimePay, int partTimePay,
                 ArrayList<String> departments, ArrayList<Employee> employees, ArrayList<FoodItem> foodItems) {

        this.storeDay = storeDay;
        this.cash = cash;
        this.dayHours = dayHours;
        this.fullTimePay = fullTimePay;
        this.partTimePay = partTimePay;
        this.departments = departments;
        this.employees = employees;
        this.foodItems = foodItems;
        this.shift = shift;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public int getStoreDay() {
        return storeDay;
    }

    public void setStoreDay(int storeDay) {
        this.storeDay = storeDay;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getDayHours() {
        return dayHours;
    }

    public void setDayHours(int dayHours) {
        this.dayHours = dayHours;
    }

    public int getFullTimePay() {
        return fullTimePay;
    }

    public void setFullTimePay(int fullTimePay) {
        this.fullTimePay = fullTimePay;
    }

    public int getPartTimePay() {
        return partTimePay;
    }

    public void setPartTimePay(int partTimePay) {
        this.partTimePay = partTimePay;
    }

    public ArrayList<String> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<String> departments) {
        this.departments = departments;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(ArrayList<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
