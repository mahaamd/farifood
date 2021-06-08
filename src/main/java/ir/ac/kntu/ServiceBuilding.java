package ir.ac.kntu;

import ir.ac.kntu.food.Menu;
import ir.ac.kntu.food.Order;
import ir.ac.kntu.person.DeliverMan;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ServiceBuilding implements Comparable<ServiceBuilding> {

    private Menu menu;
    private boolean status;
    private String name;
    private String address;
    private Time[] workHours;
    private int score = 5;
    private ArrayList<String> comments;
    private ArrayList<DeliverMan> deliverMEN;
    private ArrayList<Order> orders;

    public <E extends ServiceBuilding> ServiceBuilding(boolean b, String name, String address, Menu menu, ArrayList<String> comments,
                                                       ArrayList<DeliverMan> deliverMEN) {
        this.name = name;
        this.address = address;
        this.status = b;
        this.menu = menu;
        this.comments = comments;
        this.deliverMEN = deliverMEN;
    }

    public ServiceBuilding(boolean status, String name, String address, Menu menu) {
        this.status = status;
        this.name = name;
        this.address = address;
        this.menu = menu;
    }

    public ServiceBuilding(boolean status, String name, String address) {
        this.status = status;
        this.name = name;
        this.address = address;
    }

    public ServiceBuilding() {

    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public int compareTo(@NotNull ServiceBuilding o) {
        return this.score - o.getScore();
    }

    @Override
    public String toString() {
        return getName() + "{" +
                "address='" + getAddress() + '\'' +
                ", workHours{" + "Days :" + getWorkHours()[0].toString() + " to " + getWorkHours()[1].toString() +
                /*", Evening :" + super.getWorkHours()[2].toString() + " to " + super.getWorkHours()[3].toString() +*/
                ", score=" + getScore() +
                '}';
    }


    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ArrayList<Order> getOrder() {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        return new ArrayList<>(orders);
    }

    public void setOrder(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<DeliverMan> getDeliverMEN() {
        return new ArrayList<>(deliverMEN);
    }

    public void setDeliverMEN(ArrayList<DeliverMan> deliverMEN) {
        this.deliverMEN = deliverMEN;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
    }

    public boolean isStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Time[] getWorkHours() {
        return workHours;
    }

    public int getScore() {
        return score;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWorkHours(Time[] workHours) {
        this.workHours = workHours;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addOrder(Order order) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        this.orders.add(order);
    }

    public void addComments(String comment) {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }

    public void showComments() {
        for (int i = 0; i < comments.size(); i++) {
            System.out.println("Comment Number " + i + " Is");
            System.out.println(comments.get(i));
        }
    }

    public boolean checkDeliverManAccessibility() {
        for (DeliverMan d : getDeliverMEN()) {
            if (d.isAccessible()) {
                return true;
            }
        }
        return false;
    }

    public void addDeliverMan(DeliverMan deliverMan) {
        deliverMEN.add(deliverMan);
    }

    public void setDeliverManOrders(Order newOrder, int whichDeliverMan) {
        deliverMEN.get(whichDeliverMan).addOrder(newOrder);
    }

    public boolean printDeliverMan() {
        if (deliverMEN.size() == 0) {
            System.out.println("No deliverMan");
            return false;
        }
        for (DeliverMan d : deliverMEN) {
            System.out.println(d);
        }
        return true;
    }


    public void editName() {
        System.out.println("Enter new Name");
        setName(ScannerWrapper.getInstance().nextLine());
    }

    public void editScore() {
        System.out.println("Current Score ==" + getScore());
        System.out.println("Enter New Score");
        int score = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        setScore(score);
    }

    public void deleteOrder(Order order) {
        orders.remove(order);
    }

}
