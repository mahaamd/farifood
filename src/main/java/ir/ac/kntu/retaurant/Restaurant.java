package ir.ac.kntu.retaurant;

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

//    public Restaurant(boolean status, String name, String address, Menu menu, ArrayList<DeliverMan> deliverMEN, ArrayList<String> comments) {
//        super.setStatus(status);
//        super.setName(name);
//        super.setAddress(address);
//        this.menu = menu;
//        super.setDeliverMEN(deliverMEN);
//        super.setComments(comments);
//    }


    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void setWorkHours(Time[] workHours) {
        super.setWorkHours(workHours);
    }

//    public void setScore(int score) {
//        this.score = score;
//    }
//
//    public int getScore() {
//        return score;
//    }

//    public ArrayList<String> getComments() {
//        return new ArrayList<>(comments);
//    }

//    public String getName() {
//        return this.name;
//    }
//
//    public boolean isStatus() {
//        return status;
//    }

    public Menu getMenu() {
        return menu;
    }

//    public ArrayList<DeliverMan> getDeliverMEN() {
//        return new ArrayList<>(deliverMEN);
//    }

    public ArrayList<Order> getOrders() {
        return new ArrayList<>(orders);
    }

//    public void addComments(String comment) {
//        if (comments == null) {
//            comments = new ArrayList<>();
//        }
//        comments.add(comment);
//    }


//    public void setDeliverMEN(ArrayList<DeliverMan> deliverMEN) {
//        this.deliverMEN = deliverMEN;
//    }

//    @Override
//    public String toString() {
//        return "{" +
//                "address='" + super.getAddress() + '\'' +
//                ", workHours{" + "Days :" + super.getWorkHours()[0].toString() + " to " + super.getWorkHours()[1].toString() +
//                /*", Evening :" + super.getWorkHours()[2].toString() + " to " + super.getWorkHours()[3].toString() +*/
//                ", score=" + super.getScore() +
//                '}';
//    }

//    public void showComments() {
//        for (int i = 0; i < comments.size(); i++) {
//            System.out.println("Comment Number " + i + " Is");
//            System.out.println(comments.get(i));
//        }
//    }

    public void addOrder(Order order) {
        orders.add(order);
    }

//    public boolean checkDeliverManAccessibility() {
//        for (DeliverMan d : getDeliverMEN()) {
//            if (d.isAccessible()) {
//                return true;
//            }
//        }
//        return false;
//    }

//    public void editScore() {
//        System.out.println("Current Score ==" + super.getScore());
//        System.out.println("Enter New Score");
//        int score = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
//        setScore(score);
//    }
//
//    public void editName() {
//        System.out.println("Enter new Name");
//        super.setName(ScannerWrapper.getInstance().nextLine());
//    }

//    public void addDeliverMan(DeliverMan deliverMan) {
//        deliverMEN.add(deliverMan);
//    }
//
//    public void setDeliverManOrders(Order newOrder, int whichDeliverMan) {
//        deliverMEN.get(whichDeliverMan).addOrder(newOrder);
//    }

//    public void deleteOrder(Order order) {
//        orders.remove(order);
//    }

    public void showOrderHistory() {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

//    public void printDeliverMan() {
//        for (DeliverMan d : deliverMEN) {
//            System.out.println(d);
//        }
//    }
}
