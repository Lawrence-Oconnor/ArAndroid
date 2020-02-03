package com.example.grocerystore.Models;

public class Employee {
    private String name;
    private String employeeNumber;
    private boolean idle;
    private double stockTime;
    private int department;

    public Employee(){
    //args
    }
    public Employee(String name, String employerNumber, Boolean idle, double stockTime, int department ){

        this.name = name;
        this.employeeNumber = employerNumber;
        this.idle = idle;
        this.stockTime = stockTime;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIdle() {
        return idle;
    }

    public void setIdle(boolean idle) {
        this.idle = idle;
    }

    public double getStockTime() {
        return stockTime;
    }

    public void setStockTime(double stockTime) {
        this.stockTime = stockTime;
    }

    public int getTemp() {
        return department;
    }

    public void setTemp(int temp) {
        this.department = temp;
    }
}
