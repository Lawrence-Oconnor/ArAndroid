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


    public static Store expireInventory(Store store){

        ArrayList<FoodItem> foodItems= store.getFoodItems();
        ArrayList<FoodItem> newFoodItems = new ArrayList<>();

    for( FoodItem temp :foodItems)
    {
        int bohStock, fohStock, totalStock;

        Random r = new Random();
        float percentGoneBad = .05f + r.nextFloat() * (.10f - .05f);
        float percentGoneBadFOH = .20f + r.nextFloat() * (.25f - .20f);
        int expired = (int)(temp.getStockBOH() * percentGoneBad);
        int expiredFOH = (int)(temp.getStockFOH() * percentGoneBadFOH);

        bohStock= temp.getStockBOH();
        bohStock -= expired;
        fohStock= temp.getStockFOH();
        fohStock -= expiredFOH;
        temp.setStockBOH(bohStock) ;
        temp.setStockFOH(fohStock) ;
        totalStock = temp.getStockTotal();
        totalStock -= expired;
        totalStock -= expiredFOH;
        temp.setStockTotal(totalStock);
        newFoodItems.add(temp);

    }
    store.setFoodItems(newFoodItems);
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

    public static int payEmployees(Store store){

        int fullTime = store.getFullTimePay();
        int partTime = store.getPartTimePay();
        int pay = store.getCash();

        int fte = 0, pte= 0;

        ArrayList <Employee> employees = store.getEmployees();

        for(Employee temp : employees)
        {
            if (temp.isFulltime())
                fte++;
            else
                pte++;
        }

        pay = ((fullTime * fte)+(partTime*pte));


        return pay;
    }

    public static Store restock(Store store) {


return store;
    }


    public static Store pullItemsOffShelves(Store store){

        return store;
    }

/*
    public static Store RegisterLogic(Store store) {


        int RegisterRate;
        int itemsAtCheckout;
        Queue<FoodItem> queue;

        return store;

    }
        // Start is called before the first frame update

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
