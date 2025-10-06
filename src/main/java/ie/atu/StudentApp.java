package ie.atu;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) {

        // initialise student array
        ArrayList<Student> students = new ArrayList<>();

        // scan yser input
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert number of students:");
        int numberOfStudents = sc.nextInt();
        sc.nextLine();
        System.out.println();


        String name = "";
        String email = "";
        String course = "";
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Insert name:");
            name = sc.nextLine().trim();
            System.out.println("Insert email:");
            email = sc.nextLine().trim().toLowerCase();
            while (isEmailDuplicate(students, email)) {
                System.out.println("Email already exists. Cannot add student.");
                System.out.println("Insert another email:");
                email = sc.nextLine().trim().toLowerCase();
            }
            System.out.println("Insert course:");
            course = sc.nextLine().trim();
            students.add(new Student(name, email, course));
            System.out.println();
        }

        // print student data
        for (Student student : students) {
            System.out.println(student);
        }

    }


    // check for duplicate
    public static boolean  isEmailDuplicate(ArrayList<Student> students, String email) {
        for (Student s : students) {
            if (s.getEmail().equals(email)) {
                return true; // Duplicate found
            }
        }
        return false; // No duplicate
    }


}
