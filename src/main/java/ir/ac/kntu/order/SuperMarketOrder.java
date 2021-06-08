package ir.ac.kntu.order;

import ir.ac.kntu.food.Order;
import ir.ac.kntu.stuffs.Stuff;

import java.util.ArrayList;

public class SuperMarketOrder extends Order{
    private ArrayList<Stuff> stuffs;
    private double deliveryCost;
    private OrderRange orderRange;

    public SuperMarketOrder() {

    }

    public ArrayList<Stuff> getStuffs() {
        return stuffs;
    }

    public void setStuffs(ArrayList<Stuff> stuffs) {
        this.stuffs = stuffs;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public OrderRange getOrderRange() {
        return orderRange;
    }

    public void setOrderRange(OrderRange orderRange) {
        this.orderRange = orderRange;
    }

    //        private OrderRange printOrderRange(ArrayList<OrderRange> orderRanges) {
//            OrderRange orderRange = new OrderRange();
//            for (OrderRange o : orderRanges) {
//                if (o.getCurrentCapacity() < o.getMaximumCapacity()) {
//                    System.out.print(o.getStart() + " " + o.getEnd() + o.getCost() + "\n");
//                }
//            }
//            System.out.println("Select One");
//            try {
//                orderRange = orderRanges.get(ScannerWrapper.getInstance().nextInt());
//            } catch (InputMismatchException n) {
//                System.out.println("Watch Your Input");
//                printOrderRange(orderRanges);
//            }
//            return orderRange;
//        }

    // public SuperMarketOrder(double deliveryCost) {
    // this.deliveryCost = deliveryCost;
    // }

    // private class OrderRange {
    // Integer Start;
    // Integer End;
    // ArrayList<DeliverMan> deliverMEN;
    //
    // public OrderRange(Integer start, Integer end, ArrayList<DeliverMan>
    // deliverMEN) {
    // Start = start;
    // End = end;
    // this.deliverMEN = deliverMEN;
    // }
    // }
}

