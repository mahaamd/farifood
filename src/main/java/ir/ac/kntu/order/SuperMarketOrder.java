package ir.ac.kntu.order;

import ir.ac.kntu.Main;
import ir.ac.kntu.ScannerWrapper;
import ir.ac.kntu.Thing;
import ir.ac.kntu.food.Order;
import ir.ac.kntu.person.Customer;
import ir.ac.kntu.retaurant.ServiceBuildingWrapper;
import ir.ac.kntu.retaurant.SuperMarket;
import ir.ac.kntu.stuffs.Stuff;

import java.util.ArrayList;

public class SuperMarketOrder {
    private ArrayList<Stuff> stuffs;
    private static double deliveryCost;
    private static OrderRange orderRange;

    public SuperMarketOrder() {

    }

    public class SuperMarketOrderHelper {

        public void makeOrder(ArrayList<SuperMarket> superMarkets) {
            ServiceBuildingWrapper.printRestaurant(superMarkets);
            SuperMarket superMarket = (SuperMarket) ServiceBuildingWrapper
                    .chooseServiceBuilding(new ArrayList<>(superMarkets));
            superMarkets.remove(superMarket);
            ir.ac.kntu.order.SuperMarketOrder.orderRange = printOrderRange(superMarket.getOrderRanges());
            superMarket.printStuff();
            ArrayList<Thing> stuffs = Main.castStuffToThing(chooseStuff(superMarket.getStuffs()));
            Order orders = new Order();
            //orders.setNewThing(stuffs);
            orders.setThings(stuffs);
            SuperMarketOrder.deliveryCost += orderRange.getCost();

        }

        private ArrayList<Stuff> chooseStuff(ArrayList<Stuff> stuffs) {
            ArrayList<Stuff> stuffs1 = new ArrayList<>();
            for (Stuff stuff : stuffs) {
                System.out.println(stuff);
            }
            while (true) {
                System.out.println("Choose One When Finished type" + "finished");
                String choice = ScannerWrapper.getInstance().nextLine();
                if (choice.equals("finished")) {
                    break;
                }
                stuffs1.add(stuffs.get(Integer.parseInt(choice)));
            }
            return stuffs1;
        }

        private OrderRange printOrderRange(ArrayList<OrderRange> orderRanges) {
            OrderRange orderRange = new OrderRange();
            for (OrderRange o : orderRanges) {
                if (o.getCurrentCapacity() < o.getMaximumCapacity()) {
                    System.out.print(o.getStart() + " " + o.getEnd() + o.getCost() + "\n");
                }
            }
            System.out.println("Select One");
            try {
                orderRange = orderRanges.get(ScannerWrapper.getInstance().nextInt());
            } catch (Exception e) {
                System.out.println("Watch Your Input");
                printOrderRange(orderRanges);
            }
            return orderRange;
        }

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
}

