package ir.ac.kntu;

import ir.ac.kntu.food.Food;
import ir.ac.kntu.food.Menu;
import ir.ac.kntu.person.*;
import ir.ac.kntu.retaurant.Restaurant;


import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        //TODO: DO NOT FORGET TO CHANGE THIS TO User
        Admin admin = new Admin("admin", "Admin");

        ArrayList<Restaurant> restaurants = initializeRestaurant();

        FerryFoodOnlineMenu ferryFoodOnlineMenu = new FerryFoodOnlineMenu(initializeDeliverMen(), new ArrayList<>(), initializeRestaurant());
        //ferryFoodOnlineMenu.getAdminsList().add(admin);
        PreStartTask preStartTask = new PreStartTask(ferryFoodOnlineMenu);
        ferryFoodOnlineMenu.setCustomers(initializeCustomers());

        preStartTask.handleChoice();
//
//        switch (options) {
//            case CUSTOMER:
//                ferryFoodOnlineMenu.customerMenu();
//                break;
//            case LOCALE_STORES_MANAGER:
//                ferryFoodOnlineMenu.manager();
//                break;
//            case ADMIN:
//                ferryFoodOnlineMenu.adminMenu();
//                break;
//            case EXIT:
//                break;
//            default:
//                System.out.println("Not Valid Choice");
//                preStartTask.handleChoice();
//        }
    }

    public static ArrayList<Restaurant> initializeRestaurant() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(true, "akbarjooje", "tehran", new Menu());
        Time[] workHours = {new Time(8), new Time(13), new Time(16), new Time(21)};
        restaurant.getMenu().setFoods(initializeFood()[0]);
        restaurant.setWorkHours(workHours);
        restaurant.addComments("Good");
        restaurant.addComments("Good");
        restaurant.addComments("Not Bad");
        restaurant.addComments("pizza was terrible");
        restaurant.setScore(12);
        restaurant.setOrders(new ArrayList<>());
        restaurant.setDeliverMEN(initializeDeliverMen());
        restaurants.add(restaurant);
        Restaurant restaurant1 = new Restaurant(true, "akbarjooje2", "karaj", new Menu());
        restaurant1.getMenu().setFoods(initializeFood()[1]);
        Time[] workHours1 = {new Time(7), new Time(14), new Time(16), new Time(21)};
        restaurant1.setWorkHours(workHours1);
        restaurant1.addComments("Good");
        restaurant1.addComments("Good");
        restaurant1.addComments("Fantastic");
        restaurant1.setScore(5);
        restaurant1.setOrders(new ArrayList<>());
        restaurant1.setDeliverMEN(initializeDeliverMen());
        restaurants.add(restaurant1);
        return restaurants;
    }

    public static ArrayList<Food>[] initializeFood() {
        ArrayList<Food>[] foods = new ArrayList[2];
        ArrayList<String> comments = initializeComments()[0];
        ArrayList<String> comments1 = initializeComments()[1];
        Food food = new Food("kebab", 50, 3);
        food.setComments(comments);
        Food food1 = new Food("gheime", 25, 4);
        food1.setComments(comments1);
        Food food2 = new Food("pizza", 75, 1);
        food2.setComments(comments1);
        Food food3 = new Food("sushi", 80, 5);
        food3.setComments(comments);
        foods[0] = new ArrayList<>();
        foods[0].add(food);
        foods[0].add(food1);
        foods[0].add(food2);
        foods[0].add(food3);
        foods[0].add(new Food("burger", 40, 3));
        foods[1] = new ArrayList<>();
        foods[1].add(new Food("Cheese Burger", 36, 4));
        foods[1].add(new Food("Cheesa", 56, 5));
        foods[1].add(food2);
        foods[1].add(new Food("sandwich", 15, 2));
        foods[1].add(new Food("burger", 35, 5));
        return foods;
    }

    public static ArrayList<String>[] initializeComments() {
        ArrayList<String>[] comments = new ArrayList[2];
        comments[0] = new ArrayList<>();
        comments[0].add("perfect");
        comments[0].add("Delicious");
        comments[0].add("Disgusting");
        comments[0].add("not bad");
        comments[1] = new ArrayList<>();
        comments[1].add("Taste Like Hell");
        comments[1].add("Very Delicious");
        comments[1].add("Good");
        return comments;
    }

    public static ArrayList<DeliverMan> initializeDeliverMen() {
        ArrayList<DeliverMan> deliverMEN = new ArrayList<>();
        DeliverMan steve = new DeliverMan("Motor Cycle", Salary.PER_HOUR, true,
                new ArrayList<>(), new ArrayList<>());

        DeliverMan hossein = new DeliverMan("Honda", Salary.PER_ORDER, true,
                new ArrayList<>(), new ArrayList<>());

        deliverMEN.add(steve);
        deliverMEN.add(hossein);

        return deliverMEN;

    }

    public static ArrayList<Customer> initializeCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer = new Customer("093645675206", "Qom", new ArrayList<>());
        Customer customer1 = new Customer("0936256402061", "Tehran", new ArrayList<>());
        Customer customer2 = new Customer("09116805096", "Karaj", new ArrayList<>());
        customer.setPassWord("1234567");
        customer.setUserName("1234567");
        customer1.setPassWord("12345678");
        customer1.setUserName("12345678");
        customer2.setPassWord("123456789");
        customer2.setUserName("123456789");
        customers.add(customer);
        customers.add(customer1);
        customers.add(customer2);
        return customers;
    }

    public ArrayList<Manager> initializeManager() {
        return null;
    }

}