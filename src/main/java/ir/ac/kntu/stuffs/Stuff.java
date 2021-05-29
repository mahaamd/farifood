package ir.ac.kntu.stuffs;

import ir.ac.kntu.Thing;

enum StuffStatus {

    FINISHED, AVAILABLE;

}

public class Stuff extends Thing {

    private String name;
    private StuffStatus status;
    private double price;
    private Integer count;

    @Override
    public String toString() {
        return name +
                ", status=" + status +
                ", price=" + price;
    }
}
