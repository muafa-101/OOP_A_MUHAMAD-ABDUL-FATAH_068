import java.util.Scanner;
public class StudentClass_Module_2 {
    Scanner sc = new Scanner(System.in);
    String Student_Username = "Muhamad Abdul Fatah";
    String Student_Password = "202410370110393";

    public void StudentData(){
        String name = "Muhamad Abdul Fatah";
        String nim = "202410370110393";
        String gender = "Male";
        String academicyear = "2024/2025";
        String email = "makandonat101@webmail.umm.ac.id";
        System.out.println("Student Data\n");
        System.out.println("Name: " + name);
        System.out.println("NIM: " + nim);
        System.out.println("Gender: " + gender);
        System.out.println("Academic year: " + academicyear);
        System.out.println("Email: " + email);
    }

    public void LoginStudent() {
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("NIM: ");
        String password = sc.nextLine();

        if(username.toLowerCase().equals(Student_Username.toLowerCase()) && password.equals(Student_Password)){
            System.out.println("Login Successful, welcome Fatah!");
            StudentData();
        }else {System.out.println("Student Login Failed");}

    }
}
