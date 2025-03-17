import java.util.Scanner;
public class AdminLogin_Module_2 {
    Scanner sc = new Scanner(System.in);
    String Username = "admin393";
    String Password = "admin393";



    public void LoginAdmin() {
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        if(username.equals(Username) && password.equals(Password)){
            System.out.println("Login Successful, welcome admin!");
        }
    }
}




