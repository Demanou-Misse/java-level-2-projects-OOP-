import java.util.ArrayList;

public class Student {

    private String name;
    private ArrayList<Grade> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(double value) {
        grades.add(new Grade(value));
    }

    public void showGrades() {
        if (grades.isEmpty()) {
            System.out.println("   No grades yet.");
        } else {
            for (Grade g : grades) {
                g.showGrade();
            }
        }
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (Grade g : grades) {
            sum += g.getValue();
        }
        return sum / grades.size();
    }

}
