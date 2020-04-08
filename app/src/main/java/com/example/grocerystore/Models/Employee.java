package com.example.grocerystore.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable {
    private String name;
    private int employeeNumber;

    private double stockTime;
    private int department;
    private boolean offSite;
    private boolean fulltime;
    private boolean idle;

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.employeeNumber);
        dest.writeDouble(this.stockTime);
        dest.writeInt(this.department);
        dest.writeByte(this.offSite ? (byte) 1 : (byte) 0);
        dest.writeByte(this.fulltime ? (byte) 1 : (byte) 0);
        dest.writeByte(this.idle ? (byte) 1 : (byte) 0);
    }

    protected Employee(Parcel in) {
        this.name = in.readString();
        this.employeeNumber = in.readInt();
        this.stockTime = in.readDouble();
        this.department = in.readInt();
        this.offSite = in.readByte() != 0;
        this.fulltime = in.readByte() != 0;
        this.idle = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Employee> CREATOR = new Parcelable.Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel source) {
            return new Employee(source);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };
}