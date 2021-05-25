package ir.ac.kntu.retaurant;

import ir.ac.kntu.food.Menu;
import ir.ac.kntu.person.DeliverMan;

import java.util.ArrayList;

public class GreenGrocer extends Restaurant{

    public GreenGrocer(boolean status, String name, String address, Menu menu, ArrayList<DeliverMan> deliverMEN, ArrayList<String> comments) {
        super(status, name, address, menu, deliverMEN, comments);
    }
}
