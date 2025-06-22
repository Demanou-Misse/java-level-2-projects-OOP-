//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private static Student findStudent(ArrayList<Student> students, String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        System.out.println("\n🎓 Welcome to Student Grades Manager!\n");

        do {
            System.out.println("=== STUDENT MENU ===");
            System.out.println("    1. Create a new student");
            System.out.println("    2. Add a grade");
            System.out.println("    3. Show grades");
            System.out.println("    4. Calculate average");
            System.out.println("    5. Show all students");
            System.out.println("    6. Exit\n");

            while (true) {
                try {
                    System.out.print("👉 Choice: ");
                    choice = Integer.parseInt(input.nextLine().trim());
                    if (choice >= 1 && choice <= 6) break;
                    else System.out.println("❌ Invalid input. Please enter a number between 1 and 6.");
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input.");
                }
            }

            switch (choice) {
                case 1:
                    System.out.print("👉 Enter student name: ");
                    String name = input.nextLine().trim();
                    students.add(new Student(name));
                    System.out.println("✅ Student '" + name + "' has been created.\n");
                    break;

                case 2:
                    System.out.print("👉 Enter student name: ");
                    name = input.nextLine().trim();
                    Student foundStudent = findStudent(students, name);
                    if (foundStudent != null) {
                        try {
                            System.out.print("👉 Enter the grade to add: ");
                            double grade = Double.parseDouble(input.nextLine().trim().replace(",", "."));
                            foundStudent.addGrade(grade);
                            System.out.println("✅ Grade added to " + name + "!\n");
                        } catch (NumberFormatException e) {
                            System.out.println("❌ Invalid grade input.");
                        }
                    } else {
                        System.out.println("❌ Student not found.\n");
                    }
                    break;

                case 3:
                    System.out.print("👉 Enter student name: ");
                    name = input.nextLine().trim();
                    foundStudent = findStudent(students, name);
                    if (foundStudent != null) {
                        System.out.println("📘 Grades for " + name + ":");
                        foundStudent.showGrades();
                        System.out.println();
                    } else {
                        System.out.println("❌ Student not found.\n");
                    }
                    break;

                case 4:
                    System.out.print("👉 Enter student name: ");
                    name = input.nextLine().trim();
                    foundStudent = findStudent(students, name);
                    if (foundStudent != null) {
                        double average = foundStudent.getAverage();
                        System.out.printf("📊 Average grade for %s: %.2f\n\n", name, average);
                    } else {
                        System.out.println("❌ Student not found.\n");
                    }
                    break;

                case 5:
                    if (students.isEmpty()) {
                        System.out.println("🚫 No registered students.\n");
                    } else {
                        System.out.println("📋 Registered Students:");
                        for (Student s : students) {
                            System.out.printf(" - %s    – Average: %.2f\n",
                                    s.getName(), s.getAverage());
                        }
                        System.out.println();
                    }
                    break;

                case 6:
                    System.out.println("\n👋 Goodbye! Thanks for using Student Grades Manager.");
                    break;
            }

        } while (choice != 6);

        input.close();
    }

}