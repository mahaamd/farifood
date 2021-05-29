package ir.ac.kntu.order;

import ir.ac.kntu.person.DeliverMan;

import java.util.ArrayList;

public class OrderRange {
    private Integer start;
    private Integer end;
    private ArrayList<DeliverMan> deliverMEN;
    private double cost;
    private final int maximumCapacity = 6;
    private int currentCapacity;

    public OrderRange(Integer start, Integer end, ArrayList<DeliverMan> deliverMEN, double cost) {
        start = start;
        end = end;
        this.deliverMEN = deliverMEN;
        this.cost = cost;
    }

    public OrderRange() {
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        end = end;
    }

    

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public ArrayList<DeliverMan> getDeliverMEN() {
        return deliverMEN;
    }

    public void setDeliverMEN(ArrayList<DeliverMan> deliverMEN) {
        this.deliverMEN = deliverMEN;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    

}
