package ir.ac.kntu.restaurant;

import ir.ac.kntu.food.Food;
import ir.ac.kntu.food.Order;
import ir.ac.kntu.food.OrderStatus;

import java.util.ArrayList;
import java.util.Objects;

public class RestaurantOrder extends Order {

    private OrderStatus status;

    private ArrayList<Food> foods;

    //private ArrayList<Food> things;

    //private ArrayList<RestaurantOrder> RestaurantOrders;

    public RestaurantOrder() {
        foods = new ArrayList<>();
    }


    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
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
        if (!(o instanceof RestaurantOrder)) {
            return false;
        }
        RestaurantOrder restaurantOrder = (RestaurantOrder) o;
        return Objects.equals(getStatus(), restaurantOrder.getStatus()) && Objects.equals(getFoods(), restaurantOrder.getFoods());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getFoods());
    }

    public ArrayList<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void add(Food food) {
        foods.add(food);
    }
}
