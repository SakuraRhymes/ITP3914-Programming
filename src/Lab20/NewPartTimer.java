package Lab20;

public class NewPartTimer extends PartTimer {
    protected int mpf;
    protected double mpfRate;

    protected void calculateMpf() {
        if (super.salary >= 6500) {
            mpf = (int) (super.salary * (mpfRate / 100));
            if (mpf > 1250)
                mpf = 1250;
            super.salary = super.salary - mpf;
        } else
            mpf = 0;
    }

    public NewPartTimer(String name, int employeeID, int workingHour, int hourlyRate, double mpfRate) {
        super(name, employeeID, workingHour, hourlyRate);
        this.mpfRate = mpfRate;
        calculateMpf();
    }

    public String toString() {
        return super.toString() + ", MPF Rate: " + mpfRate + "%, MPF: " + mpf;
    }
}