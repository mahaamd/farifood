package ir.ac.kntu.restaurant;

import ir.ac.kntu.*;
import ir.ac.kntu.food.Food;
import ir.ac.kntu.food.Menu;
import ir.ac.kntu.order.OrderRange;

import java.util.*;

public class ServiceBuildingWrapper {

    // EditMenu editMenu;

    public static void sortAscendingByScore(ArrayList<? extends ServiceBuilding> restaurants) {
        Collections.sort(restaurants);

    }

    public static void sortDescendingByScore(ArrayList<? extends ServiceBuilding> serviceBuildings) {

        serviceBuildings.sort(new Comparator<ServiceBuilding>() {
            @Override
            public int compare(ServiceBuilding o1, ServiceBuilding o2) {
                return o2.getScore() - o1.getScore();
            }
        });
    }

    public static void sortAscendingByComments(ArrayList<? extends ServiceBuilding> serviceBuildings) {

        serviceBuildings.sort((o1, o2) -> o2.getComments().size() - o1.getComments().size());
    }

    public static void sortDescendingByComments(ArrayList<? extends ServiceBuilding> serviceBuildings) {

        serviceBuildings.sort((o1, o2) -> -o2.getComments().size() + o1.getComments().size());

    }

    public static void sortFoodsByPrice(ServiceBuilding serviceBuilding) {
        ArrayList<Thing> foods = serviceBuilding.getMenu().getFoods();

        foods.sort((o1, o2) -> (int) (-o2.getPrice() + o1.getPrice()));
        serviceBuilding.getMenu().setFoods(foods);
    }

    public static void sortFoodsByScores(ServiceBuilding serviceBuilding) {
        ArrayList<Thing> foods = serviceBuilding.getMenu().getFoods();
        foods.sort(Comparator.comparingInt(Thing::getScore));

        serviceBuilding.getMenu().setFoods(foods);
    }

    public static void printRestaurant(ArrayList<ServiceBuilding> serviceBuildings) {
        for (int i = 0; i < serviceBuildings.size(); i++) {
            if (serviceBuildings.get(i).isStatus()) {
                System.out.println(i + ": " + serviceBuildings.get(i).getName());
                System.out.println(serviceBuildings.get(i));
                if (serviceBuildings.get(i).getComments().size() == 0 || serviceBuildings.get(i).getComments() == null) {
                    System.out.println("No Further Comments!");
                } else {
                    System.out.println(serviceBuildings.get(i).getComments());
                }

                System.out.println("Deliver Men: ");
                try {
                    System.out.println(serviceBuildings.get(i).getDeliverMEN());
                } catch (NullPointerException n) {
                    System.out.println("No Further DeliverMan");
                }
                System.out.println("================================");
            }
        }
    }

    public static ServiceBuilding add(ServiceBuilding serviceBuilding) {
        Time[] workTime = new Time[2];
        //ArrayList<Thing> foodNames = new ArrayList<>();
        // Food food = new Food();
        System.out.println("Enter Restaurant Name");
        String name = ScannerWrapper.getInstance().nextLine();
        System.out.println("Enter Address");
        String address = ScannerWrapper.getInstance().nextLine();
        Menu menu = makeNewMenu();
        System.out.println("Enter 2 numbers for workHours :days(...) to (...)");
        workTime[0] = new Time(Integer.parseInt(ScannerWrapper.getInstance().nextLine()));
        workTime[1] = new Time(Integer.parseInt(ScannerWrapper.getInstance().nextLine()));

        ServiceBuilding newOne = chooseCast(serviceBuilding, name, address, menu);
        //new ServiceBuilding(true, name, address, new Menu(new ArrayList<>(foodNames)), new ArrayList<>(), new ArrayList<>());
        newOne.setWorkHours(workTime);
        FerryFoodOnlineMenu.getServiceBuildings().add(newOne);
        //newOne.addOrder(new Order());
        return newOne;
    }

    private static ServiceBuilding chooseCast(ServiceBuilding serviceBuilding, String name, String address, Menu
            menu) {
        if (serviceBuilding.getClass() == Restaurant.class) {
            return new Restaurant(true, name, address, menu, new ArrayList<>(), new ArrayList<>());
        } else if (serviceBuilding.getClass() == FruitShop.class) {
            return new FruitShop(true, name, address, menu, new ArrayList<>(), new ArrayList<>());
        }
        return new SuperMarket(true, name, address, menu, new ArrayList<>(), new ArrayList<>());
    }

    public static void update(ServiceBuilding serviceBuilding) {
//            updateMenu();
        int options = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        switch (options) {
            case 1:
                editComment(serviceBuilding);
                // foodOnlineMenu.manageOptions(restaurants);
                break;
            case 2:
                serviceBuilding.editScore();
                break;
            // foodOnlineMenu.manageOptions(restaurants);
            case 3:
                // TODO: FIX THIS PART
                serviceBuilding.getMenu().editFood();
                // foodOnlineMenu.manageOptions(restaurants);
                break;
            case 4:
                ;
                serviceBuilding.editName();
                break;
            case 5:
                break;
            default:
                System.out.println("Watch Your input");
        }

    }

    public static ServiceBuilding chooseServiceBuilding(ArrayList<? extends ServiceBuilding> serviceBuildings) {
        printRestaurant(new ArrayList<>(serviceBuildings));
        System.out.println("Choose Building");
        int choice = ScannerWrapper.getInstance().nextInt();
        return serviceBuildings.get(choice);
    }

    public static void editComment(ServiceBuilding serviceBuilding) {
        if (serviceBuilding.getComments().size() == 0) {
            addNewComment(serviceBuilding);
            return;
        }
        System.out.println("1 :Remove Comment");
        System.out.println("2 :Add Comment");
        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        if (choice == 1) {
            removeComment(serviceBuilding);
        } else if (choice == 2) {
            addNewComment(serviceBuilding);
        }

    }

    public static OrderRange printOrderRange(ArrayList<OrderRange> orderRanges) {
        OrderRange orderRange = new OrderRange();
        int i = 0;
        for (OrderRange o : orderRanges) {
            System.out.println(i);
            if (o.getCurrentCapacity() < o.getMaximumCapacity()) {
                System.out.print(o.getStart() + " " + o.getEnd() + " price-> " + o.getCost() + "\n");
            }
            i++;
        }
        System.out.println("Select One");
        try {
            int choice = ScannerWrapper.getInstance().nextInt();
            orderRange = orderRanges.get(choice);
            orderRange.setBoughtCount(orderRange.getBoughtCount() + 1);
        } catch (InputMismatchException n) {
            System.out.println("Watch Your Input");
            printOrderRange(orderRanges);
        }
        return orderRange;
    }

    public static void removeComment(ServiceBuilding serviceBuilding) {
        serviceBuilding.showComments();
        System.out.println("Which Comment?");
        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        serviceBuilding.getComments().remove(serviceBuilding.getComments().get(choice));
    }

    public static void addNewComment(ServiceBuilding serviceBuilding) {
        System.out.println("Enter Comment");
        String comment = ScannerWrapper.getInstance().nextLine();
        serviceBuilding.addComments(comment);
    }

    public static void changeMenu(ServiceBuilding restaurant) {
        restaurant.getMenu().printMenu();
        editMenu();
        System.out.println("Choose One");
        int choice = ScannerWrapper.getInstance().nextInt();
        switch (choice) {
            case 1:
                editThingName(restaurant);
                break;
            case 2:
                editThingPrice(restaurant);
                break;
            default:
                System.out.println("watch input");
                changeMenu(restaurant);
        }
    }

    private static void editMenu() {
        System.out.println("1: Edit Menu ingredients name");
        System.out.println("2: Edit Menu ingredients price");
    }

    private static void editThingName(ServiceBuilding serviceBuilding) {
        Main.print(serviceBuilding.getMenu().getFoods());
        System.out.println("Choose one");
        int choice = ScannerWrapper.getInstance().nextInt();
        System.out.println("Enter new Name");
        serviceBuilding.getMenu().getFoods().get(choice).setName(ScannerWrapper.getInstance().nextLine());
    }

    private static void editThingPrice(ServiceBuilding serviceBuilding) {
        Main.print(serviceBuilding.getMenu().getFoods());
        System.out.println("Choose one");
        int choice = ScannerWrapper.getInstance().nextInt();
        System.out.println("Enter new price");
        serviceBuilding.getMenu().getFoods().get(choice).setPrice(Integer.parseInt(ScannerWrapper.getInstance().nextLine()));
    }

    public static void addNewMenu(ServiceBuilding restaurant) {
//        restaurant.getMenu().printMenu();
        restaurant.setMenu(makeNewMenu());
    }

    private static Menu makeNewMenu() {
        ArrayList<Thing> foodNames = new ArrayList<>();
        System.out.println("Enter Numbers Of Foods You Want To Add To Menu");
        int count = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        while (count > 0) {
            Food food = new Food();
            System.out.println("Enter Name");
            food.setName(ScannerWrapper.getInstance().nextLine());
            System.out.println("Enter Price");
            food.setPrice(Double.parseDouble(ScannerWrapper.getInstance().nextLine()));
            food.setPrice((int) (5 * Math.random()));
            food.setComments(new ArrayList<>());
            foodNames.add(food);
            count--;
        }
        Menu menu = new Menu();
        menu.setFoods(foodNames);
        return menu;
    }

    public static ServiceBuilding chooseBuildingForYourNewManager() {

        for (int i = 0; i < FerryFoodOnlineMenu.getServiceBuildings().size(); i++) {
            if (!(FerryFoodOnlineMenu.getServiceBuildings().get(i).getClass() == Restaurant.class)) {
                System.out.println(i);
                System.out.println(FerryFoodOnlineMenu.getServiceBuildings().get(i));
            }
        }
        System.out.println("Choose One For your Manager");
        return FerryFoodOnlineMenu.getServiceBuildings().get(ScannerWrapper.getInstance().nextInt());
    }
}
