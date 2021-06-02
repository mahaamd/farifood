package ir.ac.kntu.retaurant;


import ir.ac.kntu.Main;
import ir.ac.kntu.ScannerWrapper;
import ir.ac.kntu.ServiceBuilding;
import ir.ac.kntu.Thing;
import ir.ac.kntu.food.Food;
import ir.ac.kntu.food.Menu;

import java.util.ArrayList;

public class Edit {

//    public void changeMenu(ServiceBuilding restaurant) {
//        restaurant.getMenu().printMenu();
//        editMenu();
//        System.out.println("Choose One");
//        int choice = ScannerWrapper.getInstance().nextInt();
//        switch (choice) {
//            case 1:
//                editThingName(restaurant);
//                break;
//            case 2:
//                editThingPrice(restaurant);
//                break;
//            default:
//                System.out.println("watch input");
//                changeMenu(restaurant);
//        }
//    }
//
//    private void editMenu() {
//        System.out.println("1: Edit Menu ingredients name");
//        System.out.println("2: Edit Menu ingredients price");
//    }
//
//    private void editThingName(ServiceBuilding serviceBuilding) {
//        Main.print(serviceBuilding.getMenu().getFoods());
//        System.out.println("Choose one");
//        int choice = ScannerWrapper.getInstance().nextInt();
//        System.out.println("Enter new Name");
//        serviceBuilding.getMenu().getFoods().get(choice).setName(ScannerWrapper.getInstance().nextLine());
//    }
//
//    private void editThingPrice(ServiceBuilding serviceBuilding) {
//        Main.print(serviceBuilding.getMenu().getFoods());
//        System.out.println("Choose one");
//        int choice = ScannerWrapper.getInstance().nextInt();
//        System.out.println("Enter new price");
//        serviceBuilding.getMenu().getFoods().get(choice).setPrice(Integer.parseInt(ScannerWrapper.getInstance().nextLine()));
//    }
//
//    public void addNewMenu(ServiceBuilding restaurant) {
//        restaurant.getMenu().printMenu();
//        restaurant.setMenu(makeNewMenu());
//    }
//
//    private Menu makeNewMenu() {
//        ArrayList<Thing> foodNames = new ArrayList<>();
//        System.out.println("Enter Numbers Of Foods You Want To Add To Menu");
//        int count = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
//        while (count > 0) {
//            Food food = new Food();
//            System.out.println("Enter Name");
//            food.setName(ScannerWrapper.getInstance().nextLine());
//            System.out.println("Enter Price");
//            food.setPrice(Double.parseDouble(ScannerWrapper.getInstance().nextLine()));
//            food.setPrice((int) (5 * Math.random()));
//            food.setComments(new ArrayList<>());
//            foodNames.add(food);
//            count--;
//        }
//        Menu menu = new Menu();
//        menu.setFoods(foodNames);
//        return menu;
//    }


//    public void editFood(Menu menu) {
//        System.out.print("Choose What To Do\n" +
//                "1 :Add Food To Menu\n"
//                + "2 :Remove Food From Menu\n" +
//                "Choose :");
//        int choice;
//        choice = ScannerWrapper.getInstance().nextInt();
//        if (choice == 1) {
//            menu.add();
//        } else if (choice == 2) {
//            menu.delete();
//        }
//    }
}
