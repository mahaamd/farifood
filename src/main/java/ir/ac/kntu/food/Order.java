package ir.ac.kntu.food;

import java.util.ArrayList;
import java.util.Objects;

public class Order {

    private String status;

    private ArrayList<Food> foods;

    //private ArrayList<Order> orders;

    public Order() {
        foods = new ArrayList<>();
    }


    @Override
    public String toString() {
        String food = "";
        for (Food f : foods) {
            food += f.toString();
        }
        return food;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(getStatus(), order.getStatus()) && Objects.equals(getFoods(), order.getFoods());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getFoods());
    }

    public ArrayList<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    public void add(Food food) {
        foods.add(food);
    }

}
