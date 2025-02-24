import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Your Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Your Gender (M/F): ");
        String gender = sc.nextLine();
        if (gender.equalsIgnoreCase("M")) {
            gender = "Male";
        }else if (gender.equalsIgnoreCase("F")) {
            gender = "Female";
        }else System.out.println("Invalid Gender");

        System.out.print("Enter Your Birth Year: ");
        int birthYear = sc.nextInt();
        System.out.println();

        System.out.println("Personal Data: ");
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Birth Year: " + birthYear);
    }
}