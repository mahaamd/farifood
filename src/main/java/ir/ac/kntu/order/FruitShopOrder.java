package ir.ac.kntu.order;

import ir.ac.kntu.food.Order;

import java.util.ArrayList;

public class FruitShopOrder extends Order {

    public FruitShopOrder() {
        setThings(new ArrayList<>());
    }

    //    private ArrayList<Fruit> fruits;

//    public ArrayList<Fruit> getFruits() {
//        return fruits;
//    }
//
//    public void setFruits(ArrayList<Fruit> fruits) {
//        this.fruits = fruits;
//    }

    public Integer getMaximumAmountPerOrder() {
        return 12;
    }
}
