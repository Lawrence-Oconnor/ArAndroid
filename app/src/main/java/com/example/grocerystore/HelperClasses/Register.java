package com.example.grocerystore.HelperClasses;

import com.example.grocerystore.Models.FoodItem;
import com.example.grocerystore.Models.Store;

import java.util.ArrayList;
import java.util.Queue;

public class Register {
    /*
    //Our registers will take things off the shelves at
    //(product in queue) * ( rand(0.0f, 1.0f) aka DequeueQuantity ) / RegisterRate


    Queue<FoodItem> BaseQueue;
    // Each ArrayList represents a customer
    Queue<ArrayList> Reg1Queue;
    Queue<ArrayList> Reg2Queue;
    Queue<ArrayList> Reg3Queue;
    Store day;

    int total_food_sold_per_hour;
    float total_money_made_per_hour;
    int RegisterRate;
    int itemsAtCheckout;
    int register1;
    int register2;
    int register3;

    float DequeueQuantity;

    int PercentageOfItemsTakenFromQueue;
    int checkoutsPossible;
    int checkoutsPerformed;
    public float registerUtilization;


    // Start is called before the first frame update
    void Start()
    {
        checkoutsPossible = 0;
        checkoutsPerformed = 0;
    }

    public void bringFoodToRegisters(FoodItem food)
    {
        BaseQueue.add(food);
        itemsAtCheckout++;
        /*
        // Semi-random distribution of items
        int numRegisters = sim.NumberEmployeesRegisters;
        int[] lineLengths = new int[3];
        for (int i = 0; i < sim.NumberEmployeesRegisters; i++)
        {

        }

    }

    // Base queue is a queue of foods, distribute collections of foods as 'customers' to
    // the three registers
    // called from PullItemsOfShelves() in Simulation
    public void distributeBaseQueue(int numRegisters)
    {
        // mimicks Poisson Distrubition
        int[] customerItemCountDistribution = new int{3, 6, 9, 12, 13, 14, 15, 15, 16, 16,
            16, 17, 17, 18, 20, 22, 25, 28, 32};
        // max is exclusive here because we passed in integers (generate int 0-18)
        int distIndex, numItems;

        // store number of items in each register
        int[] registerItemCount = new int[3] { 0, 0, 0};

        // Tally current item count in line 1
        if(!Reg1Queue.isEmpty())
            for (ArrayList al: Reg1Queue)
                registerItemCount[0] += al.size();

        // Tally current item count in line 2
        if (!Reg2Queue.isEmpty())
            for (ArrayList al : Reg2Queue)
                registerItemCount[1] += al.size();

        // Tally current item count in line 3
        if (!Reg3Queue.isEmpty())
            for (ArrayList al: Reg3Queue)
                registerItemCount[2] += al.size();


        // distribute the base queue (contains foods) until empty
        while (!BaseQueue.isEmpty())
        {
            // max is exclusive here because we passed in integers (generate int 0-18)
            distIndex = UnityEngine.Random.Range(0, 19);
            numItems = customerItemCountDistribution[distIndex];

            if (numItems > BaseQueue.size())
                numItems = BaseQueue.size();

            // create 'customer'
            ArrayList customer = new ArrayList();
            //TODO this may be wrong
            for (int i = 0; i < numItems; i++)
                customer.add(BaseQueue.remove());

            // Determines which register to send the customer to
            //TODO get the number of register
            if (sim.NumberEmployeesRegisters == 3)
            {
                // determine register to send it to, follows: ~40% of items going to reg1
                //                                            ~35% of items going to reg2
                //                                            ~25 % of items going to reg3
                if ((registerItemCount[0] / .4) <= (registerItemCount[1] + registerItemCount[2]) / .6) // send to reg1
                {
                    Reg1Queue.add(customer);
                    registerItemCount[0] += customer.size();
                }
                else if (registerItemCount[1] / .35 <= registerItemCount[2] / .25) // send to reg2
                {
                    Reg2Queue.add(customer);
                    registerItemCount[1] += customer.size();
                }
                else // send to reg3
                {
                    Reg3Queue.add(customer);
                    registerItemCount[2] += customer.size();
                }
            }
            else if(sim.NumberEmployeesRegisters == 2)
            {
                // determine register to send it to, follows: ~60% of items going to reg1
                //                                            ~40% of items going to reg2
                if (registerItemCount[0] / .6 <= registerItemCount[1] / .4)
                {
                    Reg1Queue.add(customer);
                    registerItemCount[0] += customer.size();
                }
                else
                {
                    Reg2Queue.add(customer);
                    registerItemCount[1] += customer.size();
                }
            }
            else // only one register to send it to (100% to reg1)
            {
                Reg1Queue.add(customer);
                registerItemCount[0] += customer.size();
            }
        }
    }

    // Called from MakeAction when a register is closed
    // Must distribute customers in the closed register's queue
    public void closeRegister()
    {
        int numRegisters = sim.NumberEmployeesRegisters;

        // if register 2 was closed, put all of register 2's customers in
        // register 1 line
        if (numRegisters == 1)
        {
            int size = Reg2Queue.size();
            for (int i = 0; i < size; i++)
                Reg1Queue.add(Reg2Queue.remove());
        }
        else // distribute register 3 customers to 1 and 2 (50/50 disbursement)
        {
            int flip = 0;

            while (Reg3Queue.size() > 0)
            {
                if (flip == 0)
                    Reg1Queue.add(Reg3Queue.remove());
                else
                    Reg2Queue.add(Reg3Queue.remove());

                flip = (flip == 0) ? 1 : 0;
            }

        }

    }

    // gets called every hour to push foods through the open registers
    // number of foods processed = number of register * rate
    //we need a variable register rate...
    //the rate can be a random number calculated at checkout time
    public void CalculateItemsToBeTakenFromQueue()
    {
        DequeueQuantity = UnityEngine.Random.Range(0.0f, 1.0f);

    }

    public void checkoutFoods(Store day)
    {
        //so for each employee on the register (sim.NumberEmployeesRegisters), I will calculate a new value (Dequeue Quantity) and apply it to the formula
        //Then I'll capture the rate
        total_food_sold_per_hour = 0;
        total_money_made_per_hour = 0;
        //calculateRegisterRate();



        // for each open register
        for (int i = 0; i < sim.NumberEmployeesRegisters; i++)
        {
            Queue<ArrayList> currentRegisterQueue;

            if (i == 0)
            {
                currentRegisterQueue = Reg1Queue;
            }
            else if (i == 1)
            {
                currentRegisterQueue = Reg2Queue;
            }
            else
            {
                currentRegisterQueue = Reg3Queue;
            }



            // if this line is empty, we have no customers to check out
            if (currentRegisterQueue.isEmpty())
                continue;


            // only push through a certain rate of foods per hour (i defined it as 8)
            for (int j = 0; j < RegisterRate; j++)
            {
                checkoutsPossible++;
                ArrayList al = currentRegisterQueue.peek();

                // if this customer is checked out, dequeue it and go to next one
                if (al.isEmpty())
                {
                    currentRegisterQueue.remove();
                    //Debug.Log("Checked out a customer from line " + (i + 1));

                    if (!currentRegisterQueue.isEmpty())
                        al = currentRegisterQueue.peek();
                    else
                        break;
                }


                // REGISTER UTILIZATION: HOW MANY TIMES DO WE REACH HERE / RegisterRate
                checkoutsPerformed++;

                // ArrayLists are weird in c#!! remove methods don't return object removed
                FoodItem food = (FoodItem) al.get(0);
                al.remove(0);
                int cash = day.getCash();
                cash += (float) food.getUnitPriceCustomer();
                day.setCash(cash);

                //keep track of a food item sold
                total_food_sold_per_hour += 1;
                total_money_made_per_hour += ((FoodItem) food).getUnitPriceCustomer();

                itemsAtCheckout--;


                // TODO: make cool animation of foods walking out the door and send me a video of it lmao
                // food.cyaBitches();

            }

            registerUtilization = ((float)checkoutsPerformed) / checkoutsPossible;
        }


        PostDayManager.total_food_sold += total_food_sold_per_hour;


        sim.updateCheckoutItems();
        // print("queue size after = " + queue.Count);
    }

    // gets called at the end of the day, whatever is waiting at the registers gets returned to shelves
    // this is used to simulate people getting angry for waiting too long idk
    // need to have a reason not to have too litte registers open
    public void returnFoodsToShelves()
    {
        // EMPTY EACH QUEUE
        while(!BaseQueue.isEmpty())
        {
            FoodItem food = BaseQueue.remove();
            itemsAtCheckout--;
            // add the item back to shelf
            Simulation.totalOnShelves[food.getItemDescription()] += 1;
        }
        while (!Reg1Queue.isEmpty())
        {
            ArrayList al = Reg1Queue.remove();

            for(FoodItem food: al)
            {
                itemsAtCheckout--;
                // add the item back to shelf
                Simulation.totalOnShelves[foodItem.getItemDescription()] += 1;
            }
        }
        while (!Reg2Queue.isEmpty())
        {
            ArrayList al = Reg2Queue.remove();

            foreach (Food foodItem in al)
            {
                itemsAtCheckout--;
                // add the item back to shelf
                Simulation.totalOnShelves[foodItem.getItemDescription()] += 1;
            }
        }
        while (!Reg3Queue.isEmpty())
        {
            ArrayList al = Reg3Queue.Dequeue();

            for (FoodItem foodItem: al)
            {
                itemsAtCheckout--;
                // add the item back to shelf
                Simulation.totalOnShelves[foodItem.getItemDescription()] += 1;
            }
        }
    }
    */
}

