package ir.ac.kntu;

import ir.ac.kntu.food.Order;
import ir.ac.kntu.person.*;

import ir.ac.kntu.retaurant.*;

import java.util.ArrayList;
import java.util.InputMismatchException;

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

    public void setManagers(ArrayList<Manager> managers) {
        this.managers = managers;
    }

    public ArrayList<Share> getShares() {
        return shares;
    }

    public void setShares(ArrayList<Share> shares) {
        this.shares = shares;
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

//    public void manageOptions(ArrayList<Restaurant> restaurants) {
//        printStartingMenu();
//        int options = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
//        handleChoices(options, restaurants);
//    }


//    public void manager(Manager manager) {
//        buildingMenuEdit(manager.getServiceBuilding());
//    }

    private void buySpecialShare(Customer customer) throws InputMismatchException {
        try {
            System.out.println("Choose One");
            Main.print(shares);
            System.out.println("Choose One");
            int option = ScannerWrapper.getInstance().nextInt();
            shares.get(option).setBought(true);
            customer.setShare(shares.get(option));
        } catch (InputMismatchException i) {
            System.out.println("Wrong Input");
            buySpecialShare(customer);
        }
    }

    public void adminMenu(Admin admin) {
        System.out.println("Enter 1 For Manage FruitShops" +
                "Enter 2 For Manage superMarket" +
                "Enter 3 For Manage restaurant");
        System.out.println("4: Manage Order Status");
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
            case 4:
                System.out.println(customersHelper.manageOrderStatus(orders));
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
        System.out.println("1: Super Market");
        System.out.println("2: Restaurant");
        System.out.println("3: Fruit Shop");
//        System.out.println("4: Manage Order Status");
        System.out.println("5: Options");
        int choice = ScannerWrapper.getInstance().nextInt();
        switch (choice) {
            case 1:
                System.out.println(customersHelper.makeSuperMarketOrder(superMarkets, customer, orders));
                makeOrder(customer);
            case 2:
                System.out.println(customersHelper.manageRestaurantOrders(restaurants, orders, customer));
                makeOrder(customer);
            case 3:
                System.out.println(customersHelper.buyFruit(customer, fruitShops, orders));
                makeOrder(customer);
//            case 4:
//                System.out.println(customersHelper.manageOrderStatus(orders, customer));
//                makeOrder(customer);
//                break;
            case 4:
                sortOptions();
                makeOrder(customer);
            default:
                System.out.println("Wrong Input");
                makeOrder(customer);
        }
    }

    public int printManagerMenu() {
        System.out.println("Choose What to do");
        System.out.println("1: Edit");
        System.out.println("2: Add new menu");
        System.out.println("3: Change Existing Menu");
        System.out.println("4: Show Order History");
        System.out.println("5: Show restaurant Comment");
        System.out.println("6: Manage DeliverMan");
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
            if (serviceBuilding.getOrder().size() == 0) {
                System.out.println("No Order");
            } else {
                Main.print(serviceBuilding.getOrder());
            }
            buildingMenuEdit(serviceBuilding);
        } else if (option == 5) {
            serviceBuilding.showComments();
            buildingMenuEdit(serviceBuilding);
        } else if (option == 6) {
            deliverManMenu(serviceBuilding);
            buildingMenuEdit(serviceBuilding);
        } else {
            System.out.println("wrong input");
        }
    }

    public void sortFoods() {
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

    public void sortServiceBuilding() {
        printSortMenu();
        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        switch (choice) {
            case 1:
                ServiceBuildingWrapper.sortAscendingByComments(restaurants);
                ServiceBuildingWrapper.sortAscendingByComments(fruitShops);
                ServiceBuildingWrapper.sortAscendingByComments(superMarkets);
                break;
            case 2:
                ServiceBuildingWrapper.sortDescendingByComments(restaurants);
                ServiceBuildingWrapper.sortDescendingByComments(fruitShops);
                ServiceBuildingWrapper.sortDescendingByComments(superMarkets);
                break;
            case 3:
                ServiceBuildingWrapper.sortAscendingByScore(restaurants);
                ServiceBuildingWrapper.sortAscendingByScore(fruitShops);
                ServiceBuildingWrapper.sortAscendingByScore(superMarkets);
                break;
            case 4:
                ServiceBuildingWrapper.sortDescendingByScore(restaurants);
                ServiceBuildingWrapper.sortDescendingByScore(fruitShops);
                ServiceBuildingWrapper.sortDescendingByScore(superMarkets);
                break;
            case 5:
                //manageOptions(restaurants);
                break;
            default:
                System.out.println("Wrong input");
                sortServiceBuilding();
        }
    }

    public void printSortMenu() {
        System.out.println("1 :sortAscendingByComments");
        System.out.println("2 :sortDescendingByComments");
        System.out.println("3 :sortAscendingByScore");
        System.out.println("4 :sortDescendingByScore");
        System.out.println("5 :return");
    }

    public void sortOptions() {
        System.out.println("Set Desire order For Restaurant(1)\n" +
                "Set Desire Order For Foods demonstration(2)\nreturn(3)");
        int choice = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        if (choice == 1) {
            sortServiceBuilding();
        }
        if (choice == 2) {
            sortFoods();
        }
    }

    public void deliverManMenu(ServiceBuilding serviceBuilding) {
        deliverManMenuPrint();
        MangeDeliverMan mangeDeliverMan = new MangeDeliverMan();
        int option = ScannerWrapper.getInstance().nextInt();
        switch (option) {
            case 1:
                serviceBuilding.printDeliverMan();
                deliverManMenu(serviceBuilding);
            case 2:
                mangeDeliverMan.addDeliverMan(serviceBuilding, deliverMEN);
                deliverManMenu(serviceBuilding);
                break;
            case 3:
                if (!serviceBuilding.printDeliverMan()) {
                    deliverManMenu(serviceBuilding);
                }
                int choice = ScannerWrapper.getInstance().nextInt();
                mangeDeliverMan.update(getDeliverMan(choice));
                deliverManMenu(serviceBuilding);
                break;
            case 4:
                return;
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

    public void chooseWhatTodo() {
        System.out.println("1: Login");
        System.out.println("2: Sign up");
        int userChoice = ScannerWrapper.getInstance().nextInt();
        switch (userChoice) {
            case 1:
                login();
                chooseWhatTodo();
            case 2:
                signUpMenu();
                chooseWhatTodo();
            default:
                System.out.println("Try Again");
                chooseWhatTodo();
        }
    }

    private void signUpMenu() {
        System.out.println("1: sign Up as a manager");
        System.out.println("2: sign up as a Customer");
        System.out.println("3: return");
        int userChoice = ScannerWrapper.getInstance().nextInt();
        switch (userChoice) {
            case 1:
                addNewManager();
                signUpMenu();
                break;
            case 2:
                customersHelper.makeNewCustomer(customers);
                signUpMenu();
                break;
            case 3:
                return;
            default:
                System.out.println("Try Again");
                signUpMenu();
        }
    }

    public void printStartingMenu() {
        System.out.println("1: Admin");
        System.out.println("2: Manager");
        System.out.println("3: Customer");
        System.out.println("4: exit");
    }

    public void login() {
        User user = new User();
        printStartingMenu();
        int userChoice = ScannerWrapper.getInstance().nextInt();
//        FerryFoodOnlineMenu.Options
        switch (userChoice) {
            case 1:
                user = userValidation(getAdminsList());
                //user = adminValidation(ferryFoodOnlineMenu.getAdminsList());
                break;
            case 2:
                user = userValidation(getManagers());
                //user = managerValidation(ferryFoodOnlineMenu.getManagers());
                break;
            case 3:
                user = userValidation(getCustomers());
                //user = customerValidation(ferryFoodOnlineMenu.getCustomers());
                break;
            case 4:
                System.exit(0);
            default:
                break;
        }
        if (user == null) {
            System.out.println("Try again");
            login();
        } else {
            manageChoice(userChoice, user);
        }
    }

    public void manageChoice(int userChoice, User user) {
//        CustomersHelper customersHelper = new CustomersHelper();
        switch (userChoice) {
            case 1:
                adminRelated(user);
//                ferryFoodOnlineMenu.adminMenu((Admin) user);
//                customersHelper.makeNewCustomer(ferryFoodOnlineMenu.getCustomers());
                manageChoice(userChoice, user);
                break;
            case 2:
//                manager((Manager) user);
                buildingMenuEdit(((Manager) user).getServiceBuilding());
                manageChoice(userChoice, user);
                break;
            case 3:
                manageCustomer((Customer) user);
                manageChoice(userChoice, user);
                break;
            default:
        }
    }

    private void adminRelated(User user) {
        printAdminMenu();
        int choice = ScannerWrapper.getInstance().nextInt();
        if (choice == 4) {
            adminMenu((Admin) user);
        } else if (choice == 1) {
            superMarkets.add((SuperMarket) ServiceBuildingWrapper.add(new SuperMarket()));
            System.out.println("add one Manager To your super market");
            addNewManager();
        } else if (choice == 2) {
            restaurants.add((Restaurant) ServiceBuildingWrapper.add(new Restaurant()));
        } else if (choice == 3) {
            fruitShops.add((FruitShop) ServiceBuildingWrapper.add(new FruitShop()));
            System.out.println("add one Manager To your super market");
            addNewManager();
        } else {
            System.out.println("Wrong");
            adminRelated(user);
        }
    }

    private void printAdminMenu() {
        System.out.println("1: Add one super market");
        System.out.println("2: Add one restaurant");
        System.out.println("3: Add one fruit shop");
//        System.out.println("4: other tasks");
    }

    private void addNewManager() {
        Manager manager = new Manager();
        System.out.println("Enter Password");
        manager.setPassWord(ScannerWrapper.getInstance().nextLine());
        System.out.println("Enter userName");
        manager.setUserName(ScannerWrapper.getInstance().nextLine());
        //manager.setOrders(new ArrayList<>());
        manager.setServiceBuilding(ServiceBuildingWrapper.chooseBuildingForYourNewManager());
        managers.add(manager);
    }


    public User userValidation(ArrayList<? extends User> users) {
        System.out.println("Enter UserName");
        String userName = ScannerWrapper.getInstance().nextLine();
        System.out.println("Enter PassWord");
        String passWord = ScannerWrapper.getInstance().nextLine();
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getPassWord().equals(passWord)) {
                return user;
            }
        }
        return null;
    }
}
