package ir.ac.kntu.food;

import ir.ac.kntu.Thing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private OrderStatus status;
    //
//    private ArrayList<Food> foods;
//
    private ArrayList<Thing> things;
    private List<? extends Thing> newThing;

//    public Order() {
//        foods = new ArrayList<>();
//    }
//
//    public void setFoods(ArrayList<Food> foods) {
//        this.foods = foods;
//    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }



    public void setNewThing(List<? extends Thing> newThing) {
        this.newThing = newThing;
    }

    public void setThings(ArrayList<Thing> things) {
        this.things = things;
    }

    public ArrayList<Thing> getThings() {
        return things;
    }

    @Override
    public String toString() {
        String food = "";
        for (Thing f : things) {
            food += f.toString();
        }
        return food;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return status == order.status && Objects.equals(things, order.things) && Objects.equals(newThing, order.newThing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, things, newThing);
    }

    public void add(Thing thing) {
        things.add(thing);
    }

//
//    public void setStatus(OrderStatus status) {
//        this.status = status;
//    }
//
//    public OrderStatus getStatus() {
//        return status;
//    }

//    public void add(Food food) {
//        foods.add(food);
//    }

}
