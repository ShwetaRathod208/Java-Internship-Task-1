package INTERNSHIP;

import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("=== ALL STUDENTS ===");
        System.out.println("Student ID\tName\t\tAge\tGrade\tContact");
        System.out.println("----------------------------------------------------------------------");

        for (Student s : students) {
            System.out.println(s);
        }
    }



    public Student searchStudent(String keyword) {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(keyword) ||
                s.getName().equalsIgnoreCase(keyword)) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(String studentId) {
        Student s = searchStudent(studentId);
        if (s != null) {
            students.remove(s);
            return true;
        }
        return false;
    }
}


