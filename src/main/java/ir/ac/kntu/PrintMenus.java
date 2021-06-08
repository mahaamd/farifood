package ir.ac.kntu;

public class PrintMenus {

    public int printManagerMenu() {
        System.out.println("Choose What to do");
        System.out.println("1: Edit");
        System.out.println("2: Change Existing Menu");
        System.out.println("3: Show Order History");
        System.out.println("4: Show restaurant Comment");
        System.out.println("5: Manage DeliverMan");
        return ScannerWrapper.getInstance().nextInt();
    }

    public void printSortMenu() {
        System.out.println("1 :sortAscendingByComments");
        System.out.println("2 :sortDescendingByComments");
        System.out.println("3 :sortAscendingByScore");
        System.out.println("4 :sortDescendingByScore");
        System.out.println("5 :return");
    }

    public void deliverManMenuPrint() {
        System.out.println("1: Print Existing DeliverMen");
        System.out.println("2: Create New DeliverMan");
        System.out.println("3: Update DeliverMen Info");
        System.out.println("4: return");
    }

    public void printStartingMenu() {
        System.out.println("1: Admin");
        System.out.println("2: Manager");
        System.out.println("3: Customer");
        System.out.println("4: exit");
    }

    public void printAdminMenu() {
        System.out.println("1: Add one super market");
        System.out.println("2: Add one restaurant");
        System.out.println("3: Add one fruit shop");
        System.out.println("4: other Works");
        System.out.println("5 Return");
    }

    public void signUpMenu() {
        System.out.println("1: sign up as a Customer");
        System.out.println("2: return");
    }

    public void printAdminMenu0() {
        System.out.println("Enter 1 For Manage FruitShops\n" +
                "Enter 2 For Manage superMarket\n" +
                "Enter 3 For Manage restaurant");
        System.out.println("Enter 4: Manage Order Status");
        System.out.println("Enter 5: print Stores");
        System.out.println("6: Print DeliverMan");
        System.out.println("Enter 7: return");
    }

    public void manageCustomerMenu() {
        System.out.println("1: Show details");
        System.out.println("2: Update Customer info");
        System.out.println("3: Make order");
        System.out.println("4: Buy Special Share for superMarket");
        System.out.println("5: Print Most Popular OrderRange");
        System.out.println("6 :return");

    }

    public void printMakeOrderMenu() {
        System.out.println("1: Super Market");
        System.out.println("2: Restaurant");
        System.out.println("3: Fruit Shop");
        System.out.println("4: Options");
        System.out.println("5: return");
    }

    public void updateMenu() {
        System.out.println("1: Edit Comment");
        System.out.println("2: Edit Scores");
        System.out.println("3: Edit Menus");
        System.out.println("4: Edit Name");
        System.out.println("5: return");
    }
}
