package com.example.grocerystore.Models;

public class Employee {
    private String name;
    private int employeeNumber;
    private boolean idle;
    private double stockTime;
    private int department;
    private boolean offSite;
    private boolean fulltime;


    public Employee(String name, int employeeNumber, boolean idle, double stockTime, int department, boolean offSite, boolean fulltime) {
        this.name = name;
        this.employeeNumber = employeeNumber;
        this.idle = idle;
        this.stockTime = stockTime;
        this.department = department;
        this.offSite = offSite;
        this.fulltime = fulltime;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
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

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public boolean isOffSite() {
        return offSite;
    }

    public void setOffSite(boolean offSite) {
        this.offSite = offSite;
    }

    public boolean isFulltime() {
        return fulltime;
    }

    public void setFulltime(boolean fulltime) {
        this.fulltime = fulltime;
    }
}