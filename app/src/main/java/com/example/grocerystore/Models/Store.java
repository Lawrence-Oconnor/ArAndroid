package com.example.grocerystore.Models;

import java.util.ArrayList;

//This class is used to initialize a day in the store - add emplyees
//Stock and money to be manipulated in the main Activity
public class Store {
    private int storeDay;
    private ArrayList<Employee> employees;
    private ArrayList<FoodItem> foodItems;
    private int balance;


    public Store(int storeDay, ArrayList<Employee> employees, ArrayList<FoodItem> foodItems, int balance) {
        this.storeDay = storeDay;
        this.employees = employees;
        this.foodItems = foodItems;
        this.balance = balance;
    }

    public int getStoreDay() {
        return storeDay;
    }

    public void setStoreDay(int storeDay) {
        this.storeDay = storeDay;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
