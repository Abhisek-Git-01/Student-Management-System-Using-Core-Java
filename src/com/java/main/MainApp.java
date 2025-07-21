package com.java.main;

import com.java.model.Student;
import com.java.service.AdminService;

import java.util.Scanner;

public class MainApp {
    private static AdminService adminService = new AdminService(); // handles login/register
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Who you are? \n 1.admin \n 2.student");
        int choice = scanner.nextInt();
        if (choice == 1) {
            adminLogin();
        } else {
            studentLoginMenu();
        }
    }

    public static void studentLoginMenu() {
        System.out.print("Enter your email: \n");
        String email = scanner.next();

        System.out.print("Enter your password: ");
        String password = scanner.next();

        boolean success = adminService.login(email, password);

        if (success == true) {
            System.out.println("Login Successful");
            showStudentDashBoard();
        } else {
            System.out.println("Invalid credentials.");
            studentLoginMenu();
        }
    }

    public static void showStudentDashBoard() {
        System.out.println("\n=== Student Dashboard ===");
        System.out.println("1. Apply For Leave");
        System.out.println("2. Know Your grade");
        System.out.println("3. Leave Status");
        System.out.println("4. Subject Registration");
        System.out.println("5. Add Courses");
    }

    public static void adminLogin() {
        System.out.print("Enter your email: \n");
        String email = scanner.next();

        System.out.print("Enter your password: ");
        String password = scanner.next();

        boolean authentication = adminService.adminLogin(email, password);
        if (authentication == true) {
            System.out.print("Login Successfully");
            showAdminDashboard();
        } else {
            System.out.println("Invalid credentials");
            adminLogin();
        }
    }

    public static void showAdminDashboard() {
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n=== Admin Dashboard ===");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. View Student By Id");
                System.out.println("6. Logout");

                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Student ID: ");
                        String studentId = scanner.next();
                        System.out.print("Enter Student Name: ");
                        String studentName = scanner.next();
                        System.out.print("Enter Student Email: ");
                        String studentEmail = scanner.next();
                        System.out.print("Enter Student Password: ");
                        String password = scanner.next();
                        System.out.print("Enter Student Department: ");
                        String department = scanner.next();

                        Student s = new Student();
                        s.setStudentId(studentId);
                        s.setStudentName(studentName);
                        s.setStudentEmail(studentEmail);
                        s.setDepartment(department);
                        s.setPassword(password);

                        adminService.registerUser(s);
                    }

                    case 2 -> {
                        adminService.getAllStudent();
                    }

                    case 3 -> {
                        System.out.print("Enter student Id of student to update: ");
                        String studentId = scanner.next();
                        Student exist = adminService.getStudentById(studentId);
                        if (exist != null) {
                            System.out.println("What you want to update");
                            System.out.println("1. Update name");
                            System.out.println("2. Update email");
                            System.out.println("3. Update department");
                            System.out.println("Enter your choice");
                            int choose = scanner.nextInt();

                            switch (choose) {
                                case 1 -> {
                                    System.out.println("Enter new name:");
                                    String newName = scanner.next();
                                    exist.setStudentName(newName);
                                    adminService.updateStudent(exist);
                                }
                                case 2 -> {
                                    System.out.println("Enter new email:");
                                    String newEmail = scanner.next();
                                    exist.setStudentEmail(newEmail);
                                    adminService.updateStudent(exist);
                                }
                                case 3 -> {
                                    System.out.println("Enter new department:");
                                    String newDepartment = scanner.next();
                                    exist.setDepartment(newDepartment); // corrected this line
                                    adminService.updateStudent(exist);
                                }
                                default -> System.out.println("Invalid option.");
                            }
                        } else {
                            System.out.println("Student not found.");
                        }
                    }

                    case 4 -> {
                        System.out.print("Enter enrollment number to delete: ");
                        String id = scanner.next();
                        adminService.deleteStudentById(id);
                    }

                    case 5 -> {
                        System.out.print("Enter Student ID: ");
                        String studentId = scanner.next();
                        adminService.getStudentById(studentId);
                    }

                    case 6 -> {
                        System.out.println("Logging out...");
                        return;
                    }

                    default -> System.out.println("Invalid option.");
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
