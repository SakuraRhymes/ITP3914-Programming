package Lab20;

public class PartTimer extends Employee {
    protected int workingHour;
    protected int hourlyRate;

    protected void calculateSalary() {
        super.salary = workingHour * hourlyRate;
    }

    public PartTimer(String name, int employeeID, int workingHour, int hourlyRate) {
        super(name, employeeID);
        if (workingHour > 220)
            this.workingHour = 0;
        else
            this.workingHour = workingHour;
        this.hourlyRate = hourlyRate;
        calculateSalary();
    }

    public String toString() {
        return super.toString() + ", Working Hour: " + workingHour + ", Hourly Rate: " + hourlyRate;
    }
}