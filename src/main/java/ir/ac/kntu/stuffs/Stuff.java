package ir.ac.kntu.stuffs;

import ir.ac.kntu.Thing;

import java.util.ArrayList;


public class Stuff extends Thing {

    private String name;
    private StuffStatus status;
    //private Integer count;

    public Stuff() {
    }

    public Stuff(String name, StuffStatus status, Integer count, double price, ArrayList<String> comments) {
        this.name = name;
        this.status = status;
        //this.count = count;
        setCount(count);
        setPrice(price);
        setComments(comments);
    }

//    public Integer getCount() {
//        return count;
//    }

//    public void setCount(Integer count) {
//        this.count = count;
//    }

    @Override
    public String toString() {
        return name +
                ", status=" + status +
                ", price=" + getPrice();
    }
}
