package com.example.grocerystore.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

//This class is used to initialize a day in the store - add emplyees
//Stock and money to be manipulated in the main Activity
public class Store implements Parcelable {
    private int storeDay;
    private int cash;
    private int dayHours;
    private int fullTimePay;
    private int partTimePay;
    private int shift;
    private int shpCost;
    private int expShpCost;
    private float regUT;


    private ArrayList <String> departments;
    private ArrayList<Employee> employees;
    private ArrayList<FoodItem> foodItems;

    public Store(Store other) {
        this.storeDay = other.storeDay;
        this.cash = other.cash;
        this.dayHours = other.dayHours;
        this.fullTimePay = other.fullTimePay;
        this.partTimePay = other.partTimePay;
        this.shift = other.shift;
        this.shpCost = other.shpCost;
        this.expShpCost = other.expShpCost;
        this.departments = other.departments;
        this.employees = other.employees;
        this.foodItems = other.foodItems;
        this.regUT = other.regUT;
    }

    public Store(int storeDay, int cash, int dayHours, int fullTimePay, int partTimePay, int shift, int shpCost, int expShpCost, ArrayList<String> departments, ArrayList<Employee> employees, ArrayList<FoodItem> foodItems, float regUT) {
        this.storeDay = storeDay;
        this.cash = cash;
        this.dayHours = dayHours;
        this.fullTimePay = fullTimePay;
        this.partTimePay = partTimePay;
        this.shift = shift;
        this.shpCost = shpCost;
        this.expShpCost = expShpCost;
        this.departments = departments;
        this.employees = employees;
        this.foodItems = foodItems;
        this.regUT = regUT;
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

    public int getShpCost() {
        return shpCost;
    }

    public void setShpCost(int shpCost) {
        this.shpCost = shpCost;
    }

    public int getExpShpCost() {
        return expShpCost;
    }

    public void setExpShpCost(int expShpCost) {
        this.expShpCost = expShpCost;
    }

    public int getFOHStock()
    {
        int FOHTotal;
        FOHTotal =0;

        for (FoodItem v: foodItems) {
            FOHTotal += v.getStockFOH();
        }

        return FOHTotal;

    }

    public int getBOHStock()
    {
        int BOHTotal;
        BOHTotal =0;

        for (FoodItem v: foodItems) {
            BOHTotal += v.getStockBOH();
        }

        return BOHTotal;
    }

    public int getEmployeesRegisters()
    {
        int reg = 0;
        for(Employee v: employees)
            if (v.getDepartment() == 5)
                reg++;

            return reg;

    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.storeDay);
        dest.writeInt(this.cash);
        dest.writeInt(this.dayHours);
        dest.writeInt(this.fullTimePay);
        dest.writeInt(this.partTimePay);
        dest.writeInt(this.shift);
        dest.writeInt(this.shpCost);
        dest.writeInt(this.expShpCost);
        dest.writeStringList(this.departments);
        dest.writeList(this.employees);
        dest.writeList(this.foodItems);
    }

    protected Store(Parcel in) {
        this.storeDay = in.readInt();
        this.cash = in.readInt();
        this.dayHours = in.readInt();
        this.fullTimePay = in.readInt();
        this.partTimePay = in.readInt();
        this.shift = in.readInt();
        this.shpCost = in.readInt();
        this.expShpCost = in.readInt();
        this.departments = in.createStringArrayList();
        this.employees = new ArrayList<Employee>();
        in.readList(this.employees, Employee.class.getClassLoader());
        this.foodItems = new ArrayList<FoodItem>();
        in.readList(this.foodItems, FoodItem.class.getClassLoader());
        this.regUT = in.readFloat();
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel source) {
            return new Store(source);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };

    public float getRegUT() {
        return regUT;
    }

    public void setRegUT(float regUT) {
        this.regUT = regUT;
    }
}
