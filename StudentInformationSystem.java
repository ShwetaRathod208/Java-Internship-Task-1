package INTERNSHIP;

import java.util.Scanner;

public class StudentInformationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("\n=== STUDENT INFORMATION SYSTEM ===");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid choice! Enter again: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\n=== ADD NEW STUDENT ===");

                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    while (!ValidationUtils.validateAge(age)) {
                        System.out.print("Invalid age! Enter again: ");
                        age = sc.nextInt();
                    }

                    System.out.print("Enter Grade: ");
                    double grade = sc.nextDouble();
                    sc.nextLine();
                    while (!ValidationUtils.validateGrade(grade)) {
                        System.out.print("Invalid grade! Enter 0–100: ");
                        grade = sc.nextDouble();
                        sc.nextLine();
                    }

                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();

                    manager.addStudent(new Student(id, name, age, grade, contact));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                   
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.println("\n=== SEARCH STUDENT ===");
                    System.out.print("Enter Student ID or Name: ");
                    String key = sc.nextLine();
                    Student s = manager.searchStudent(key);

                    if (s != null) {
                        System.out.println("\nStudent Found:");
                        System.out.println(s);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.println("\n=== UPDATE STUDENT ===");
                    System.out.print("Enter Student ID: ");
                    String uid = sc.nextLine();
                    Student st = manager.searchStudent(uid);

                    if (st != null) {

                        System.out.print("Enter New Name: ");
                        st.setName(sc.nextLine());

                        System.out.print("Enter New Age: ");
                        int newAge = sc.nextInt();
                        while (!ValidationUtils.validateAge(newAge)) {
                            System.out.print("Invalid age! Enter again: ");
                            newAge = sc.nextInt();
                        }
                        st.setAge(newAge);

                        System.out.print("Enter New Grade: ");
                        double newGrade = sc.nextDouble();
                        sc.nextLine();
                        while (!ValidationUtils.validateGrade(newGrade)) {
                            System.out.print("Invalid grade! Enter 0–100: ");
                            newGrade = sc.nextDouble();
                            sc.nextLine();
                        }
                        st.setGrade(newGrade);

                        System.out.print("Enter New Contact: ");
                        st.setContact(sc.nextLine());

                        System.out.println("Student updated successfully!");

                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5:
                    System.out.println("\n=== DELETE STUDENT ===");
                    System.out.print("Enter Student ID to delete: ");
                    String did = sc.nextLine();

                    if (manager.deleteStudent(did)) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}