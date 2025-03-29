import java.util.Scanner;

public class MainLoginSystem_Module_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih Login Sebagai:");
        System.out.println("1. Admin");
        System.out.println("2. Siswa");
        System.out.print("Pilihan: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Membuang newline

        if (choice == 1) {
            System.out.print("Nama: ");
            String name = scanner.nextLine();
            System.out.print("ID Siswa: ");
            String nim = scanner.nextLine();
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            AdminClass_Module_3 admin = new AdminClass_Module_3(name, nim, username, password);
            admin.displayinfo(); // Perbaikan: memanggil displayinfo() pada objek admin
        } else if (choice == 2) {
            System.out.print("Nama: ");
            String name = scanner.nextLine();
            System.out.print("ID Siswa: ");
            String nim = scanner.nextLine();

            UserClass_Module_3 student = new UserClass_Module_3(name, nim);
            student.displayinfo(); // Menangani opsi Siswa
        } else {
            System.out.println("Pilihan tidak valid.");
        }
        scanner.close(); // scanner close dipindahkan ke luar if.
    }
}