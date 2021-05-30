package ir.ac.kntu.retaurant;

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

    public <E> Fruit(String  name, int price, ArrayList<String> comments, int count) {
        super();
        setName(name);
        setPrice(price);
        setComments(comments);
        setCount(count);
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }
}
