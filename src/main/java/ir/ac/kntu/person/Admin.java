package ir.ac.kntu.person;

import ir.ac.kntu.ScannerWrapper;
import ir.ac.kntu.retaurant.Restaurant;
import ir.ac.kntu.retaurant.ServiceBuildingWrapper;

import java.util.ArrayList;

public class Admin extends User {

//    private String userName;
//
//    private String passWord;


    public Admin(String userName, String passWord) {
        super.setUserName(userName);
        super.setPassWord(passWord);
    }

}
