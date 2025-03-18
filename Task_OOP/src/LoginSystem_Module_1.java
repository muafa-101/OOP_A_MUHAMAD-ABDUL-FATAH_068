import java.util.Scanner;

public class LoginSystem_Module_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loggedin = false;//to save the return value

        while(!loggedin) {//while the loggin is not equals to false
            System.out.println("Select Login Type:");
            System.out.println("1. Admin\n2. Student");
            System.out.print("Enter Login Type: ");
            int loginchoice = sc.nextInt();
            sc.nextLine();//remove buffer from sc.nextInt()

            if(loginchoice == 1) {
                loggedin = adminLogin(sc);
            }else if(loginchoice == 2) {
                loggedin = studentLogin(sc) ;
            }
        }
    }

    //fungtion for admin login, use boolean because need to return boolean value
    public static boolean adminLogin(Scanner sc) {
        //username and password input
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if(username.equals("Admin393") && password.equals("Password393")) {
            System.out.println("Admin Login Successful");
            return true;//if true the lopping end
        }else{
            System.out.println("Admin Login Unsuccessful, Check Your Username and Password\n");
            return false;//if false the lopping countinue
        }
    }

    //fungtion for student login, use boolean because need to return boolean value
    public static boolean studentLogin(Scanner sc) {
        //username and password input
        System.out.print("Enter Your Name: ");
        String studentname = sc.nextLine();
        System.out.print("Enter Your Student's ID: ");
        String studentid = sc.nextLine();

        if(studentname.equals("MUHAMAD ABDUL FATAH") && studentid.equals("202410370110393")) {
            System.out.println("Student Login Successful");
            return true;//if true the lopping end
        }else{
            System.out.println("Student Login Unsuccessful, Check Your Name And Student ID\n");
            return false;//if false the lopping countinue
        }
    }

}