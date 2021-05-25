package ir.ac.kntu.person;

import ir.ac.kntu.food.Order;

import java.util.ArrayList;

public class Customer extends User {

    private String phoneNumber;

    private String address;

    private ArrayList<Order> orders;

    public Customer(String phoneNumber, String address, ArrayList<Order> orders) {
        super();
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orders = orders;
    }

    


//    public Customer(String userName, String passWord) {
//        super(userName, passWord);
//    }







    public void addOrder(Order order) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public ArrayList<Order> getOrder() {
        return new ArrayList<>(orders);
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'';
    }

    public void printOrder() {
        for (int i = 0; i < orders.size(); i++) {// note that it Starts from one not zero
            System.out.println("Order number" + i + 1);
            System.out.println(orders.get(i));
        }
    }
}
