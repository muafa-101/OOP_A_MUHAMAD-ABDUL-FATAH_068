import java.util.Scanner;
public class AdminLogin_Module_2 {
    Scanner sc = new Scanner(System.in);
    String Admin_Username = "admin393";
    String Admin_Password = "admin393";



    public void LoginAdmin() {
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        if(username.equals(Admin_Username) && password.equals(Admin_Password)){
            System.out.println("Login Successful, welcome admin!");
        }else {System.out.println("Admin Login Failed");}
    }

}




