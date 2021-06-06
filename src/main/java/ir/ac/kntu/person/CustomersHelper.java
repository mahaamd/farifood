package ir.ac.kntu.person;

import ir.ac.kntu.*;
import ir.ac.kntu.food.Order;
import ir.ac.kntu.food.OrderStatus;
import ir.ac.kntu.order.FruitShopOrder;
import ir.ac.kntu.order.OrderRange;
import ir.ac.kntu.order.SuperMarketOrder;
import ir.ac.kntu.retaurant.*;

import java.time.LocalTime;
import java.util.ArrayList;


public class CustomersHelper {

//    private ArrayList<Order> orders;

    public CustomersHelper() {
    }

    public String manageRestaurantOrders(ArrayList<Restaurant> restaurants, ArrayList<Order> orders, Customer customer) {
        Restaurant restaurant = (Restaurant) ServiceBuildingWrapper.chooseServiceBuilding(restaurants);
        restaurant.getMenu().printMenu();
        System.out.println("Which Food Do You Want?");
        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        if (!checkTime(restaurants.get(choice))) {
            return "Restaurant is closed now";
        }
        //restaurants.get(options).setMenu(new Menu());
        Order order = new Order();
        order.add(restaurant.getMenu().getFoods().get(choice));
        customer.addOrder(order);
        setOrderStatus(restaurant, restaurant.getMenu().getFoods().get(choice), orders);
        return "SuccessFull";
    }

    public void setOrderStatus(Restaurant restaurant, Thing food, ArrayList<Order> orders) {
        Order order = new Order();
        order.add(food);
        order.setStatus(OrderStatus.IN_PROCESS);
        restaurant.addOrder(order);
        orders.add(order);
    }

    public String manageOrderStatus(ArrayList<Order> orders, Customer customer) {
        //newCustomerOrder(customer);
        //TODO: change this part so you can manage error more suitable
        if (orders.size() == 0 || customer.getOrders().getThings().size() == 0 || customer.getOrders().getThings() == null) {
            return "No order First Order sth";
        }
        Order order = customer.getOrders();
        ServiceBuilding serviceBuilding = findOrderInRestaurant(FerryFoodOnlineMenu.getServiceBuildings(), order);
        if (serviceBuilding == null) {
            return "No order First Order sth";
        }
        String status;
        System.out.print("New Status: ");
        status = ScannerWrapper.getInstance().nextLine();
        if (!status.equals("Sending") && !status.equals("Delivered") && !status.equals("In Process")) {
            manageOrderStatus(orders, customer);
        }
        if (status.equals("Sending")) {
            if (serviceBuilding.checkDeliverManAccessibility()) {
                setNewStatus(OrderStatus.SENDING, order, serviceBuilding, orders);
            } else {
                return "No deliver man or Deliver men are not accessible Right Now ";
            }
        }
        if (status.equals("Delivered")) {
            setNewStatus(OrderStatus.DELIVERED, order, serviceBuilding, orders);
            DeliverMan deliverMan = addOrder(customer, serviceBuilding, order);
            setComment(serviceBuilding, deliverMan);
        }
        return "Successful";
    }

    private DeliverMan addOrder(Customer customer,
                                ServiceBuilding serviceBuilding, Order order) {
        customer.addOrder(order);
        DeliverMan deliverMan = getRandomDeliverMan(serviceBuilding, order);
        deliverMan.addOrder(order);
        return deliverMan;
    }


//    private Customer getRandomCustomer(ArrayList<Customer> customers) {
//        int random = (int) (Math.random() * customers.size());
//        return customers.get(random);
//    }

//    private Order chooseOrderToChangeStatus(ArrayList<Order> orders) {
//        printInProcessOrders(orders);
//        System.out.println("Choose an Order To Change Status");
//        int choice = ScannerWrapper.getInstance().nextInt();
//        return orders.get(choice);
//    }

    private DeliverMan getRandomDeliverMan(ServiceBuilding serviceBuilding, Order order) {

        int randomDeliverMan = (int) ((Math.random() * serviceBuilding.getDeliverMEN().size()));
        serviceBuilding.setDeliverManOrders(order, randomDeliverMan);
        return serviceBuilding.getDeliverMEN().get(randomDeliverMan);
    }

    private void setNewStatus(OrderStatus status, Order order, ServiceBuilding serviceBuilding, ArrayList<Order> orders) {
        serviceBuilding.deleteOrder(order);
        orders.remove(order);
        order.setStatus(status);
        serviceBuilding.addOrder(order);
        orders.add(order);
    }

    private ServiceBuilding findOrderInRestaurant(ArrayList<? extends ServiceBuilding> serviceBuildings, Order order) {
        for (ServiceBuilding s : serviceBuildings) {
            for (Order o : s.getOrders()) {
                if (o.equals(order)) {
                    return s;
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
        System.out.println("Enter Password");
        customer.setPassWord(ScannerWrapper.getInstance().nextLine());
        System.out.println("Enter userName");
        customer.setUserName(ScannerWrapper.getInstance().nextLine());
        //customer.setOrders(new ArrayList<>());
        customers.add(customer);
    }

    public void printCustomers(ArrayList<? extends User> customers) {
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("Customer Number " + i + " Is");
            System.out.println(customers.get(i));
        }
    }

    public void updateCustomer(Customer customer) {
        System.out.println("Enter New Phone number ");
        customer.setPhoneNumber(ScannerWrapper.getInstance().nextLine());
        System.out.println("Enter New Address  ");
        customer.setAddress(ScannerWrapper.getInstance().nextLine());
        customer.setOrders(new Order());
        customer.setShare(new Share());
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

    private User chooseCustomer(ArrayList<? extends User> customers) {
        printCustomers(customers);
        System.out.println("Choose One");
        int choice = ScannerWrapper.getInstance().nextInt();
        return customers.get(choice);
    }

    public String buyFruit(Customer customer, ArrayList<FruitShop> fruitShops, ArrayList<Order>
            orders) {
        FruitShopOrder fruitShopOrder = new FruitShopOrder();
//        ServiceBuildingWrapper.printRestaurant(fruitShops);
        FruitShop fruitShop = (FruitShop) ServiceBuildingWrapper.chooseServiceBuilding(fruitShops);
        if (!checkTime(fruitShop)) {
            return "Fruit Shop is closed";
        }
        ArrayList<Thing> fruits = chooseStuff(fruitShop.getMenu().getFoods());
        OrderRange orderRange = ServiceBuildingWrapper.printOrderRange(fruitShop.getOrderRanges());
        setFruitAmount(fruitShopOrder, fruits);
        customer.addOrder(fruitShopOrder);
        orders.add(fruitShopOrder);
        orderRange.getDeliverMEN().get((int) (Math.random() * orderRange.getDeliverMEN().size())).addOrder(fruitShopOrder);
        fruitShop.addOrder(fruitShopOrder);
        return "SuccessFull";
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

    public String makeSuperMarketOrder(ArrayList<SuperMarket> superMarkets, Customer customer, ArrayList<Order> orders) {
        SuperMarketOrder superMarketOrder = new SuperMarketOrder();
        SuperMarket superMarket = (SuperMarket) ServiceBuildingWrapper.chooseServiceBuilding(superMarkets);
        if (!checkTime(superMarket)) {
            return "SuperMarket is closed";
        }
        ;
        ArrayList<Thing> stuffs0 = chooseStuff(superMarket.getMenu().getFoods());
        OrderRange orderRange = ServiceBuildingWrapper.printOrderRange(superMarket.getOrderRanges());
        Main.print(stuffs0);
        Order order = new Order();
        if (!customer.getShare().isBought()) {
            superMarketOrder.setDeliveryCost(superMarketOrder.getDeliveryCost() + totalCost(stuffs0) + orderRange.getCost());
        }
        System.out.println("total cost =" + superMarketOrder.getDeliveryCost());
        System.out.println("Buy?");
        if (ScannerWrapper.getInstance().nextLine().equalsIgnoreCase("yes")) {
            orderRange.setCurrentCapacity(orderRange.getCurrentCapacity() + 1);
            order.setThings(stuffs0);
            customer.addOrder(order);
            superMarket.addOrder(order);
            reduceCount(stuffs0, superMarket);
            orders.add(order);
            orderRange.getDeliverMEN().get((int) (Math.random() * orderRange.getDeliverMEN().
                    size())).addOrder(order);
        }
        return "SuccessFull";
    }

    private boolean checkTime(ServiceBuilding serviceBuilding) {
        return serviceBuilding.getWorkHours()[0].getHour() < LocalTime.now().getHour() &&
                serviceBuilding.getWorkHours()[1].getHour() > LocalTime.now().getHour();
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
