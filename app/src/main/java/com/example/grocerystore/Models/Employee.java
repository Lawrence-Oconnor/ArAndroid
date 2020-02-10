package com.example.grocerystore.Models;

public class Employee {
    private String name;
    private int employeeNumber;
    private boolean idle;
    private double stockTime;
    private string department;

    public Employee(){
    //args
    }
    public Employee(String name, int employeeNumber, Boolean idle, double stockTime, int department ){

        this.name = name;
        this.employeeNumber = employeeNumber;
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

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}
