package ir.ac.kntu;

import ir.ac.kntu.food.Order;
import ir.ac.kntu.person.DeliverMan;

import java.util.ArrayList;

public class ServiceBuilding {

    private boolean status;
    private String name;
    private String address;
    private Time[] workHours;
    private int score = 5;
    private ArrayList<String> comments;
    private ArrayList<DeliverMan> deliverMEN;

//    public ArrayList<String> getComments() {
//        return comments;
//    }


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

    public void printDeliverMan() {
        for (DeliverMan d : deliverMEN) {
            System.out.println(d);
        }
    }
}
