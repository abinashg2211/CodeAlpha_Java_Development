import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    double getAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return grades.size() > 0 ? (double) sum / grades.size() : 0;
    }

    int getHighest() {
        int max = Integer.MIN_VALUE;
        for (int grade : grades) {
            if (grade > max) max = grade;
        }
        return max;
    }

    int getLowest() {
        int min = Integer.MAX_VALUE;
        for (int grade : grades) {
            if (grade < min) min = grade;
        }
        return min;
    }

    void displayReport() {
        System.out.println("Student: " + name);
        System.out.println("Grades: " + grades);
        System.out.printf("Average: %.2f\n", getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
        System.out.println("------------------------");
    }
}

public class codeAlpha_task01{
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Grade Tracker ---");
            System.out.println("1. Add Student and Grades");
            System.out.println("2. Display All Reports");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayReports();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);
    }

    public static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = new Student(name);

        System.out.print("Enter number of grades: ");
        int numGrades = scanner.nextInt();

        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade #" + (i + 1) + ": ");
            int grade = scanner.nextInt();
            student.grades.add(grade);
        }

        students.add(student);
        System.out.println("Student added successfully!");
    }

    public static void displayReports() {
        if (students.isEmpty()) {
            System.out.println("No student data found.");
            return;
        }
        for (Student student : students) {
            student.displayReport();
        }
    }
}
