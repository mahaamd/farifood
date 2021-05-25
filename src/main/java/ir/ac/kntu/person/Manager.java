package ir.ac.kntu.person;

import ir.ac.kntu.retaurant.Restaurant;

public class Manager extends User {

    private Restaurant restaurant;

    public Manager(String userName, String passWord) {
        super(userName, passWord);
    }
}
