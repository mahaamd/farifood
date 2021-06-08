package ir.ac.kntu.restaurant;

import ir.ac.kntu.Thing;

import java.util.ArrayList;

public class Fruit extends Thing {

    private double kg;


    public Fruit(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public Fruit(String name, int price, ArrayList<String> comments) {
        super();
        setName(name);
        setPrice(price);
        setComments(comments);
    }

    public Fruit(String  name, int price, ArrayList<String> comments, int count, int score) {
        super();
        setName(name);
        setPrice(price);
        setComments(comments);
        setCount(count);
        setScore(score);

    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }
}
