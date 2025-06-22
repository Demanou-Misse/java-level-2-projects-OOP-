public class Grade {

    private double value;

    public Grade(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void showGrade() {
        System.out.println("    - " + value);
    }

}
