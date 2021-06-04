package ir.ac.kntu;

import ir.ac.kntu.food.Order;
import ir.ac.kntu.person.*;

import ir.ac.kntu.retaurant.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
    private ArrayList<SuperMarket> superMarkets;
    private ArrayList<FruitShop> fruitShops;
    private static ArrayList<ServiceBuilding> serviceBuildings;
    private ArrayList<Share> shares;

    public FerryFoodOnlineMenu() {

    }

    public static ArrayList<ServiceBuilding> getServiceBuildings() {
        return serviceBuildings;
    }

    public static void setServiceBuildings(ArrayList<ServiceBuilding> serviceBuildings) {
        FerryFoodOnlineMenu.serviceBuildings = serviceBuildings;
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
        buildingMenuEdit(manager.getServiceBuilding());
    }


    public void customerMenu(Customer customer) throws InputMismatchException {
        System.out.println("Sign up");
        System.out.println("Login");
        try {
            int customerChoice = ScannerWrapper.getInstance().nextInt();
            if (customerChoice == 1) {
                customersHelper.makeNewCustomer(customers);
                customerMenu(customer);
            } else if (customerChoice == 2) {
                manageCustomer(customer);
                customerMenu(customer);
            } else {
                System.out.println("Wrong Input");
                customerMenu(customer);
            }
        } catch (InputMismatchException i) {
            System.out.println("Watch Your input");
            customerMenu(customer);
        }

//        SuperMarketOrder superMarketOrder = new SuperMarketOrder();
//        SuperMarketOrder.SuperMarketOrderHelper superMarketOrderHelper = superMarketOrder.new SuperMarketOrderHelper();
//        superMarketOrderHelper.makeOrder();
    }

    private void buySpecialShare(Customer customer) throws InputMismatchException {
        try {
            System.out.println("Choose One");
            Main.print(shares);
            System.out.println("Choose One");
            customer.setShare(shares.get(ScannerWrapper.getInstance().nextInt()));
        } catch (InputMismatchException i) {
            System.out.println("Wrong Input");
            buySpecialShare(customer);
        }
    }

    public void adminMenu(Admin admin) {
        System.out.println("Enter 1 For Manage FruitShops" +
                "Enter 2 For Manage superMarket" +
                "Enter 3 For Manage restaurant");
        switch (ScannerWrapper.getInstance().nextInt()) {
            case 1:
                buildingMenuEdit(ServiceBuildingWrapper.chooseServiceBuilding(fruitShops));
                break;
            case 2:
                buildingMenuEdit(ServiceBuildingWrapper.chooseServiceBuilding(superMarkets));
                break;
            case 3:
                buildingMenuEdit(ServiceBuildingWrapper.chooseServiceBuilding(restaurants));
                break;
            default:
                System.out.println("Watch your input");
                adminMenu(admin);
        }

    }

    private void manageCustomer(Customer customer) {
        //CustomersHelper customersHelper = new CustomersHelper();
        System.out.println("1: Show details");
        System.out.println("2: Update Customer info");
        System.out.println("3: Manage order");
        System.out.println("4: Buy Special Share for superMarket");
        System.out.println("5 :return");
        int choice = ScannerWrapper.getInstance().nextInt();
        switch (choice) {
            case 1:
                customer.showDetails();
                manageCustomer(customer);
                break;
            case 2:
                customersHelper.updateCustomer(customer);
                manageCustomer(customer);
                break;
            case 3:
                makeOrder(customer);
                manageCustomer(customer);
                break;
            case 4:
                buySpecialShare(customer);//TODO: Complete this menu
            case 5:
                return;
            default:
                System.out.println("Oops Try Again");
                manageCustomer(customer);
        }
    }

    private void makeOrder(Customer customer) {
        System.out.println("Super Market");
        System.out.println("Restaurant");
        System.out.println("Fruit Shop");
        System.out.println("Manage Order Status");
        int choice = ScannerWrapper.getInstance().nextInt();
        switch (choice) {
            case 1:
                customersHelper.makeSuperMarketOrder(superMarkets, customer, orders);
                makeOrder(customer);
            case 2:
                customersHelper.manageRestaurantOrders(restaurants, orders, customer);
            case 3:
                customersHelper.makeSuperMarketOrder(superMarkets, customer, orders);
            case 4:
                System.out.println(customersHelper.manageOrderStatus(orders, customer));
                break;
            default:
                System.out.println("Wrong");
                makeOrder(customer);
        }
    }

    public int printManagerMenu() {
        System.out.println("Choose What to do");
        System.out.println("1: Edit");
        System.out.println("2: Add new menu");
        System.out.println("3: Change Existing Menu");
        System.out.println("4: Show Order History");
        System.out.println("5: Print restaurant DeliverNan");
        System.out.println("6: Show restaurant Comment");
        System.out.println("7: Manage DeliverMan");
        return ScannerWrapper.getInstance().nextInt();
    }

    public void buildingMenuEdit(ServiceBuilding serviceBuilding) {
        int option = printManagerMenu();
        if (option == 1) {
            ServiceBuildingWrapper.update(serviceBuilding);
            buildingMenuEdit(serviceBuilding);
        } else if (option == 2) {
            ServiceBuildingWrapper.addNewMenu(serviceBuilding);
            buildingMenuEdit(serviceBuilding);
        } else if (option == 3) {
            ServiceBuildingWrapper.changeMenu(serviceBuilding);
            buildingMenuEdit(serviceBuilding);
        } else if (option == 4) {
            Main.print(serviceBuilding.getOrder());
            buildingMenuEdit(serviceBuilding);
        } else if (option == 5) {
            Main.print(serviceBuilding.getDeliverMEN());
            buildingMenuEdit(serviceBuilding);
        } else if (option == 6) {
            serviceBuilding.showComments();
            buildingMenuEdit(serviceBuilding);
        } else if (option == 7) {
            deliverManMenu(serviceBuilding);
        } else {
            System.out.println("wrong input");
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

    public void deliverManMenu(ServiceBuilding serviceBuilding) {
        deliverManMenuPrint();
        MangeDeliverMan mangeDeliverMan = new MangeDeliverMan();
        int option = ScannerWrapper.getInstance().nextInt();
        switch (option) {
            case 1:
                MangeDeliverMan.printDeliverMen(deliverMEN);
                deliverManMenu(serviceBuilding);
                break;
            case 2:
                mangeDeliverMan.addDeliverMan(serviceBuilding, deliverMEN);
                deliverManMenu(serviceBuilding);
                break;
            case 3:
                MangeDeliverMan.printDeliverMen(deliverMEN);
                System.out.println("Choose One DeliverMan");
                int choice = ScannerWrapper.getInstance().nextInt();
//                DeliverMan deliverMan = mangeDeliverMan.getDeliverMan(choice, deliverMEN0);
                mangeDeliverMan.update(getDeliverMan(choice));
                deliverManMenu(serviceBuilding);
                break;
            case 4:
                //manageOptions(restaurants);
            default:
                System.out.println("TRy Again");
                deliverManMenu(serviceBuilding);
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

//    public void update(ArrayList<Restaurant> restaurants) {
//        // FerryFoodOnlineMenu foodOnlineMenu = new FerryFoodOnlineMenu();
//        ServiceBuildingWrapper.printRestaurant(restaurants);
//        System.out.println("Choose Your Restaurant");
//        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
//        System.out.println("Choose What To Do");
//        ServiceBuildingWrapper.updateMenu();
//        int options = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
//        switch (options) {
//            case 1:
//                ServiceBuildingWrapper.editComment(restaurants.get(choice));
//                // foodOnlineMenu.manageOptions(restaurants);
//                break;
//            case 2:
//                restaurants.get(choice).editScore();
//                break;
//            // foodOnlineMenu.manageOptions(restaurants);
//            case 3:
//                // TODO: FIX THIS PART
//                restaurants.get(choice).getMenu().editFood();
//                // foodOnlineMenu.manageOptions(restaurants);
//                break;
//            case 4:
////                 printRestaurant(restaurants);
////                 Restaurant restaurant = chooseRestaurant(restaurants);
//                restaurants.get(choice).editName();
//                break;
//            case 5:
//                // foodOnlineMenu.manageOptions(restaurants);
//            default:
//                System.out.println("Watch Your input");
//        }
//
//    }
}
