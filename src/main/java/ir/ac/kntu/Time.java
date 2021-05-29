package ir.ac.kntu;


public class Time {
    private int hour;

    public Time(int time) {
        this.hour = time;
    }

    public int getHour() {
        return hour;
    }

    @Override
    public String toString() {
        return "" + hour;
    }
}

