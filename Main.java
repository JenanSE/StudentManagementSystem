package studentmanagementsystem;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        StudentService manager = new StudentService(50);

        int choice;
        do {
            System.out.println("**** Student Management System ****");
            System.out.println("1) Add Student");
            System.out.println("2) View All Students");
            System.out.println("3) Search Student by ID");
            System.out.println("4) Delete Student by ID");
            System.out.println("0) Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter ID: ");
                    int id = input.nextInt();
                    input.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter GPA: ");
                    double gpa = input.nextDouble();
                    boolean added = manager.addStudent(new Student(id, name, gpa));
                    if (added) {
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Cannot add student (Array full or ID already exists).");
                    }
                    break;
                }
                case 2:
                    manager.printAllStudents();
                    break;
                case 3: {
                    System.out.print("Enter ID to search: ");
                    int id = input.nextInt();
                    Student s = manager.searchById(id);
                    if (s == null) {
                        System.out.println("Student not found.");
                    } else {
                        System.out.println("Found: " + s);
                    }
                    break;
                }
                case 4: {
                    System.out.print("Enter ID to delete: ");
                    int id = input.nextInt();
                    boolean deleted = manager.deleteById(id);
                    if (deleted) {
                        System.out.println("Deleted successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                }
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        } while (choice != 0);

        input.close();
    }
}
