package com.example.grocerystore.HelperClasses;

import android.widget.Toast;

import com.example.grocerystore.Models.FoodItem;
import com.example.grocerystore.Models.Store;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Random;

public class Register {
   // private static HashSet BaseQueue;

    //Our registers will take things off the shelves at
    //(product in queue) * ( rand(0.0f, 1.0f) aka DequeueQuantity ) / RegisterRate


    static Queue<FoodItem> BaseQueue;
    // Each ArrayList represents a customer
    static Queue<ArrayList> Reg1Queue;
    static Queue<ArrayList> Reg2Queue;
    static Queue<ArrayList> Reg3Queue;
    static Store newDay;

    static int total_food_sold_per_hour;
    static float total_money_made_per_hour;
    static int RegisterRate;
    static int itemsAtCheckout;
    int register1;
    int register2;
    int register3;

    float DequeueQuantity;

    int PercentageOfItemsTakenFromQueue;
    static int checkoutsPossible = 0;
    static int checkoutsPerformed = 0;
    public static float registerUtilization;

    static ArrayList<FoodItem> foods;
    static ArrayList<FoodItem> reducedFoods;
    static ArrayList<FoodItem> checkoutFoods;

    static int tot;
    static int tot2;

    public static Store pullItemsOffShelves(Store day)
    {

        tot = 0;
        newDay = new Store(day);

        foods = new ArrayList<>(newDay.getFoodItems());
        checkoutFoods = new ArrayList<>();
        reducedFoods = new ArrayList<>();

        float priceCustomer = 5.00f, priceFarmer= 0.50f, totalPrice = 5;
        checkoutFoods.add(new FoodItem(1, "Cheese", totalPrice, priceCustomer, priceFarmer, 100,100, 0,0, 0));
        checkoutFoods.add(new FoodItem(1, "Milk" , totalPrice, priceCustomer, priceFarmer, 100,100,0,0, 0));
        checkoutFoods.add(new FoodItem(2, "Cereal", totalPrice, priceCustomer, priceFarmer, 100,100, 0,0, 0));
        checkoutFoods.add(new FoodItem(2, "Cookies", totalPrice, priceCustomer, priceFarmer, 100,100, 0,0, 0));
        checkoutFoods.add(new FoodItem(3, "Pizza", totalPrice, priceCustomer, priceFarmer, 100,100, 0,0, 0));
        checkoutFoods.add(new FoodItem(3, "Dessert", totalPrice, priceCustomer, priceFarmer, 100,100, 0,0, 0));
        checkoutFoods.add(new FoodItem(4, "Apples", totalPrice, priceCustomer, priceFarmer, 100,100, 0,0, 0));
        checkoutFoods.add(new FoodItem(4, "Bananas", totalPrice, priceCustomer, priceFarmer, 100,100, 0,0, 0));

        reducedFoods.add(new FoodItem(1, "Cheese", totalPrice, priceCustomer, priceFarmer, 100,100, 0,0, 0));
        reducedFoods.add(new FoodItem(1, "Milk" , totalPrice, priceCustomer, priceFarmer, 100,100,0,0, 0));
        reducedFoods.add(new FoodItem(2, "Cereal", totalPrice, priceCustomer, priceFarmer, 100,100, 0,0, 0));
        reducedFoods.add(new FoodItem(2, "Cookies", totalPrice, priceCustomer, priceFarmer, 100,100, 0,0, 0));
        reducedFoods.add(new FoodItem(3, "Pizza", totalPrice, priceCustomer, priceFarmer, 100,100, 0,0, 0));
        reducedFoods.add(new FoodItem(3, "Dessert", totalPrice, priceCustomer, priceFarmer, 100,100, 0,0, 0));
        reducedFoods.add(new FoodItem(4, "Apples", totalPrice, priceCustomer, priceFarmer, 100,100, 0,0, 0));
        reducedFoods.add(new FoodItem(4, "Bananas", totalPrice, priceCustomer, priceFarmer, 100,100, 0,0, 0));

        if (day.getEmployeesRegisters() == 0)
            return day;

        int afterjBO2H = newDay.getBOHStock();
        int afteprFO2H = newDay.getFOHStock();

for (int i = 0 ; i < 3; i++) {
    int b = 0;
        for (FoodItem f : foods) {
        Random r = new Random();
        int x = r.nextInt(3)+1;

        reducedFoods.get(b).setStockBOH(f.getStockBOH());
        reducedFoods.get(b).setStockTotal(f.getStockTotal());

        if (((f.getStockFOH() - x) < 0) && (f.getStockFOH() != 0)) {
            int foh = f.getStockFOH();
            tot += foh;

            checkoutFoods.get(b).setStockFOH(checkoutFoods.get(b).getStockFOH()+foh);
            checkoutFoods.get(b).setStockTotal(checkoutFoods.get(b).getStockTotal()+foh);


            reducedFoods.get(b).setStockFOH(0);
            reducedFoods.get(b).setStockTotal(foods.get(b).getStockTotal()-foh);
            f.setStockTotal(f.getStockTotal() - f.getStockFOH());
            f.setStockFOH(f.getStockFOH()-f.getStockFOH());


        }


        if ((f.getStockFOH() - x) > 0) {
            tot += x;


            checkoutFoods.get(b).setStockFOH(checkoutFoods.get(b).getStockFOH()+x);
            checkoutFoods.get(b).setStockTotal(checkoutFoods.get(b).getStockTotal()+x);

            reducedFoods.get(b).setStockFOH(f.getStockFOH()-x);
            reducedFoods.get(b).setStockTotal(f.getStockTotal()-x);

            f.setStockTotal(f.getStockTotal() - x);
            f.setStockFOH(f.getStockFOH() - x);
            tot += x;
        }

        newDay.setFoodItems(reducedFoods);

b++;
    }


}
        newDay.setFoodItems(reducedFoods);
        //update the day with reduced foods

        int afterBO2H = newDay.getBOHStock();
        int afterFO2H = newDay.getFOHStock();

        tot2 = tot;

        bringFoodToRegisters();//array list made
       // distributeBaseQueue(newDay.getEmployeesRegisters());
       int afterBOH = newDay.getBOHStock();
        int afterFOH = newDay.getFOHStock();
        //checkoutFoods();
        returnFoods();

        int afterBeOH = newDay.getBOHStock();
        int afterFeOH = newDay.getFOHStock();
        newDay.setFoodItems(reducedFoods);

        int af9terBeOH = newDay.getBOHStock();
        int aft9erFeOH = newDay.getFOHStock();
        return newDay;
    }

    public static void bringFoodToRegisters()

    {
        int cash = newDay.getCash();
        int regs = newDay.getEmployeesRegisters();
        int rate = 0;
        Random r = new Random();
        int x = r.nextInt(3)+1;

        if (regs == 1) {
            rate = r.nextInt(11)+20;
        }
        if (regs == 2) {
            rate = r.nextInt(11)+40;
        }
        if (regs == 3) {
            rate = r.nextInt(11)+80;
        }
        int ratePrev = rate;
        while (rate > 0) {
            for (FoodItem f : checkoutFoods) {
                if ((f.getStockFOH() > 0)&& (rate >0)) {
                    f.setStockFOH(f.getStockFOH() - 1);
                    f.setStockTotal(f.getStockTotal() - 1);
                    float cost = f.getUnitPriceCustomer();
                    cash += (int)cost;
                    rate--;
                    tot--;
                }
            }
                if (ratePrev == rate)
                    break;

                ratePrev = rate;
        }

        newDay.setCash(cash);


        newDay.setRegUT(newDay.getRegUT() + (tot2 - tot)); // this will display the total items sold per shift set a variable between shifts
        newDay.setShift( newDay.getShift()+tot);// divide by 4 for avg items left at register per shift
    }

    public static void returnFoods() {
        int b = 0, returned = 0;
        for (FoodItem f : checkoutFoods) {
            reducedFoods.get(b).setStockFOH(reducedFoods.get(b).getStockFOH() + checkoutFoods.get(b).getStockFOH());
            reducedFoods.get(b).setStockTotal(reducedFoods.get(b).getStockTotal() + checkoutFoods.get(b).getStockTotal());

            returned += checkoutFoods.get(b).getStockFOH();
            b++;
        }

        //  loop through foods, add foods from checkout


    }
    }

    // Base queue is a queue of foods, distribute collections of foods as 'customers' to
    // the three registers
    // called from PullItemsOfShelves() in Simulation


    // gets called every hour to push foods through the open registers
    // number of foods processed = number of register * rate
    //we need a variable register rate...
    //the rate can be a random number calculated at checkout time
   // public void CalculateItemsToBeTakenFromQueue()
    //{
    //    DequeueQuantity = UnityEngine.Random.Range(0.0f, 1.0f);

   // }

