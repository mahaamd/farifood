package ir.ac.kntu.person;

public enum Salary {
    PER_ORDER(30),
    PER_HOUR(15);

    private final int salary;

    Salary(int salary) {
        this.salary = salary;
    }

}
