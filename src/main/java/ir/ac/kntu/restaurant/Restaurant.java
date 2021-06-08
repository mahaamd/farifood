package ir.ac.kntu.restaurant;

import ir.ac.kntu.ScannerWrapper;
import ir.ac.kntu.ServiceBuilding;
import ir.ac.kntu.Time;
import ir.ac.kntu.food.*;
import ir.ac.kntu.person.*;

import java.util.ArrayList;


public class Restaurant extends ServiceBuilding {

    //int sortOrder;

    //    private boolean status;
//    private String name;
//    private String address;
//    private Time[] workHours;
//    private int score = 5;
    private ArrayList<Order> orders;
    private Menu menu;
    private RestaurantType restaurantType;
//    private ArrayList<DeliverMan> deliverMEN;
//    private ArrayList<String> comments;

    public Restaurant(boolean status, String name, String address, Menu menu) {
        super(status, name, address, menu);
        super.setStatus(status);
        super.setName(name);
        super.setAddress(address);
        this.menu = menu;
    }

    public Restaurant(boolean status, String name, String address, Menu menu, ArrayList<String> objects, ArrayList<DeliverMan> objects1) {
        super(status, name, address, menu, objects, objects1);
    }

    public Restaurant() {

    }


    public RestaurantType getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(RestaurantType restaurantType) {
        this.restaurantType = restaurantType;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void setWorkHours(Time[] workHours) {
        super.setWorkHours(workHours);
    }


    public Menu getMenu() {
        return menu;
    }


    public ArrayList<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public String toString() {
        return getName() + "{" +
                "address='" + getAddress() + '\'' +
                ", workHours{" + "Days :" + getWorkHours()[0].toString() + " to " + getWorkHours()[1].toString() +
                /*", Evening :" + super.getWorkHours()[2].toString() + " to " + super.getWorkHours()[3].toString() +*/
                ", score=" + getScore() +
                "Restaurant Type " + restaurantType +
                '}';
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void setNewRestaurantType() {
        System.out.println("ChooseRestaurantType " + "1 " + RestaurantType.ECONOMIC + "or" +
                "2 " + RestaurantType.MEDIUM + "or" + "3 " + RestaurantType.LUXURIOUS);
        switch (ScannerWrapper.getInstance().nextInt()) {
            case 1:
                this.setRestaurantType(RestaurantType.ECONOMIC);
                break;
            case 2:
                this.setRestaurantType(RestaurantType.MEDIUM);
                break;
            case 3:
                this.setRestaurantType(RestaurantType.LUXURIOUS);
                break;
            default:
                System.out.println("Watch Your input");
                setNewRestaurantType();
        }
    }

}
