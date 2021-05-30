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

public class SuperMarket extends ServiceBuilding {

    //    private boolean status;
//    private String name;
//    private String address;
//    private int score = 5;
//    private ArrayList<DeliverMan> deliverMEN;
//    private ArrayList<String> comments;
    private ArrayList<Share> shares;
    //private Time[] workHour;
    //private SuperMarketOrder order;
    private ArrayList<OrderRange> orderRanges;


    public SuperMarket(boolean status, String name, String address) {
        super(status, name, address);
    }

    public SuperMarket(boolean status, String name, String address, Menu menu, ArrayList<String> comments, ArrayList<DeliverMan> deliverMan) {
        super(status, name, address, menu, comments, deliverMan);
    }
//    @Override
//    public SuperMarketOrder getOrder() {
//        return order;
//    }


    public void setOrderRanges(ArrayList<OrderRange> orderRanges) {
        this.orderRanges = orderRanges;
    }

//    public ArrayList<Stuff> getStuffs() {
//        return stuffs;
//    }

    //    public void setDeliverMEN(ArrayList<DeliverMan> deliverMEN) {
//        this.deliverMEN = deliverMEN;
//    }
//
//    public void setComments(ArrayList<String> comments) {
//        this.comments = comments;
//    }


    @Override
    public void setWorkHours(Time[] workHours) {
        super.setWorkHours(workHours);
    }

    public void setShares(ArrayList<Share> shares) {
        this.shares = shares;
    }

    //public void setOrder(SuperMarketOrder order) {
    // this.order = order;
    //}

    public ArrayList<OrderRange> getOrderRanges() {
        return orderRanges;
    }

//    public void printStuff() {
//        for (Stuff s: stuffs) {
//            System.out.println(s);
//        }
//    }

    //    public SuperMarket(Time[] workHour) {
//        this.workHour = workHour;
//    }

    //    public SuperMarket(boolean status, String name, String address, Menu menu, ArrayList<DeliverMan> deliverMEN, ArrayList<String> comments) {
//        super(status, name, address, menu, deliverMEN, comments);
//    }

}
