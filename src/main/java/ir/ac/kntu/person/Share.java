package ir.ac.kntu.person;

public class Share {

    private Integer period;
    private Integer cost;



    public Share(Integer period, Integer cost) {
        this.period = period;
        this.cost = cost;
//        oneMonth_60 = new Share(1,60);
//        threeMonth_85 = new Share(3,85);
    }

    @Override
    public String toString() {
        return "Share{" +
                "period=" + period +
                ", cost=" + cost +
                '}';
    }
}
