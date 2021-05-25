package ir.ac.kntu.person;

import ir.ac.kntu.ScannerWrapper;
import ir.ac.kntu.food.Food;
import ir.ac.kntu.food.Order;
import ir.ac.kntu.retaurant.Restaurant;
import ir.ac.kntu.retaurant.WrapperRestaurant;

import java.util.ArrayList;


public class CustomersHelper {

//    private ArrayList<Order> orders;

    public CustomersHelper() {
    }

    public void manageCustomerOrders(ArrayList<Restaurant> restaurants, ArrayList<Order> orders) {

        Restaurant restaurant = WrapperRestaurant.chooseRestaurant(restaurants);
        restaurant.getMenu().printMenu();
        System.out.println("Which Food Do You Want?");
        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        //restaurants.get(options).setMenu(new Menu());
        setOrderStatus(restaurant, restaurant.getMenu().getFoods().get(choice), orders);
    }

    public void setOrderStatus(Restaurant restaurant, Food food, ArrayList<Order> orders) {
        Order order = new Order();
        order.add(food);
        order.setStatus("In Process");
        restaurant.addOrder(order);
        orders.add(order);
    }

    public boolean manageOrderStatus(ArrayList<Restaurant> restaurants, ArrayList<Order> orders, ArrayList<Customer> customers) {
        //newCustomerOrder(customers);
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
                setNewStatus(status, order, restaurant, orders);
            } else {
                return false;
            }
        }
        if (status.equals("Delivered")) {
            setNewStatus(status, order, restaurant, orders);
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

    private void setNewStatus(String status, Order order, Restaurant restaurant, ArrayList<Order> orders) {
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

    public void setComment(Restaurant restaurant, DeliverMan deliverMan) {
        //int rand = Math.random() + restaurants.size();
        System.out.println("How was The Restaurant Service");
        String resComment = ScannerWrapper.getInstance().nextLine();
        restaurant.addComments(resComment);
        System.out.println("What would you Give The Restaurant(from 1 to 10)");
        int restaurantRate = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        restaurant.setScore(restaurantRate);
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
        Customer customer = new Customer(phoneNumber, address, new ArrayList<>());
        //customer.setOrders(new ArrayList<>());
        customers.add(customer);
    }

    public void printCustomers(ArrayList<Customer> customers) {
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
        customers.get(choice).setOrders(new ArrayList<>());
    }

    public void printInProcessOrders(ArrayList<Order> orders) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getStatus().equals("In Process") ||
                    orders.get(i).getStatus().equals("Sending")) {
                System.out.println(i);
                System.out.println(orders.get(i));
                System.out.println(orders.get(i).getStatus());
            }
        }
    }

    public void showCustomerOrderHistory(ArrayList<Customer> customers) {
        Customer customer = chooseCustomer(customers);
        customer.printOrder();
    }

    private Customer chooseCustomer(ArrayList<Customer> customers) {
        printCustomers(customers);
        System.out.println("Choose One");
        int choice = ScannerWrapper.getInstance().nextInt();
        return customers.get(choice);
    }

}
