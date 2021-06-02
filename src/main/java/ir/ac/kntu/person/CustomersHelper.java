package ir.ac.kntu.person;

import ir.ac.kntu.Main;
import ir.ac.kntu.ScannerWrapper;
import ir.ac.kntu.ServiceBuilding;
import ir.ac.kntu.Thing;
import ir.ac.kntu.food.Food;
import ir.ac.kntu.food.Order;
import ir.ac.kntu.food.OrderStatus;
import ir.ac.kntu.order.FruitShopOrder;
import ir.ac.kntu.order.OrderRange;
import ir.ac.kntu.order.SuperMarketOrder;
import ir.ac.kntu.retaurant.*;
import ir.ac.kntu.stuffs.Stuff;
import java.util.ArrayList;


public class CustomersHelper {

//    private ArrayList<Order> orders;

    public CustomersHelper() {
    }

    public void manageCustomerOrders(ArrayList<Restaurant> restaurants, ArrayList<Order> orders) {

        Restaurant restaurant = (Restaurant) ServiceBuildingWrapper.chooseServiceBuilding(new ArrayList<>(restaurants));
        restaurant.getMenu().printMenu();
        System.out.println("Which Food Do You Want?");
        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        //restaurants.get(options).setMenu(new Menu());
        setOrderStatus(restaurant, restaurant.getMenu().getFoods().get(choice), orders);
    }

    public void setOrderStatus(Restaurant restaurant, Thing food, ArrayList<Order> orders) {
        Order order = new Order();
        order.add(food);
        order.setStatus(OrderStatus.IN_PROCESS);
        restaurant.addOrder(order);
        orders.add(order);
    }

    public boolean manageOrderStatus(ArrayList<Restaurant> restaurants, ArrayList<Order> orders, ArrayList<Customer> customers) {
        //newCustomerOrder(customers);
        //TODO: change this part so you can manage error more suitable
        if (orders.size() == 0) {
            return false;
        }
        Order order = chooseOrderToChangeStatus(orders);
        Restaurant restaurant = findOrderInRestaurant(restaurants, order);
        if (restaurant == null) {
            return false;
        }
        String status;
        System.out.print("New Status: ");
        status = ScannerWrapper.getInstance().nextLine();
        if (!status.equals("Sending") && !status.equals("Delivered") && !status.equals("In Process")) {
            return false;
        }
        if (status.equals("Sending")) {
            if (restaurant.checkDeliverManAccessibility()) {
                setNewStatus(OrderStatus.SENDING, order, restaurant, orders);
            } else {
                return false;
            }
        }
        if (status.equals("Delivered")) {
            setNewStatus(OrderStatus.DELIVERED, order, restaurant, orders);
            DeliverMan deliverMan = addOrder(customers, restaurant, order);
            setComment(restaurant, deliverMan);
        }
        return true;
    }

    private DeliverMan addOrder(ArrayList<Customer> customers,
                                Restaurant restaurant, Order order) {
        Customer customer = getRandomCustomer(customers);
        customer.addOrder(order);
        DeliverMan deliverMan = getRandomDeliverMan(restaurant, order);
        deliverMan.addOrder(order);
        return deliverMan;
    }


    private Customer getRandomCustomer(ArrayList<Customer> customers) {
        int random = (int) (Math.random() * customers.size());
        return customers.get(random);
    }

    private Order chooseOrderToChangeStatus(ArrayList<Order> orders) {
        printInProcessOrders(orders);
        System.out.println("Choose an Order To Change Status");
        int choice = ScannerWrapper.getInstance().nextInt();
        return orders.get(choice);
    }

    private DeliverMan getRandomDeliverMan(Restaurant restaurant, Order order) {

        int randomDeliverMan = (int) ((Math.random() * restaurant.getDeliverMEN().size()));
        restaurant.setDeliverManOrders(order, randomDeliverMan);
        return restaurant.getDeliverMEN().get(randomDeliverMan);
    }

    private void setNewStatus(OrderStatus status, Order order, Restaurant restaurant, ArrayList<Order> orders) {
        restaurant.deleteOrder(order);
        orders.remove(order);
        order.setStatus(status);
        restaurant.addOrder(order);
        orders.add(order);
    }

    private Restaurant findOrderInRestaurant(ArrayList<Restaurant> restaurants, Order order) {
        for (Restaurant r : restaurants) {
            for (Order o : r.getOrders()) {
                if (o.equals(order)) {
                    return r;
                }
            }
        }
        return null;
    }

    public void setComment(ServiceBuilding serviceBuilding, DeliverMan deliverMan) {
        //int rand = Math.random() + restaurants.size();
        System.out.println("How was The Restaurant Service");
        String resComment = ScannerWrapper.getInstance().nextLine();
        serviceBuilding.addComments(resComment);
        System.out.println("What would you Give The Restaurant(from 1 to 10)");
        int restaurantRate = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        serviceBuilding.setScore(restaurantRate);
        System.out.println("How was the Delivery ?");
        String delComment = ScannerWrapper.getInstance().nextLine();
        //restaurant.getDeliverMEN().get(deliverMan).addComment(delComment);
        deliverMan.addComment(delComment);
        System.out.println("What would You Rate The DeliverMan");
        int deliverManRate = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        //restaurant.getDeliverMEN().get(deliverMan).setScore(deliverManRate);
        deliverMan.setScore(deliverManRate);
    }

    public void makeNewCustomer(ArrayList<Customer> customers) {
        System.out.println("Enter PhoneNumber");
        String phoneNumber = ScannerWrapper.getInstance().nextLine();
        System.out.println("Enter Address");
        String address = ScannerWrapper.getInstance().nextLine();
        Customer customer = new Customer(phoneNumber, address, new Order());
        //customer.setOrders(new ArrayList<>());
        customers.add(customer);
    }

    public void printCustomers(ArrayList<? extends User> customers) {
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("Customer Number " + i + " Is");
            System.out.println(customers.get(i));
        }
    }

    public void updateCustomer(ArrayList<Customer> customers) {
        printCustomers(customers);
        System.out.println("Choose Customer To Update");
        int choice = ScannerWrapper.getInstance().nextInt();
        System.out.println("Enter New Phone number ");
        customers.get(choice).setPhoneNumber(ScannerWrapper.getInstance().nextLine());
        System.out.println("Enter New Address  ");
        customers.get(choice).setAddress(ScannerWrapper.getInstance().nextLine());
        customers.get(choice).setOrders(new Order());
    }

    public void printInProcessOrders(ArrayList<Order> orders) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getStatus() == OrderStatus.IN_PROCESS ||
                    orders.get(i).getStatus() == OrderStatus.SENDING) {
                System.out.println(i);
                System.out.println(orders.get(i));
                System.out.println(orders.get(i).getStatus());
            }
        }
    }

    public void showCustomerOrderHistory(ArrayList<Customer> customers) {
        Customer customer =(Customer) chooseCustomer(customers);
        customer.printOrder();
    }

    private  User chooseCustomer(ArrayList<? extends User> customers) {
        printCustomers(customers);
        System.out.println("Choose One");
        int choice = ScannerWrapper.getInstance().nextInt();
        return customers.get(choice);
    }

    public void buyFruit(Customer customer, ArrayList<FruitShop> fruitShops) {
        FruitShopOrder fruitShopOrder = new FruitShopOrder();
//        ServiceBuildingWrapper.printRestaurant(fruitShops);
        FruitShop fruitShop = (FruitShop) ServiceBuildingWrapper.chooseServiceBuilding(new ArrayList<>(fruitShops));
        ArrayList<Thing> fruits = chooseStuff(fruitShop.getMenu().getFoods());
        OrderRange orderRange = ServiceBuildingWrapper.printOrderRange(fruitShop.getOrderRanges());
        setFruitAmount(fruitShopOrder, fruits);
        customer.addOrder(fruitShopOrder);
        orderRange.getDeliverMEN().get((int) (Math.random() * orderRange.getDeliverMEN().size())).addOrder(fruitShopOrder);
        fruitShop.addOrder(fruitShopOrder);
    }

    private void setFruitAmount(FruitShopOrder fruitShopOrder, ArrayList<Thing> fruits) {
        print(fruits);
        int count = 0;
        System.out.println("Choose One and enter amount " +
                "the total amount should be less than " + fruitShopOrder.getMaximumAmountPerOrder() + "When finished type finished");
        while (true) {
            ArrayList<Thing> orders = new ArrayList<>();
            String input = ScannerWrapper.getInstance().nextLine();
            if (input.equalsIgnoreCase("finished")) {
                break;
            }
            System.out.println("amount(Kg)");
            int input1 = ScannerWrapper.getInstance().nextInt();
            for (int i = 0; i < input1; i++) {
                if (count < fruitShopOrder.getMaximumAmountPerOrder()) {
                    orders.add(fruits.get(Integer.parseInt(input)));
                    fruits.get(Integer.parseInt(input)).setCount(Integer.parseInt(input) + input1);
                    System.out.println(fruits.get(Integer.parseInt(input)).getCount() + "cccccccccccccccccccccccc");
                    count++;
                }
            }
            if (count > fruitShopOrder.getMaximumAmountPerOrder()) {
                System.out.println("You have Pass the Limit");
                break;
            }
            fruitShopOrder.setThings(orders);
        }
    }

    public void makeOrder(ArrayList<SuperMarket> superMarkets, Customer customer) {
        //ServiceBuildingWrapper.printRestaurant(superMarkets);
//        double cost = 0;
        SuperMarketOrder superMarketOrder = new SuperMarketOrder();
        SuperMarket superMarket = (SuperMarket) ServiceBuildingWrapper
                .chooseServiceBuilding(new ArrayList<>(superMarkets));
//            superMarkets.remove(superMarket);
        ArrayList<Thing> stuffs0 = chooseStuff(superMarket.getMenu().getFoods());
        OrderRange orderRange = ServiceBuildingWrapper.printOrderRange(superMarket.getOrderRanges());
        Main.print(stuffs0);
//        ArrayList<Thing> stuffs = superMarket.getMenu().getFoods();
        Order orders = new Order();
        //orders.setNewThing(stuffs);
        if (!customer.getShare().isBought()) {
            superMarketOrder.setDeliveryCost(superMarketOrder.getDeliveryCost() + totalCost(stuffs0) + orderRange.getCost());
        }
        System.out.println("total cost =" + superMarketOrder.getDeliveryCost());
        System.out.println("Buy?");
        if (ScannerWrapper.getInstance().nextLine().equalsIgnoreCase("yes")) {
            orderRange.setCurrentCapacity(orderRange.getCurrentCapacity() + 1);
            orders.setThings(stuffs0);
            customer.addOrder(orders);
            superMarket.addOrder(orders);
            reduceCount(stuffs0, superMarket);
            orderRange.getDeliverMEN().get((int) (Math.random() * orderRange.getDeliverMEN().size())).addOrder(orders);
        }
    }

    private void reduceCount(ArrayList<Thing> stuffs0, SuperMarket superMarket) {
        for (Thing t : stuffs0) {
            for (Thing th : superMarket.getMenu().getFoods()) {
                if (t.equals(th)) {
                    th.setCount(th.getCount() - 1);
                }
                if (th.getCount() == 0) {
                    superMarket.getMenu().remove(th);
                }
            }
        }
    }

    private double totalCost(ArrayList<Thing> stuffs0) {
        double sum = 0;
        for (Thing t : stuffs0) {
            sum += t.getPrice();
        }
        return sum;
    }

    private ArrayList<Thing> chooseStuff(ArrayList<? extends Thing> stuffs) {
        ArrayList<Thing> stuffs1 = new ArrayList<>();
//            for (Thing stuff : stuffs) {
//                System.out.println(stuff);
//            }
        print(stuffs);
        System.out.println("Choose One When Finished type " + "finished");
        while (true) {
            System.out.println();
            String choice = ScannerWrapper.getInstance().nextLine();
            if (choice.equals("finished")) {
                break;
            }
            stuffs1.add(stuffs.get(Integer.parseInt(choice)));
        }
        return stuffs1;
    }

    private void print(ArrayList<? extends Thing> things) {
        for (int i = 0; i < things.size(); i++) {
            if (things.get(i).getCount() > 0) {
                System.out.println("number " + i);
                System.out.println(things.get(i));
            }
        }
    }

}
