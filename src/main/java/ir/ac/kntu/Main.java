package ir.ac.kntu;

import ir.ac.kntu.food.Food;
import ir.ac.kntu.food.Menu;
import ir.ac.kntu.food.Order;
import ir.ac.kntu.order.OrderRange;
import ir.ac.kntu.person.*;
import ir.ac.kntu.restaurant.*;
import ir.ac.kntu.stuffs.Stuff;
import ir.ac.kntu.stuffs.StuffStatus;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        FerryFoodOnlineMenu.setServiceBuildings(new ArrayList<>());
//        Admin admin = new Admin("admin", "Admin");
        FerryFoodOnlineMenu ferryFoodOnlineMenu = new FerryFoodOnlineMenu(initializeDeliverMen(), new ArrayList<>(), initializeRestaurant());
        ferryFoodOnlineMenu.setFruitShops(initializeFruitShop());
        ferryFoodOnlineMenu.setSuperMarkets(initializeSuperMarkets());
        ferryFoodOnlineMenu.setCustomers(initializeCustomers());
        ferryFoodOnlineMenu.setShares(initializeShare());
        ferryFoodOnlineMenu.setOrderRanges(setOrderRange());
//        System.out.println(ferryFoodOnlineMenu.getOrderRanges());

        ferryFoodOnlineMenu.setManagers(initializeManger());

        ferryFoodOnlineMenu.setAdminsList(initializeAdmin());
//        PreStartTask preStartTask = new PreStartTask(ferryFoodOnlineMenu);
        ferryFoodOnlineMenu.setCustomers(initializeCustomers());
        ferryFoodOnlineMenu.chooseWhatTodo();
    }

    private static ArrayList<Admin> initializeAdmin() {
        ArrayList<Admin> admins = new ArrayList<>();
        admins.add(new Admin("12345", "12345"));
        admins.add(new Admin("7891011", "781011"));
        admins.add(new Admin("9630", "963000"));

        return admins;
    }

    public static ArrayList<OrderRange> setOrderRange() {
        ArrayList<OrderRange> orderRanges = initializeFruitShopOrderRange();
        orderRanges.addAll(initializeOrderRange());
        return orderRanges;
    }

    public static ArrayList<Restaurant> initializeRestaurant() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(true, "akbarjooje", "tehran", new Menu());
        Time[] workHours = {new Time(8), new Time(21)};
        restaurant.getMenu().setFoods(new ArrayList<>(initializeFood()[0]));
        restaurant.setWorkHours(workHours);
        restaurant.addComments("Good");
        restaurant.addComments("Good");
        restaurant.addComments("Not Bad");
        restaurant.addComments("pizza was terrible");
        restaurant.setScore(12);
        restaurant.setOrders(new ArrayList<>());
        restaurant.setDeliverMEN(initializeDeliverMen());
        restaurant.setRestaurantType(RestaurantType.MEDIUM);
        restaurants.add(restaurant);
        FerryFoodOnlineMenu.getServiceBuildings().add(restaurant);
        Restaurant restaurant1 = new Restaurant(true, "akbarjooje2", "karaj", new Menu());
        restaurant1.getMenu().setFoods(new ArrayList<>(initializeFood()[1]));
        Time[] workHours1 = {new Time(7), new Time(14), new Time(16), new Time(21)};
        restaurant1.setWorkHours(workHours1);
        restaurant1.addComments("Good");
        restaurant1.addComments("Good");
        restaurant1.addComments("Fantastic");
        restaurant1.setScore(5);
        restaurant1.setOrders(new ArrayList<>());
        restaurant1.setDeliverMEN(initializeDeliverMen());
        restaurant1.setRestaurantType(RestaurantType.ECONOMIC);
        restaurants.add(restaurant1);
        FerryFoodOnlineMenu.getServiceBuildings().add(restaurant1);
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

        steve.setCoverage(2);

        DeliverMan hossein = new DeliverMan("Honda", Salary.PER_ORDER, true,
                new ArrayList<>(), new ArrayList<>());

        hossein.setCoverage(2);

        deliverMEN.add(steve);
        deliverMEN.add(hossein);

        return deliverMEN;

    }

    public static ArrayList<Customer> initializeCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer = new Customer("093645675206", "Qom", new Order());
        Customer customer1 = new Customer("0936256402061", "Tehran", new Order());
        Customer customer2 = new Customer("09116805096", "Karaj", new Order());
        customer.setShare(new Share());
        customer1.setShare(new Share());
        customer2.setShare(new Share());
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

    public static ArrayList<Share> initializeShare() {
        ArrayList<Share> shares = new ArrayList<>();
        shares.add(new Share(1, 60));
        shares.add(new Share(2, 85));
        shares.add(new Share(3, 130));
        shares.add(new Share(6, 180));
        shares.add(new Share(12, 350));
        return shares;
    }

    public static ArrayList<SuperMarket> initializeSuperMarkets() {
        ArrayList<SuperMarket> superMarkets = new ArrayList<>();
        Time[] wokTime = {new Time(9), new Time(21)};
        SuperMarket superMarket = new SuperMarket(true, "Brother", "babol");
        superMarket.setWorkHours(wokTime);
        SuperMarket superMarket1 = new SuperMarket(true, "haji baba", "tehran");
        superMarket1.setWorkHours(wokTime);
        superMarket.setComments(initializeComments()[0]);
        superMarket.setOrder(new ArrayList<>());
        superMarket1.setOrder(new ArrayList<>());
        superMarket.setShares(initializeShare());
        superMarket1.setShares(initializeShare());
//        superMarket.setComments(new ArrayList<>());
        superMarket1.setComments(new ArrayList<>());
        ArrayList<DeliverMan> deliverMEN = new ArrayList<>();
        DeliverMan steve = new DeliverMan("Motor", Salary.PER_HOUR, true, new ArrayList<>(), new ArrayList<>());
        deliverMEN.add(steve);
        deliverMEN.get(0).setCoverage(2);
        superMarket.setDeliverMEN(deliverMEN);
        superMarket1.setDeliverMEN(deliverMEN);
        ArrayList<OrderRange> orderRange = initializeOrderRange();
        superMarket.setOrderRanges(orderRange);
        superMarket1.setOrderRanges(orderRange);
        superMarket.setMenu(new Menu(initializeStuffs()));
        superMarket1.setMenu(new Menu(initializeStuffs()));
        superMarkets.add(superMarket);
        superMarkets.add(superMarket1);
        FerryFoodOnlineMenu.getServiceBuildings().add(superMarket1);
        FerryFoodOnlineMenu.getServiceBuildings().add(superMarket);
        return superMarkets;
    }

    private static ArrayList<Thing> initializeStuffs() {

        ArrayList<Thing> things = new ArrayList<>();

        things.add(new Stuff("chips", StuffStatus.AVAILABLE, 15, 10, new ArrayList<>()));
        things.add(new Stuff("iceCream", StuffStatus.AVAILABLE, 15, 6, new ArrayList<>()));
        things.add(new Stuff("jele", StuffStatus.AVAILABLE, 15, 7, new ArrayList<>()));
        things.add(new Stuff("poshack", StuffStatus.AVAILABLE, 15, 8, new ArrayList<>()));

        return things;
    }

    private static ArrayList<OrderRange> initializeOrderRange() {
        ArrayList<OrderRange> orderRanges = new ArrayList<>();
        ArrayList<DeliverMan> deliverMEN = initializeDeliverMen();
        orderRanges.add(new OrderRange(9, 10, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(10, 11, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(11, 12, initializeDeliverMen(), 5000));
        DeliverMan steve = new DeliverMan("Motor", Salary.PER_HOUR, true,
                new ArrayList<>(), new ArrayList<>());
        deliverMEN.add(steve);
        orderRanges.add(new OrderRange(12, 13, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(13, 14, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(14, 15, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(15, 16, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(16, 17, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(17, 18, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(18, 19, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(19, 20, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(20, 21, initializeDeliverMen(), 5000));

        checkIfIncreaseOrNot(orderRanges);

        return orderRanges;
    }

    public static void checkIfIncreaseOrNot(ArrayList<OrderRange> orderRanges) {
        for (OrderRange o : orderRanges) {
            if (o.getDeliverMEN().size() >= 3) {
                o.setCost(o.getCost() * 1.5);
            }
        }
    }

    public static <T> void print(ArrayList<T> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(i);
            System.out.println(arrayList.get(i));
        }
    }


    public static ArrayList<FruitShop> initializeFruitShop() {
        Time[] times = new Time[2];
        times[0] = new Time(9);
        times[1] = new Time(22);
        ArrayList<OrderRange> orderRange = initializeFruitShopOrderRange();
        ArrayList<FruitShop> fruitShops = new ArrayList<>();
        FruitShop fruitShop = new FruitShop("hamid", "Tehran", true);
        fruitShop.setWorkHours(times);
        FruitShop fruitShop1 = new FruitShop("mammad", "Babol", true);
        fruitShop1.setWorkHours(times);
        fruitShop.setMenu(initializeFruitShopMenu());
//        fruitShop1.setScore(9);
        fruitShop.setDeliverMEN(new ArrayList<>());
        fruitShop1.setDeliverMEN(new ArrayList<>());
        fruitShop1.setMenu(initializeFruitShopMenu());
        fruitShop.setComments(new ArrayList<>());
        fruitShop1.setComments(new ArrayList<>());
        fruitShop.setOrderRanges(orderRange);
        fruitShop1.setOrderRanges(orderRange);
        fruitShops.add(fruitShop);
        fruitShops.add(fruitShop1);
        FerryFoodOnlineMenu.getServiceBuildings().add(fruitShop1);
        FerryFoodOnlineMenu.getServiceBuildings().add(fruitShop);
        return fruitShops;
    }

    private static ArrayList<OrderRange> initializeFruitShopOrderRange() {
        ArrayList<OrderRange> orderRanges = new ArrayList<>();
        ArrayList<DeliverMan> deliverMEN = initializeDeliverMen();
        orderRanges.add(new OrderRange(9, 11, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(11, 13, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(13, 15, initializeDeliverMen(), 5000));
        DeliverMan steve = new DeliverMan("Motor", Salary.PER_HOUR, true,
                new ArrayList<>(), new ArrayList<>());
        deliverMEN.add(steve);
        orderRanges.add(new OrderRange(15, 17, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(17, 19, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(19, 21, initializeDeliverMen(), 5000));
        orderRanges.add(new OrderRange(21, 22, initializeDeliverMen(), 5000));

        return orderRanges;
    }

    private static Menu initializeFruitShopMenu() {

        Menu menu = new Menu();
        ArrayList<Thing> fruits = new ArrayList<>();
        fruits.add(new Fruit("pear", 60, new ArrayList<>(), 8, 5));
        fruits.add(new Fruit("Orange", 70, new ArrayList<>(), 10, 3));
        fruits.add(new Fruit("Water Melon", 100, new ArrayList<>(), 12, 2));
        fruits.add(new Fruit("peach", 60, new ArrayList<>(), 15, 4));

        menu.setFoods(fruits);
        return menu;
    }

    public static ArrayList<Manager> initializeManger() {
        Manager manager = new Manager();
        Manager manager1 = new Manager();
        manager.setServiceBuilding(initializeFruitShop().get(0));
        manager1.setServiceBuilding(initializeSuperMarkets().get(0));
        manager.setPassWord("1111");
        manager.setUserName("1111");
        manager1.setPassWord("2222");
        manager1.setUserName("2222");
        ArrayList<Manager> managers = new ArrayList<>();
        managers.add(manager);
        managers.add(manager1);
        return managers;
    }

}