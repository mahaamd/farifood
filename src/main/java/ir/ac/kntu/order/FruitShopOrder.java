package ir.ac.kntu.order;

import ir.ac.kntu.food.Order;

import java.util.ArrayList;

public class FruitShopOrder extends Order {

    public FruitShopOrder() {
        setThings(new ArrayList<>());
    }


    public Integer getMaximumAmountPerOrder() {
        return 12;
    }
}
