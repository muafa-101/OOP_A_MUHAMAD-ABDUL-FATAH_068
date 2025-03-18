import java.util.Scanner;
public class MainLoginSystem_Module_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//deklarasi fungsi scan
        AdminLogin_Module_2 admin = new AdminLogin_Module_2();

        System.out.println("Welcome to Login System Module 2");
        System.out.println("Plese Select Login Type \n 1. Admin \n 2. Student");
        System.out.print("Enter your choice :");

        int loginType = sc.nextInt();
        if(loginType == 1){
            admin.LoginAdmin();
        }

    }
}