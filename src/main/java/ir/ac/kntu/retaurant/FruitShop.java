package ir.ac.kntu.retaurant;

import ir.ac.kntu.ServiceBuilding;
import ir.ac.kntu.Time;
import ir.ac.kntu.food.Menu;
import ir.ac.kntu.food.Order;
import ir.ac.kntu.order.OrderRange;
import ir.ac.kntu.order.SuperMarketOrder;
import ir.ac.kntu.person.DeliverMan;
import ir.ac.kntu.person.Share;
import ir.ac.kntu.stuffs.Stuff;

import java.util.ArrayList;


public class FruitShop extends ServiceBuilding {

    //Menu menu;
    //private Time[] workHour;
    private ArrayList<OrderRange> orderRanges;

    public FruitShop(boolean b, String name, String address, Menu menu, ArrayList<String> comments, ArrayList<DeliverMan> deliverMEN) {
        super(b, name, address, menu, comments, deliverMEN);
    }

    public FruitShop() {

    }

//    public FruitShop() {
//        order = new Order();
//    }

    public void setOrderRanges(ArrayList<OrderRange> orderRanges) {
        this.orderRanges = orderRanges;
    }

    public FruitShop(String name, String address, boolean status) {
        super(status, name, address);
//        setName(name);
//        setStatus(status);
//        setStatus(status);
    }



//    public void setFruits(ArrayList<Fruit> fruits) {
//        this.fruits = fruits;
//    }



    public ArrayList<OrderRange> getOrderRanges() {
        return orderRanges;
    }

    //public FruitShop(FruitShopShare share) {
    //this.share = share;
    //}


//    public FruitShop(boolean status, String name, String address, Menu menu, ArrayList<DeliverMan> deliverMEN, ArrayList<String> comments) {
//        super(status, name, address, menu, deliverMEN, comments);
//    }
}
