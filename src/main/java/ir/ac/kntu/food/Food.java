package ir.ac.kntu.food;

import ir.ac.kntu.Thing;

import java.util.ArrayList;

public class Food extends Thing {


//    private String name;

//    private double price;

    private ArrayList<String> comments;

    @Override
    public String toString() {
        return "" + getName() + '\'' +
                ", price=" + getPrice();
    }

    public Food() {

    }

    public Food(String name, double price, int rate) {
        setName(name);
        this.setPrice(price);
        setPrice(price);
        comments = new ArrayList<>();
    }



    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
    }

    //public void setName(String name) {
      //  this.name = name;
    //}

}
