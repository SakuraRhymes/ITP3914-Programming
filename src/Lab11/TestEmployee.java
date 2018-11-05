package Lab11;

public class TestEmployee {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        int oldSalary;

        // Part 1-2 here
        emp1.setName("Chan Tai Man");
        emp1.setSalary(12000);

        emp2.setName("Tam Ping Shing");
        emp2.setSalary(13500);

        // Part 3 below
        System.out.println("Before-");
        System.out.println("Employee 1: name=" + emp1.getName() + " salary=" + emp1.getSalary());
        System.out.println("Employee 2: name=" + emp2.getName() + " salary=" + emp2.getSalary());

        // Part 4-5 here
        emp1.setSalary((int) (emp1.getSalary() * 1.1));
        emp2.setSalary((int) (emp2.getSalary() * 1.05));

        System.out.println("After-");
        System.out.println("Employee 1: name=" + emp1.getName() + " salary=" + emp1.getSalary());
        System.out.println("Employee 2: name=" + emp2.getName() + " salary=" + emp2.getSalary());
    }
}