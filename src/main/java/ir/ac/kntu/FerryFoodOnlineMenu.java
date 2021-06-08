package ir.ac.kntu;

import ir.ac.kntu.food.Order;
import ir.ac.kntu.order.OrderRange;
import ir.ac.kntu.person.*;
import ir.ac.kntu.person.CustomersHelper;
import ir.ac.kntu.restaurant.*;
import ir.ac.kntu.restaurant.ServiceBuildingWrapper;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class FerryFoodOnlineMenu {

    private static ArrayList<ServiceBuilding> serviceBuildings;
    private ArrayList<Manager> managers;
    private ArrayList<Fruit> fruits;
    private ArrayList<Restaurant> restaurants;
    private ArrayList<Admin> adminsList;
    private ArrayList<Customer> customers;
    private ArrayList<DeliverMan> deliverMEN;
    private ArrayList<Order> orders;
    private CustomersHelper customersHelper;
    private ArrayList<SuperMarket> superMarkets;
    private ArrayList<FruitShop> fruitShops;
    private ArrayList<Share> shares;
    private ArrayList<OrderRange> orderRanges;
    private PrintMenus printMenus;

    public ArrayList<OrderRange> getOrderRanges() {
        return orderRanges;
    }

    public void setOrderRanges(ArrayList<OrderRange> orderRanges) {
        this.orderRanges = orderRanges;
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
        this.restaurants = restaurants;
        this.printMenus = new PrintMenus();
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    private void buySpecialShare(Customer customer) throws InputMismatchException, NullPointerException {
        try {
//            System.out.println("Choose One");
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
        printMenus.printAdminMenu0();
        switch (ir.ac.kntu.ScannerWrapper.getInstance().nextInt()) {
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
        printMenus.manageCustomerMenu();
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
                break;
            case 5:
                customersHelper.MostPopularOrderRanges(orderRanges);
                break;
            case 6:
                break;
            default:
                System.out.println("Oops Try Again");
                manageCustomer(customer);
        }
    }

    private void makeOrder(Customer customer) {
        printMenus.printMakeOrderMenu();
        int choice = ScannerWrapper.getInstance().nextInt();
        switch (choice) {
            case 1:
                System.out.println(customersHelper.makeSuperMarketOrder(superMarkets, customer, orders));
                makeOrder(customer);
                break;
            case 2:
                System.out.println(customersHelper.manageRestaurantOrders(restaurants, orders, customer));
                makeOrder(customer);
                break;
            case 3:
                System.out.println(customersHelper.buyFruit(customer, fruitShops, orders));
                makeOrder(customer);
                break;
            case 4:
                sortOptions();
                makeOrder(customer);
                break;
            case 5:
                return;
            default:
                System.out.println("Wrong Input");
                makeOrder(customer);
        }
    }

    public void buildingMenuEdit(ServiceBuilding serviceBuilding) {
        int option = printMenus.printManagerMenu();
        if (option == 1) {
            printMenus.updateMenu();
            ServiceBuildingWrapper.update(serviceBuilding);
            buildingMenuEdit(serviceBuilding);
        } else if (option == 2) {
            ServiceBuildingWrapper.changeMenu(serviceBuilding);
            buildingMenuEdit(serviceBuilding);
        } else if (option == 3) {
            if (serviceBuilding.getOrder().size() == 0) {
                System.out.println("No Order");
            } else {
                Main.print(serviceBuilding.getOrder());
            }
            buildingMenuEdit(serviceBuilding);
        } else if (option == 4) {
            serviceBuilding.showComments();
            buildingMenuEdit(serviceBuilding);
        } else if (option == 5) {
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
        printMenus.printSortMenu();
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


    public void sortOptions() {
        System.out.println("Set Desire order For buildings(1)\n" +
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
        printMenus.deliverManMenuPrint();
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
        printMenus.signUpMenu();
        int userChoice = ScannerWrapper.getInstance().nextInt();
        switch (userChoice) {
            case 1:
                customersHelper.makeNewCustomer(customers);
                signUpMenu();
                break;
            case 2:
                return;
            default:
                System.out.println("Try Again");
                signUpMenu();
        }
    }

//    private ServiceBuilding chooseSuperMarketOrSuperMarket() {
//        System.out.println("Choose");
//    }


    public void login() {
        User user = new User();
        printMenus.printStartingMenu();
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
        printMenus.printAdminMenu();
        int choice = ScannerWrapper.getInstance().nextInt();
        if (choice == 4) {
            adminMenu((Admin) user);
        } else if (choice == 1) {
            SuperMarket superMarket =(SuperMarket) ServiceBuildingWrapper.add(new SuperMarket());
            superMarkets.add(superMarket);
            System.out.println("Hire one Manager for your super market");
            addNewManager(superMarket);
        } else if (choice == 2) {
            Restaurant restaurant = (Restaurant) ServiceBuildingWrapper.add(new Restaurant());
            restaurant.setNewRestaurantType();
            restaurants.add(restaurant);
        } else if (choice == 3) {
            FruitShop fruitShop = (FruitShop) ServiceBuildingWrapper.add(new FruitShop());
            fruitShops.add(fruitShop);
            System.out.println("Hire one Manager for your super market");
            addNewManager(fruitShop);
        } else {
            System.out.println("Wrong");
            adminRelated(user);
        }
    }

    private void addNewManager(ServiceBuilding serviceBuilding) {
        Manager manager = new Manager();
        System.out.println("Enter Password");
        manager.setPassWord(ScannerWrapper.getInstance().nextLine());
        System.out.println("Enter userName");
        manager.setUserName(ScannerWrapper.getInstance().nextLine());
        //manager.setOrders(new ArrayList<>());
        manager.setServiceBuilding(serviceBuilding);
//        manager.setServiceBuilding(ServiceBuildingWrapper.chooseBuildingForYourNewManager());
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
