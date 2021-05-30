package ir.ac.kntu.person;

import ir.ac.kntu.food.Order;

import java.util.ArrayList;

public class Customer extends User {

    private String phoneNumber;
    private String address;
    private Order orders;
    private Share share;


    public Customer(String phoneNumber, String address, Order order) {
        super();
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orders = order;
    }

    public void setShare(Share share) {
        this.share = share;
    }

    //    public Customer(String userName, String passWord) {
//        super(userName, passWord);
//    }


    public Share getShare() {
        return share;
    }

    public void addOrder(Order order) {
        if (orders == null) {
            orders = new Order();
        }
        orders = order;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setOrders(Order orders) {
        this.orders = orders;
    }

    public Order getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'';
    }

    public void printOrder() {
        for (int i = 0; i < orders.getThings().size(); i++) {// note that it Starts from one not zero
            System.out.println("Order number" + i + 1);
            System.out.println(orders.getThings().get(i));
        }
    }
}
