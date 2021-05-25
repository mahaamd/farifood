package ir.ac.kntu;


import ir.ac.kntu.person.Admin;
import ir.ac.kntu.person.Customer;
import ir.ac.kntu.person.Manager;
import ir.ac.kntu.person.User;

import java.util.ArrayList;

//enum Options {
//
//    ADMIN, LOCALE_STORES_MANAGER, CUSTOMER, EXIT, NOT_VALID
//
//}

public class PreStartTask {

    private FerryFoodOnlineMenu ferryFoodOnlineMenu;

    PreStartTask(FerryFoodOnlineMenu ferryFoodOnlineMenu) {
        this.ferryFoodOnlineMenu = ferryFoodOnlineMenu;
    }

    public void handleChoice() {//TODO: check if you can simplify this or not i mean use userValidation methd 
        User user = new User();
        ferryFoodOnlineMenu.printStartingMenu();
        int userChoice = ScannerWrapper.getInstance().nextInt();
//        FerryFoodOnlineMenu.Options
        switch (userChoice) {
            case 1:
                user = userValidation(new ArrayList<>(ferryFoodOnlineMenu.getAdminsList()));
                //user = adminValidation(ferryFoodOnlineMenu.getAdminsList());
                break;
            case 2:
                user = userValidation(new ArrayList<>(ferryFoodOnlineMenu.getManagers()));
               //user = managerValidation(ferryFoodOnlineMenu.getManagers());
                break;
            case 3:
                user = userValidation(new ArrayList<>(ferryFoodOnlineMenu.getCustomers()));
                //user = customerValidation(ferryFoodOnlineMenu.getCustomers());
                break;
            case 4:
                System.exit(0);
            default:
                break;
        }
        if (user == null) {
            System.out.println("Try again");
            handleChoice();
        }else {
            manageChoice(userChoice, user);
        }
    }

    public void manageChoice(int userChoice, User user) {
        switch (userChoice) {
            case 1:
                ferryFoodOnlineMenu.adminMenu((Admin) user);
                break;
            case 2:
                ferryFoodOnlineMenu.manager((Manager) user);
                break;
            case 3:
                ferryFoodOnlineMenu.customerMenu((Customer) user);
                break;
            default:    
        }
    }

    // private Admin adminValidation(ArrayList<Admin> adminsList) {
    //     System.out.println("Enter UserName");
    //     String userName = ScannerWrapper.getInstance().nextLine();
    //     System.out.println("Enter PassWord");
    //     String passWord = ScannerWrapper.getInstance().nextLine();
    //     for (Admin admin : adminsList) {
    //         if (admin.getUserName().equals(userName) && admin.getPassWord().equals(passWord)) {
    //             return admin;
    //         }
    //     }
    //     return null;
    // }

    // private Manager managerValidation(ArrayList<Manager> managers) {
    //     System.out.println("Enter UserName");
    //     String userName = ScannerWrapper.getInstance().nextLine();
    //     System.out.println("Enter PassWord");
    //     String passWord = ScannerWrapper.getInstance().nextLine();

    //     for (Manager manager : managers) {
    //         if (manager.getUserName().equals(userName) && manager.getPassWord().equals(passWord)) {
    //             return manager;
    //         }
    //     }
    //     return null;
    // }

    //
    // public Customer customerValidation(ArrayList<Customer> customers) {
    //     System.out.println("Enter UserName");
    //     String userName = ScannerWrapper.getInstance().nextLine();
    //     System.out.println("Enter PassWord");
    //     String passWord = ScannerWrapper.getInstance().nextLine();

    //     for (Customer customer : customers) {
    //         if (customer.getUserName().equals(userName) && customer.getPassWord().equals(passWord)) {
    //             return customer;
    //         }
    //     }
    //     return null;

    // }

   public User userValidation(ArrayList<User> users) {
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
