package ir.ac.kntu;

import ir.ac.kntu.food.Order;
import ir.ac.kntu.person.*;

import ir.ac.kntu.retaurant.EditMenu;
import ir.ac.kntu.retaurant.Restaurant;
import ir.ac.kntu.retaurant.WrapperRestaurant;

import java.util.ArrayList;

public class FerryFoodOnlineMenu {


    private ArrayList<Manager> managers;
    private ArrayList<Restaurant> restaurants;
    private ArrayList<Admin> adminsList;
    private ArrayList<Customer> customers;
    private ArrayList<DeliverMan> deliverMEN;
    private ArrayList<Order> orders;
    private CustomersHelper customersHelper;
    private EditMenu editMenu;

    public FerryFoodOnlineMenu() {

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
        adminsList = new ArrayList<>();
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
//
//    public void handleChoices(int option, ArrayList<Restaurant> restaurants) {
//        //CustomersHelper customersHelper = new CustomersHelper();
//        switch (option) {
//            case 1:
//                //customerStartingMenu(restaurants);
//                //adminMenu();
//                manageOptions(restaurants);
//                break;
//            case 2:
//                //restaurantMenu(restaurants);
//                //manager();
//                break;
//            case 3:
//                //deliverManMenu(restaurants);
//                //customerMenu();
//                break;
////            case 4:
////                sortOptions(restaurants);
////                manageOptions(restaurants);
////                break;
//            case 4:
//                System.exit(0);
//                break;
//            default:
//                System.out.println("Wrong Input");
//                manageOptions(restaurants);
//        }
//    }

    public void customerMenu(Customer customer) {
        customersHelper.manageCustomerOrders(restaurants, orders);//TODO:check if you nedd to add new menu for this in this class  
        customersHelper.showCustomerOrderHistory(customers);
    }

    public void manager(Manager manager) {
        Restaurant restaurant = WrapperRestaurant.chooseRestaurant(restaurants);
        WrapperRestaurant.update(restaurants);
        restaurant.showOrderHistory();
        MangeDeliverMan.printDeliverMen(deliverMEN);
        restaurant.showComments();
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
                WrapperRestaurant.add(restaurants);
                restaurantMenu(restaurants);
                break;
            case 2:
                WrapperRestaurant.update(restaurants);
                restaurantMenu(restaurants);
                break;
            case 3:
                WrapperRestaurant.printRestaurant(restaurants);
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
                WrapperRestaurant.sortFoodsByPrice(r);
            }
        }
        if (choice == 2) {
            for (Restaurant r : restaurants) {
                WrapperRestaurant.sortFoodsByScores(r);
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
                WrapperRestaurant.sortAscendingByComments(restaurants);
                break;
            case 2:
                WrapperRestaurant.sortDescendingByComments(restaurants);
                break;
            case 3:
                WrapperRestaurant.sortAscendingByScore(restaurants);
                break;
            case 4:
                WrapperRestaurant.sortDescendingByScore(restaurants);
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
