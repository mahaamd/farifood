package ir.ac.kntu.person;

import ir.ac.kntu.ScannerWrapper;
import ir.ac.kntu.retaurant.Restaurant;
import ir.ac.kntu.retaurant.WrapperRestaurant;

import java.util.ArrayList;
import java.util.Locale;

public class MangeDeliverMan {

    public MangeDeliverMan() {

    }

    public static void printDeliverMen(ArrayList<DeliverMan> deliverMEN) {
        for (int i = 0; i < deliverMEN.size(); i++) {
            System.out.println("DeliverMan " + i + " Is");
            System.out.println(deliverMEN.get(i));
            if (deliverMEN.get(i).isAccessible()) {
                System.out.println("Accessible");
            } else {
                System.out.println("InAccessible Right Now");
            }
        }
    }

    public void addDeliverMan(ArrayList<Restaurant> restaurants, ArrayList<DeliverMan> deliverMEN) {
        DeliverMan deliverMan = new DeliverMan();
        System.out.println("Enter Desired Vehicle");
        String vehicle = ScannerWrapper.getInstance().nextLine();
        deliverMan.setVehicle(vehicle);
        System.out.println("Set Salary For DeliverMan : per hour Or per order");
        String salary = ScannerWrapper.getInstance().nextLine();
        deliverMan.setSalary(salary);
        System.out.println("Accessible Or In Accessible");
        String accessible = ScannerWrapper.getInstance().nextLine();
        deliverMan.setAccessible(accessible.toLowerCase(Locale.ROOT).equals("accessible"));
        deliverMan.setComments(new ArrayList<>());
        System.out.println("***************" + "addRestaurant" + "***************");
        System.out.println("Choose 2 Restaurant For Your DeliverMan");
        WrapperRestaurant.printRestaurant(restaurants);
        System.out.print("Restaurant number One: ");
        int choice1 = ScannerWrapper.getInstance().nextInt();
        System.out.print("Restaurant Number Two: ");
        int choice2 = ScannerWrapper.getInstance().nextInt();
        restaurants.get(choice1).addDeliverMan(deliverMan);
        restaurants.get(choice2).addDeliverMan(deliverMan);
        deliverMan.setOrders(new ArrayList<>());
        deliverMEN.add(deliverMan);
    }

    public void update(DeliverMan deliverMan) {
        //System.out.println(this);
        printUpdateMenu();
        int choice = ScannerWrapper.getInstance().nextInt();
        if (choice == 1) {
            editComment(deliverMan);
        } else if (choice == 2) {
            editSalaryType(deliverMan);
        } else if (choice == 3) {
            editScore(deliverMan);
        } else if (choice == 4) {
            editAccessibility(deliverMan);
        } else if (choice != 5) {
            System.out.println("Wrong Input");
        }
    }

    private void printUpdateMenu() {
        System.out.println(
                "1: EditComment\n" +
                        "2: Edit Salary Type\n" +
                        "3: Edit Score\n" +
                        "4: Change Accessibility\n" +
                        "5 :return");
    }


    public void editAccessibility(DeliverMan deliverMan) {
        System.out.print("Current Status:");
        if (deliverMan.isAccessible()) {
            System.out.println("Accessible");
        } else {
            System.out.println("InAccessible");
        }
        System.out.println("Change ?");
        if (ScannerWrapper.getInstance().nextLine().equals("yes")) {
            deliverMan.setAccessible(!deliverMan.isAccessible());
        }
    }

    public void editSalaryType(DeliverMan deliverMan) {
        System.out.print("CurrentSalaryType: " + deliverMan.getSalary());
        System.out.println(" Change?");
        if (ScannerWrapper.getInstance().nextLine().equals("yes")) {
            switch (deliverMan.getSalary()) {
                case PER_HOUR:
                    deliverMan.setSalary(Salary.PER_ORDER);
                case PER_ORDER:
                    deliverMan.setSalary(Salary.PER_HOUR);
                default:

            }
        }
    }

    public void editScore(DeliverMan deliverMan) {
        System.out.println("Current Score: " + deliverMan.getScore());
        System.out.print("Enter New Score: ");
        deliverMan.setScore(Integer.parseInt(ScannerWrapper.getInstance().nextLine()));
    }

    public void editComment(DeliverMan deliverMan) {
        if (deliverMan.getOrders().size() == 0) {
            System.out.println("Enter Comment To Add");
            deliverMan.addComment(ScannerWrapper.getInstance().nextLine());
            return;
        }
        System.out.println("Existing Comments" + deliverMan.getComments());
        System.out.println("add(1) / delete(2)");
        int option = ScannerWrapper.getInstance().nextInt();
        if (option == 1) {
            System.out.println("Enter Comment");
            String comment = ScannerWrapper.getInstance().nextLine();
            deliverMan.addComment(comment);
        } else if (option == 2) {
            delete(deliverMan);
        }
    }

    private void delete(DeliverMan deliverMan) {
        printComment(deliverMan);
        System.out.println("Choose Comment Number");
        try {
            deliverMan.getComments().remove(Integer.parseInt(ScannerWrapper.getInstance().nextLine()));
        } catch (Exception e) {
            System.out.println("Watch Your Input");
            delete(deliverMan);
        }
    }

    private void printComment(DeliverMan deliverMan) {
        for (int i = 0; i < deliverMan.getComments().size(); i++) {
            System.out.println("Comment Number " + i + " Is");
            System.out.println(deliverMan.getComments().get(i));
        }
    }
}
