package ir.ac.kntu.person;

import ir.ac.kntu.food.Order;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class DeliverMan {

    private int id;

    private String vehicle;

    private Salary salary;

    private boolean accessible;

    private ArrayList<Order> orders;

    private ArrayList<String> comments;

    private int score;

    public DeliverMan() {

    }

    public DeliverMan(String vehicle, Salary salary, boolean accessible, ArrayList<Order> orders,
                      ArrayList<String> comments) {
        this.vehicle = vehicle;
        this.salary = salary;
        this.accessible = accessible;
        this.orders = orders;
        this.comments = comments;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(String salary) {
        salary = salary.toLowerCase(Locale.ROOT);
        if (salary.equals("per order")) {
            this.salary = Salary.PER_ORDER;
        } else if (salary.equals("per hour")) {
            this.salary = Salary.PER_HOUR;
        } else {
            System.out.println("No Such Salary Type!");
        }
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public int getScore() {
        return score;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void addComment(String comment) {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "DeliverMan{" +
                "vehicle='" + vehicle + '\'' +
                ", comments=" + comments +
                ", score=" + score +
                ", salary: " + salary +
                '}';
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeliverMan)) {
            return false;
        }
        DeliverMan that = (DeliverMan) o;
        return isAccessible() == that.isAccessible() && getScore() == that.getScore() && Objects.equals(vehicle, that.vehicle) && getSalary() == that.getSalary() && Objects.equals(getOrders(), that.getOrders()) && Objects.equals(getComments(), that.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicle, getSalary(), isAccessible(), getOrders(), getComments(), getScore());
    }
}


