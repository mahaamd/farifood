package ir.ac.kntu.food;

import ir.ac.kntu.ScannerWrapper;


import java.util.ArrayList;


public class Menu {

    private ArrayList<Food> foods;

    public Menu() {
        foods = new ArrayList<>();
    }

    public Menu(ArrayList<Food> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "foods=" + foods +
                '}';
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    public void printMenu() {
        for (int i = 0; i < getFoods().size(); i++) {
            System.out.println(i);
            System.out.println(getFoods().get(i) + ":");
            System.out.println(getFoods().get(i).getComments());
        }
    }

    public void printFood() {
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(i + ":");
            System.out.println(foods.get(i));
            System.out.println(foods.get(i).getComments());
            System.out.println("================================");
        }
    }

    public void add() {
        //ArrayList<Food> newFoods = new ArrayList<>(foods);
        System.out.println("Enter Food Name");
        String name = ScannerWrapper.getInstance().nextLine();
        System.out.println("Enter Price");
        double price = Double.parseDouble(ScannerWrapper.getInstance().nextLine());
        System.out.println("Enter Score");
        Food food = new Food(name, price, Integer.parseInt(ScannerWrapper.getInstance().nextLine()));
        foods.add(food);
    }

    public void delete() {
        //ArrayList<Food> newFoods = new ArrayList<>(foods);
        printFood();
        System.out.println("Choose Food To Remove");
        int choice = ScannerWrapper.getInstance().nextInt();
        foods.remove(foods.get(choice));
    }

    public void editFood() {
        System.out.print("Choose What To Do\n" +
                "1 :Add Food To Menu\n"
                + "2 :Remove Food From Menu\n" +
                "Choose :");
        int choice;
        choice = ScannerWrapper.getInstance().nextInt();
        if (choice == 1) {
            add();
        } else if (choice == 2) {
            delete();
        }
    }

}
