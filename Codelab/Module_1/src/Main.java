import java.util.Scanner;//API for scan

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //scan your name
        System.out.print("Enter Your Name: ");
        String name = sc.nextLine();


        //condition for gender
        System.out.print("Enter Your Gender (M/F): ");
        String gender = sc.nextLine();
        if (gender.equalsIgnoreCase("M")) {//ignoring upper and lower case
            gender = "Male";
        }else if (gender.equalsIgnoreCase("F")) {//ignoring upper and lower case
            gender = "Female";
        }else System.out.println("Invalid Gender");//if the gender not female or male, invalid input

        //scan birth year
        System.out.print("Enter Your Birth Year: ");
        int birthYear = sc.nextInt();
        System.out.println();

        //after scan all data, print all data
        System.out.println("Personal Data: ");
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Birth Year: " + birthYear);
    }
}