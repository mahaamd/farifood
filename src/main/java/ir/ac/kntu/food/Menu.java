package ir.ac.kntu.food;

import ir.ac.kntu.ScannerWrapper;
import ir.ac.kntu.Thing;


import java.util.ArrayList;


public class Menu {

    private ArrayList<Thing> things;
    //private ArrayList<Commodity> commodities;

    public Menu() {
        things = new ArrayList<>();
    }

    public Menu(ArrayList<Thing> things) {
        this.things = things;
    }

//    @Override
//    public String toString() {
//        return "Menu{" +
//                "foods=" + foods +
//                '}';
//    }


    @Override
    public String toString() {
        return "Menu{" +
                "things=" + things +
                '}';
    }

    public void setFoods(ArrayList<Thing> things) {
        this.things = things;
    }

    public ArrayList<Thing> getFoods() {
        return new ArrayList<>(things);
    }

    public void printMenu() {
        for (int i = 0; i < getFoods().size(); i++) {
            System.out.println(i);
            System.out.println(getFoods().get(i) + ":");
            System.out.println(getFoods().get(i).getComments());
        }
    }

    public void printFood() {
        for (int i = 0; i < things.size(); i++) {
            System.out.println(i + ":");
            System.out.println(things.get(i));
            System.out.println(things.get(i).getComments());
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
        things.add(food);
    }

    public void delete() {
        //ArrayList<Food> newthings = new ArrayList<>(things);
        printFood();
        System.out.println("Choose Food To Remove");
        int choice = ScannerWrapper.getInstance().nextInt();
        things.remove(things.get(choice));
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

    public void remove(Thing th) {
        things.remove(th);
    }
}
