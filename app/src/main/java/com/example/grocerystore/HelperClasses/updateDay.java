package com.example.grocerystore.HelperClasses;

import android.widget.Toast;

import com.example.grocerystore.Models.Employee;
import com.example.grocerystore.Models.FoodItem;
import com.example.grocerystore.Models.Store;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class updateDay {

    //use this class to update the current Day
    //pass a day object and return it with the modifications
    //Expiration method
    //End day
    //any other manipulations to a day


    public static Store expireInventory(Store store) {

        ArrayList<FoodItem> foodItems = store.getFoodItems();
        ArrayList<FoodItem> newFoodItems = new ArrayList<>();

        for (FoodItem temp : foodItems) {
            int bohStock, fohStock, totalStock;

            Random r = new Random();
            float percentGoneBad = .05f + r.nextFloat() * (.10f - .05f);
            float percentGoneBadFOH = .20f + r.nextFloat() * (.25f - .20f);
            int expired = (int) (temp.getStockBOH() * percentGoneBad);
            int expiredFOH = (int) (temp.getStockFOH() * percentGoneBadFOH);

            bohStock = temp.getStockBOH();
            bohStock -= expired;
            fohStock = temp.getStockFOH();
            fohStock -= expiredFOH;
            temp.setStockBOH(bohStock);
            temp.setStockFOH(fohStock);
            totalStock = temp.getStockTotal();
            totalStock -= expired;
            totalStock -= expiredFOH;
            temp.setStockTotal(totalStock);
            newFoodItems.add(temp);

        }
        store.setFoodItems(newFoodItems);
        return store;
    }


    public static int payEmployees(Store store) {

        int fullTime = store.getFullTimePay();
        int partTime = store.getPartTimePay();
        int pay = store.getCash();

        int fte = 0, pte = 0;

        ArrayList<Employee> employees = store.getEmployees();

        for (Employee temp : employees) {
            if (temp.isFulltime())
                fte++;
            else
                pte++;
        }

        pay = ((fullTime * fte) + (partTime * pte));


        return pay;
    }

    public static Store restock(Store day, float[] shift) {
        ArrayList<FoodItem> foods;
        ArrayList<Employee> employees;
        int dept = 0;
        foods = day.getFoodItems();
        for (FoodItem f : foods) {

            dept = f.getDepartment();
            if (shift[dept] < 1)
                continue;

            if (f.getStockFOH() < f.getMaxFOH())
                if (f.getStockBOH() > 0) {
                    int rs = f.getMaxFOH() - f.getStockFOH();
                    //the amount we need to fill FOH

                    if (f.getStockBOH() < rs) {
                        f.setStockFOH(f.getStockFOH() + f.getStockBOH());
                        f.setStockBOH(0);
                    }

                    if (f.getStockBOH() >= rs) {
                        f.setStockFOH(f.getStockFOH() + rs);
                        f.setStockBOH(f.getStockBOH() - rs);
                    }

                }

        }
        day.setFoodItems(foods);

        return day;
    }


    public static Store makeDeliveries(Store day, float[] quantities, float[] shipping) {
        //loop through quants array - if not equal to zero
        int cash = day.getCash();
        ArrayList<FoodItem> foods;
        foods = day.getFoodItems();
        int diff = 0;
        for (int i = 0; i < 8; i++) {
            diff = 0;
            if (quantities[i] == 0)
                continue;
            cash -= (quantities[i] * 25);
            cash -= (shipping[i] == 1.0 ? 250 : 100);
            if (((foods.get(i).getStockBOH()) + (quantities[i] * 25)) > foods.get(i).getMaxBOH()) {
                diff = foods.get(i).getMaxBOH() - foods.get(i).getStockBOH();
                foods.get(i).setStockBOH(foods.get(i).getMaxBOH());
            }

            if (((foods.get(i).getStockBOH()) + (quantities[i] * 25)) <= foods.get(i).getMaxBOH()) {
                diff = foods.get(i).getStockBOH() + (int) (quantities[i] * 25);
                foods.get(i).setStockBOH(diff);
            }


        }
        day.setCash(cash);
        day.setShpCost(diff);
        return day;
    }

}
