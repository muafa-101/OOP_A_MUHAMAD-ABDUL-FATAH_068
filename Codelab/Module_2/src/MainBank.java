public class MainBank {
    public static void main(String[] args) {
       // //setiap objek dissimpan di tempat yang berbeda jika memakai new BankAccount, dengan disimpan di memori yang berbeda
       BankAccount account1 = new BankAccount("202410370110393", "MUHAMAD ABDUL FATAH", 1000000.0);
       BankAccount account2 = new BankAccount("202410370110031", "Malik Zaky Zahroni", 599999.0);

       //method untuk manampilkan informasi akun
       account1.displayinfo();
       account2.displayinfo();

       //method deposit yang dipanggil dari BankAccount,java
       account1.depositMoney(500000.0);
       account2.depositMoney(90000.0);
       System.out.println();//untuk new line

       //method menarik uang yang dipanggil dari BankAccount,java
       account1.withdrawMoney(700000.0);
       account2.withdrawMoney(900000.0);
       System.out.println();//untuk new line

       //method untuk manampilkan informasi akun
       account1.displayinfo();
       account2.displayinfo();
    }
}
