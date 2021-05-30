package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Objects;

public class Thing {

    private double price;
    private ArrayList<String> comments;
    private String name;
    private double count;
    private int score;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "price=" + price +
                ", comments=" + comments +
                ", name='" + name + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Thing thing = (Thing) o;
        return Double.compare(thing.count, count) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}


