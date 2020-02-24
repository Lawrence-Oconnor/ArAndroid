package com.example.grocerystore.HelperClasses;

import com.example.grocerystore.Models.Employee;
import com.example.grocerystore.Models.FoodItem;
import com.example.grocerystore.Models.Store;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class updateDay {
    /*
    //use this class to update the current Day
    //pass a day object and return it with the modifications



    //Expiration method

    //End day

    //any other manipulations to a day


    public static Store expireInventory(Store store){

        ArrayList<FoodItem> foodItems= store.getFoodItems();

    for( FoodItem temp :foodItems)
    {
        int bohStock, totalStock;
        float percentGoneBad = Random.Range(.05f, .10f);
        int expired = (int)(temp.getStockBOH() * percentGoneBad);
        bohStock= temp.getStockBOH();
        bohStock -= expired;
        temp.setStockBOH(bohStock) ;
        totalStock = temp.getStockTotal();
        totalStock -= expired;
        temp.setStockTotal(totalStock);

    }
        return store;
    }

    //register logic
    public static Store foodToRegister(Store store){
        return store;
    }

    public static Store checkoutFood(Store store){
        return store;
    }

    public static Store returnFoodToShelves(Store store){
        return store;
    }

    public static Store payEmployees(Store store){

        int fullTime = store.getFullTimePay();
        int partTime = store.getPartTimePay();
        int cash = store.getCash();

        int fte = 0, pte= 0;

        ArrayList <Employee> employees = store.getEmployees();

        for(Employee temp : employees)
        {
            if (temp.isFulltime())
                fte++;
            else
                pte++;
        }

        cash -= ((fullTime * fte)+(partTime*pte));
        store.setCash(cash);

        return store;
    }
    public static Store pullItemsOffShelves(Store store){
        return store;
    }


    public static Store RegisterLogic(Store store) {


        int RegisterRate;
        int itemsAtCheckout;
        Queue<FoodItem> queue;

        return store;

    }
        // Start is called before the first frame update
/*
        public void bringFoodToRegisters (FoodItem food)
        {
            queue.Enqueue(food);
            itemsAtCheckout++;
        }


        // gets called every hour to push foods through the open registers
        // number of foods processed = number of register * rate
        public void checkoutFoods ()
        {
            for (int i = 0; i < store.gNumberEmployeesRegister; i++) {
                // only push through a certain rate of foods per hour (i defined it as 8)
                for (int j = 0; j < RegisterRate; j++) {
                    if (queue.Count > 0) {
                        // you can do anything with this food now, maybe display it walking out the store lol
                        Food food = queue.Dequeue();
                        itemsAtCheckout--;
                        // food.cyaBitches();
                    }
                }
            }
        }

        // gets called at the end of the day
        public void returnFoodsToShelves ()
        {
            while (queue.Count > 0) {
                Food food = queue.Dequeue();
                itemsAtCheckout--;
                // add the item back to shelf
                sim.totalOnShelves[food.getItemDescription()] += 1;
            }
        }



    }


*/
}
