import java.util.Scanner;

public class MainLoginSystem_Module_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nPilih Login Sebagai:");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("0. Exit"); // Added option to exit
            System.out.print("Pilihan: ");
            // Input validation loop for choice
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    AdminClass_Module_3 admin = new AdminClass_Module_3(username, password);
                    admin.displayInfo();
                    if (admin.login()) {
                        int adminChoice;
                        do {
                            System.out.println("\nAdmin Menu");
                            System.out.println("1. Change username");
                            System.out.println("2. Change password");
                            System.out.println("0. Exit");
                            System.out.print("Pilihan: ");
                            // Input validation for admin menu choice
                            while (!scanner.hasNextInt()) {
                                System.out.println("Invalid input. Please enter a number.");
                                scanner.next();
                            }
                            adminChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            switch (adminChoice) {
                                case 1:
                                    System.out.print("New Username: ");
                                    String newUsername = scanner.nextLine();
                                    admin.changeUsername(newUsername);
                                    break;
                                case 2:
                                    System.out.print("New Password: ");
                                    String newPassword = scanner.nextLine();
                                    admin.changePassword(newPassword);
                                    break;
                                case 0:
                                    System.out.println("Exiting Admin Menu.");
                                    break;
                                default:
                                    System.out.println("Pilihan tidak valid.");
                            }
                        } while (adminChoice != 0);
                    }
                    break;
                case 2:
                    System.out.print("Nama: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Student ID: ");
                    String studentIdInput = scanner.nextLine();
                    StudentClass_Module_3 student = new StudentClass_Module_3(studentName, studentIdInput);
                    student.displayInfo();
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0); // Continue looping until user chooses to exit
        scanner.close();
    }
}