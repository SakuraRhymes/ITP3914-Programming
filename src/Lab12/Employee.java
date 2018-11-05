package Lab12;

public class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void displayDetails() {
        System.out.println("name = " + name + " salary = " + salary);
    }

    public void raiseSalary(double percentage) {
        salary *= (1 + percentage);
    }
}