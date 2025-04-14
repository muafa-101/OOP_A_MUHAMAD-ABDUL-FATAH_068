import java.util.Scanner;
public class MainLoginSystem_Module_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//deklarasi fungsi scan
        AdminLogin_Module_2 admin = new AdminLogin_Module_2();//admin class
        StudentClass_Module_2 student = new StudentClass_Module_2();//student class
        boolean loggedIn = false;

        System.out.println("Welcome to Login System Module 2");

        while (!loggedIn) {//loop if the input is incorrect
            System.out.println("Please Select Login Type \n 1. Admin \n 2. Student \n 3. Exit");
            System.out.print("Enter your choice: ");

            int loginType = sc.nextInt();//variable for the switch
            sc.nextLine(); // remove the newline cache

            switch (loginType) {
                case 1:
                    admin.LoginAdmin();
                    break;
                case 2:
                    student.LoginStudent();
                    break;
                case 3:
                    System.out.println("Exiting the login system.");
                    loggedIn = true; // Exit the loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();//add empty line to tidy the code output
        }
        sc.close();
    }

}