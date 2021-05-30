package ir.ac.kntu.retaurant;

import ir.ac.kntu.ScannerWrapper;
import ir.ac.kntu.ServiceBuilding;
import ir.ac.kntu.Thing;
import ir.ac.kntu.Time;
import ir.ac.kntu.food.Food;
import ir.ac.kntu.food.Menu;
import ir.ac.kntu.food.Order;
import ir.ac.kntu.order.OrderRange;

import java.util.*;

public class ServiceBuildingWrapper {

    // EditMenu editMenu;

    public static void sortAscendingByScore(ArrayList<? extends ServiceBuilding> restaurants) {
        for (int i = 0; i < restaurants.size() - 1; i++) {
            for (int j = 0; j < restaurants.size() - 1; j++) {
                if (restaurants.get(j).getScore() > restaurants.get(j + 1).getScore()) {
                    Collections.swap(restaurants, j, j + 1);
                }
            }
        }
        // Collections.sort(restaurants, );
    }

    public static void sortDescendingByScore(ArrayList<Restaurant> restaurants) {

        for (int i = 0; i < restaurants.size() - 1; i++) {
            for (int j = 0; j < restaurants.size() - 1; j++) {
                if (restaurants.get(j).getScore() < restaurants.get(j + 1).getScore()) {

                    Collections.swap(restaurants, j, j + 1);
                }
            }
        }
    }

    public static void sortAscendingByComments(ArrayList<Restaurant> restaurants) {
        for (int i = 0; i < restaurants.size() - 1; i++) {
            for (int j = 0; j < restaurants.size() - 1; j++) {
                if (restaurants.get(j).getComments().size() > restaurants.get(j + 1).getComments().size()) {

                    Collections.swap(restaurants, j, j + 1);
                }
            }
        }
    }

    public static void sortDescendingByComments(ArrayList<Restaurant> restaurants) {
        for (int i = 0; i < restaurants.size() - 1; i++) {
            for (int j = 0; j < restaurants.size() - 1; j++) {
                if (restaurants.get(j).getComments().size() < restaurants.get(j + 1).getComments().size()) {

                    Collections.swap(restaurants, j, j + 1);
                }
            }
        }
    }

    public static void sortFoodsByPrice(Restaurant restaurant) {
        ArrayList<Thing> foods = restaurant.getMenu().getFoods();
        for (int i = 0; i < foods.size() - 1; i++) {
            for (int j = 0; j < foods.size() - 1; j++) {
                if (foods.get(j).getPrice() > foods.get(j + 1).getPrice()) {
                    Thing temp = foods.get(j);
                    foods.set(j, foods.get(j + 1));
                    foods.set(j + 1, temp);

                }
            }
        }
        restaurant.getMenu().setFoods(foods);
    }

    public static void sortFoodsByScores(Restaurant restaurant) {
        ArrayList<Thing> foods = restaurant.getMenu().getFoods();
        for (int i = 0; i < foods.size() - 1; i++) {
            for (int j = 0; j < foods.size() - 1; j++) {
                if (foods.get(j).getPrice() < foods.get(j + 1).getPrice()) {
                    Thing temp = foods.get(j);
                    foods.set(j, foods.get(j + 1));
                    foods.set(j + 1, temp);

                }
            }
        }
        restaurant.getMenu().setFoods(foods);
    }

    public static void printRestaurant(ArrayList<? extends ServiceBuilding> restaurants) {
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).isStatus()) {
                System.out.println(i + ": " + restaurants.get(i).getName());
                System.out.println(restaurants.get(i));
                try {
                    restaurants.get(i).getComments();
                } catch (NullPointerException n) {
                    System.out.println("No Further Comments!");
                }
            }
            System.out.println("Deliver Men: ");
            try {
                System.out.println(restaurants.get(i).getDeliverMEN());
            } catch (NullPointerException n) {
                System.out.println("No Further DeliverMan");
            }
            System.out.println("================================");
        }
    }

    public static ServiceBuilding add(ServiceBuilding serviceBuilding) {
        Time[] workTime = new Time[2];
        ArrayList<Thing> foodNames = new ArrayList<>();
        // Food food = new Food();
        System.out.println("Enter Restaurant Name");
        String name = ScannerWrapper.getInstance().nextLine();
        System.out.println("Enter Address");
        String address = ScannerWrapper.getInstance().nextLine();
        System.out.println("Enter Numbers Of Foods You Want To Add To Menu");
        int count = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        while (count > 0) {
            Thing food = new Thing();
            System.out.println("Enter Name");
            food.setName(ScannerWrapper.getInstance().nextLine());
            System.out.println("Enter Price");
            food.setPrice(Double.parseDouble(ScannerWrapper.getInstance().nextLine()));
            food.setPrice((int) (5 * Math.random()));
            food.setComments(new ArrayList<>());
            foodNames.add(food);
            count--;
        }
        System.out.println("Enter 2 numbers for workHours :days(...) to (...)");
        workTime[0] = new Time(Integer.parseInt(ScannerWrapper.getInstance().nextLine()));
        workTime[1] = new Time(Integer.parseInt(ScannerWrapper.getInstance().nextLine()));

        ServiceBuilding newOne = chooseCast(serviceBuilding, name, address, foodNames);
        //new ServiceBuilding(true, name, address, new Menu(new ArrayList<>(foodNames)), new ArrayList<>(), new ArrayList<>());
        newOne.setWorkHours(workTime);
        //newOne.addOrder(new Order());
        return newOne;
    }

    private static ServiceBuilding chooseCast(ServiceBuilding serviceBuilding, String name, String address, ArrayList<Thing> foodNames) {
        if (serviceBuilding.getClass() == Restaurant.class) {
            return new Restaurant(true, name, address, new Menu(new ArrayList<>(foodNames)), new ArrayList<>(), new ArrayList<>());
        } else if (serviceBuilding.getClass() == FruitShop.class) {
            return new FruitShop(true, name, address, new Menu(new ArrayList<>(foodNames)), new ArrayList<>(), new ArrayList<>());
        }
        return new SuperMarket(true, name, address, new Menu(new ArrayList<>(foodNames)), new ArrayList<>(), new ArrayList<>());
    }

    public static void update(ArrayList<Restaurant> restaurants) {
        // FerryFoodOnlineMenu foodOnlineMenu = new FerryFoodOnlineMenu();
        printRestaurant(new ArrayList<>(restaurants));
        System.out.println("Choose Your Restaurant");
        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        System.out.println("Choose What To Do");
        updateMenu();
        int options = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        switch (options) {
            case 1:
                editComment(restaurants.get(choice));
                // foodOnlineMenu.manageOptions(restaurants);
                break;
            case 2:
                restaurants.get(choice).editScore();
                break;
            // foodOnlineMenu.manageOptions(restaurants);
            case 3:
                // TODO: FIX THIS PART
                restaurants.get(choice).getMenu().editFood();
                // foodOnlineMenu.manageOptions(restaurants);
                break;
            case 4:
                // printRestaurant(restaurants);
                // Restaurant restaurant = chooseRestaurant(restaurants);
                restaurants.get(choice).editName();
                break;
            case 5:
                // foodOnlineMenu.manageOptions(restaurants);
            default:
                System.out.println("Watch Your input");
        }

    }

    public static void updateMenu() {
        System.out.println("1: Edit Restaurant Comment");
        System.out.println("2: Edit restaurant Scores");
        System.out.println("3: Edit Restaurant Menus");
        System.out.println("4: Edit Restaurant Name");
        System.out.println("5: return");
    }

    public static ServiceBuilding chooseServiceBuilding(ArrayList<ServiceBuilding> serviceBuildings) {
        printRestaurant(serviceBuildings);
        System.out.println("Choose Restaurant");
        int choice = ScannerWrapper.getInstance().nextInt();
        return serviceBuildings.get(choice);
    }

    public static void editComment(Restaurant restaurant) {
        if (restaurant.getComments().size() == 0) {
            addNewComment(restaurant);
            return;
        }
        System.out.println("1 :Remove Comment");
        System.out.println("2 :Add Comment");
        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        if (choice == 1) {
            removeComment(restaurant);
        } else if (choice == 2) {
            addNewComment(restaurant);
        }

    }

    public static OrderRange printOrderRange(ArrayList<OrderRange> orderRanges) {
        OrderRange orderRange = new OrderRange();
        for (OrderRange o : orderRanges) {
            if (o.getCurrentCapacity() < o.getMaximumCapacity()) {
                System.out.print(o.getStart() + " " + o.getEnd() + " price-> " + o.getCost() + "\n");
            }
        }
        System.out.println("Select One");
        try {
            orderRange = orderRanges.get(ScannerWrapper.getInstance().nextInt());
        } catch (InputMismatchException n) {
            System.out.println("Watch Your Input");
            printOrderRange(orderRanges);
        }
        return orderRange;
    }

    public static void removeComment(Restaurant restaurant) {
        restaurant.showComments();
        System.out.println("Which Comment?");
        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        restaurant.getComments().remove(restaurant.getComments().get(choice));
    }

    public static void addNewComment(Restaurant restaurant) {
        System.out.println("Enter Comment");
        String comment = ScannerWrapper.getInstance().nextLine();
        restaurant.addComments(comment);
    }

}
