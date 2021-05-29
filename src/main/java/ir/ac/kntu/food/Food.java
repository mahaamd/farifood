package ir.ac.kntu.food;

import ir.ac.kntu.Thing;

import java.util.ArrayList;

public class Food extends Thing {

    private int rate;

    private String name;

    private double price;

    private ArrayList<String> comments;

    @Override
    public String toString() {
        return "" + name + '\'' +
                ", price=" + price;
    }

    public Food() {

    }

    public Food(String name, double price, int rate) {
        this.name = name;
        this.price = price;
        this.rate = rate;
        comments = new ArrayList<>();
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setName(String name) {
        this.name = name;
    }

}
