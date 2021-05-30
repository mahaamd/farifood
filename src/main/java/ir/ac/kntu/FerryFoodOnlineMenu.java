package ir.ac.kntu;

import ir.ac.kntu.food.Order;
import ir.ac.kntu.order.SuperMarketOrder;
import ir.ac.kntu.person.*;

import ir.ac.kntu.retaurant.*;

import java.util.ArrayList;

public class FerryFoodOnlineMenu {


    private ArrayList<Manager> managers;
    private ArrayList<Fruit> fruits;
    private ArrayList<Restaurant> restaurants;
    //    private ArrayList<ServiceBuilding> serviceBuildings;
    private ArrayList<Admin> adminsList;
    private ArrayList<Customer> customers;
    private ArrayList<DeliverMan> deliverMEN;
    private ArrayList<Order> orders;
    private CustomersHelper customersHelper;
    private EditMenu editMenu;
    private ArrayList<SuperMarket> superMarkets;
    private ArrayList<FruitShop> fruitShops;

    public FerryFoodOnlineMenu() {

    }



    public void setSuperMarkets(ArrayList<SuperMarket> superMarkets) {
        this.superMarkets = superMarkets;
    }

    public void setFruitShops(ArrayList<FruitShop> fruitShops) {
        this.fruitShops = fruitShops;
    }

    public void setAdminsList(ArrayList<Admin> adminsList) {
        this.adminsList = adminsList;
    }

    public ArrayList<Manager> getManagers() {
        return managers;
    }

    public ArrayList<Admin> getAdminsList() {
        return adminsList;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public FerryFoodOnlineMenu(ArrayList<DeliverMan> deliverMEN, ArrayList<Order> orders, ArrayList<Restaurant>
            restaurants) {
        this.deliverMEN = deliverMEN;
        this.orders = orders;
        this.customersHelper = new CustomersHelper();
//        adminsList = new ArrayList<>();
        this.restaurants = restaurants;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

//    public void preStartMenu(User user) {
//        System.out.println("1: Admin");
//        System.out.println("2: Manager");
//        System.out.println("3: Customer");
//        int choice = ScannerWrapper.getInstance().nextInt();
//        useValidation(user,);
//        handleChoices(choice,);
//    }

//    public void manageOptions(ArrayList<Restaurant> restaurants) {
//        printStartingMenu();
//        int options = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
//        handleChoices(options, restaurants);
//    }

    public void printStartingMenu() {
        System.out.println("1: Admin");
        System.out.println("2: Manager");
        System.out.println("3: Customer");
        System.out.println("4: exit");
    }

    public void manager(Manager manager) {
        Restaurant restaurant = manager.getRestaurant();
        int option = printManagerMenu();
        if (option == 1) {
            ServiceBuildingWrapper.update(restaurants);
        } else if (option == 2) {
            editMenu.addNewMenu(restaurant);
        } else if (option == 3) {
            editMenu.changeMenu(restaurant);
        } else if (option == 4) {
            Main.print(restaurant.getOrders());
        } else if (option == 5) {
            restaurant.printDeliverMan();
        } else if (option == 6) {
            restaurant.showComments();
        } else {
            System.out.println("wrong input");
            manager(manager);
        }
    }

    public int printManagerMenu() {
        System.out.println("Choose What todo");
        System.out.println("1: Edit Your Restaurant");
        System.out.println("2: Add new menu");
        System.out.println("3: Change Existing Menu");
        System.out.println("4: Show Order History");
        System.out.println("5: Print restaurant DeliverNan");
        System.out.println("6: Show restaurant Comment");
        return ScannerWrapper.getInstance().nextInt();
    }

    public void customerMenu(Customer customer) {
        customersHelper.manageCustomerOrders(restaurants, orders);//TODO:check if you need to add new menu for this in this part
        customersHelper.showCustomerOrderHistory(customers);
        //TODO: Add Share
//        SuperMarketOrder superMarketOrder = new SuperMarketOrder();
//        SuperMarketOrder.SuperMarketOrderHelper superMarketOrderHelper = superMarketOrder.new SuperMarketOrderHelper();
//        superMarketOrderHelper.makeOrder();
    }


    public void adminMenu(Admin admin) {
        System.out.println("Admin");
    }

    public void customerStartingMenu() {
        //CustomersHelper customersHelper = new CustomersHelper();
        System.out.println("1: Make Order");
        System.out.println("2: Manage Order");
        System.out.println("3: Manage Customer");
        System.out.println("4: return");
        int choice = ScannerWrapper.getInstance().nextInt();
        switch (choice) {
            case 1:
                customersHelper.manageCustomerOrders(restaurants, orders);
                customerStartingMenu();
                break;
            case 2:
                boolean noMatch = customersHelper.manageOrderStatus(restaurants, orders, customers);
                if (!noMatch) {
                    System.out.println("No Order found Or DeliverMan Does Not exist now" +
                            " Make Sure You Have Made an Order or Not");
                }
                customerStartingMenu();
                break;
            case 3:
                manageCustomer();
                customerStartingMenu();
                break;
            case 4:
                return;
            default:
                System.out.println("Wrong Input");
                customerStartingMenu();
        }
    }

    private void manageCustomer() {
        //CustomersHelper customersHelper = new CustomersHelper();
        System.out.println("1: Add new Customer");
        System.out.println("2: Update Customers");
        System.out.println("3: Show Entered Customers");
        System.out.println("4: show Customers Order History");
        System.out.println("5 :return");
        int choice = ScannerWrapper.getInstance().nextInt();
        switch (choice) {
            case 1:
                customersHelper.makeNewCustomer(customers);
                manageCustomer();
                break;
            case 2:
                customersHelper.updateCustomer(customers);
                manageCustomer();
                break;
            case 3:
                customersHelper.printCustomers(customers);
                manageCustomer();
                break;
            case 4:
                customersHelper.showCustomerOrderHistory(customers);
            case 5:
                return;
            default:
                System.out.println("Oops Try Again");
                manageCustomer();
        }
    }

    public void restaurantMenu(ArrayList<Restaurant> restaurants) {
        System.out.println("1: Create New Restaurant");
        System.out.println("2: Update Restaurant");
        System.out.println("3: Show Restaurant Info");
        System.out.println("4: return");
        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        switch (choice) {
            case 1:
                //restaurants.add((Restaurant) ServiceBuildingWrapper.add());
                restaurantMenu(restaurants);
                break;
            case 2:
                ServiceBuildingWrapper.update(restaurants);
                restaurantMenu(restaurants);
                break;
            case 3:
                ServiceBuildingWrapper.printRestaurant(new ArrayList<>(restaurants));
                restaurantMenu(restaurants);
                break;
            case 4:
                //manageOptions(restaurants);
                break;
            default:
                System.out.println("Wrong Input");
                restaurantMenu(restaurants);
        }
    }

    public void sortFoods(ArrayList<Restaurant> restaurants) {
        System.out.println("1 :Sort By Food Price\n2 :Sort By Score\n3 :return");
        int choice = ScannerWrapper.getInstance().nextInt();
        if (choice == 1) {
            for (Restaurant r : restaurants) {
                ServiceBuildingWrapper.sortFoodsByPrice(r);
            }
        }
        if (choice == 2) {
            for (Restaurant r : restaurants) {
                ServiceBuildingWrapper.sortFoodsByScores(r);
            }
        }
    }

    public void sortRestaurant(ArrayList<Restaurant> restaurants) {
        System.out.println("1 :sortAscendingByComments");
        System.out.println("2 :sortDescendingByComments");
        System.out.println("3 :sortAscendingByScore");
        System.out.println("4 :sortDescendingByScore");
        System.out.println("5 :return");
        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        switch (choice) {
            case 1:
                ServiceBuildingWrapper.sortAscendingByComments(restaurants);
                break;
            case 2:
                ServiceBuildingWrapper.sortDescendingByComments(restaurants);
                break;
            case 3:
                ServiceBuildingWrapper.sortAscendingByScore(restaurants);
                break;
            case 4:
                ServiceBuildingWrapper.sortDescendingByScore(restaurants);
                break;
            case 5:
                //manageOptions(restaurants);
                break;
            default:
                System.out.println("Wrong input");
                sortRestaurant(restaurants);
        }
    }

    public void sortOptions(ArrayList<Restaurant> restaurants) {
        System.out.println("Set Desire order For Restaurant(1)\nSet Desire Order For Foods demonstration(2)\nreturn(3)");
        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        if (choice == 1) {
            sortRestaurant(restaurants);
        }
        if (choice == 2) {
            sortFoods(restaurants);
        }
    }

    public void deliverManMenu(ArrayList<Restaurant> restaurants) {
        deliverManMenuPrint();
        MangeDeliverMan mangeDeliverMan = new MangeDeliverMan();
        int option = ScannerWrapper.getInstance().nextInt();
        switch (option) {
            case 1:
                MangeDeliverMan.printDeliverMen(deliverMEN);
                deliverManMenu(restaurants);
                break;
            case 2:
                mangeDeliverMan.addDeliverMan(restaurants, deliverMEN);
                deliverManMenu(restaurants);
                break;
            case 3:
                MangeDeliverMan.printDeliverMen(deliverMEN);
                System.out.println("Choose One DeliverMan");
                int choice = ScannerWrapper.getInstance().nextInt();
//                DeliverMan deliverMan = mangeDeliverMan.getDeliverMan(choice, deliverMEN0);
                mangeDeliverMan.update(getDeliverMan(choice));
                deliverManMenu(restaurants);
                break;
            case 4:
                //manageOptions(restaurants);
            default:
                System.out.println("TRy Again");
                deliverManMenu(restaurants);
        }
    }

    private void deliverManMenuPrint() {
        System.out.println("1: Print Existing DeliverMen");
        System.out.println("2: Create New DeliverMan");
        System.out.println("3: Update DeliverMen Info");
        System.out.println("4: return");
    }

    private DeliverMan getDeliverMan(int deliverMan) {
        return deliverMEN.get(deliverMan);
    }
}
