package ir.ac.kntu.person;

import ir.ac.kntu.ServiceBuilding;
import ir.ac.kntu.retaurant.Restaurant;

public class Manager extends User {

    private ServiceBuilding serviceBuilding;

    public Manager(String userName, String passWord) {
        super(userName, passWord);
    }

    public void setServiceBuilding(ServiceBuilding serviceBuilding) {
        this.serviceBuilding = serviceBuilding;
    }

    public ServiceBuilding getServiceBuilding() {
        return serviceBuilding;
    }
}
