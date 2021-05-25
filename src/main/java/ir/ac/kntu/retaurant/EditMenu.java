package ir.ac.kntu.retaurant;


import ir.ac.kntu.ScannerWrapper;
import ir.ac.kntu.food.Food;
import ir.ac.kntu.food.Menu;

import java.util.ArrayList;

public class EditMenu {

    public void changeMenu(Restaurant restaurant) {
        restaurant.getMenu().printMenu();
        restaurant.getMenu().editFood();
    }

    public void addNewMenu(Restaurant restaurant) {
        restaurant.getMenu().printMenu();
        restaurant.setMenu(makeNewMenu());
    }

    private Menu makeNewMenu() {
        ArrayList<Food> foodNames = new ArrayList<>();
        System.out.println("Enter Numbers Of Foods You Want To Add To Menu");
        int count = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        while (count > 0) {
            Food food = new Food();
            System.out.println("Enter Name");
            food.setName(ScannerWrapper.getInstance().nextLine());
            System.out.println("Enter Price");
            food.setPrice(Double.parseDouble(ScannerWrapper.getInstance().nextLine()));
            food.setRate((int) (5 * Math.random()));
            food.setComments(new ArrayList<>());
            foodNames.add(food);
            count--;
        }
        Menu menu = new Menu();
        menu.setFoods(foodNames);
        return menu;
    }


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
