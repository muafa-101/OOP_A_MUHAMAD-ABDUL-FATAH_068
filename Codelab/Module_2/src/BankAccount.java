public class BankAccount {
    //atribut instance
    String accountNumber;
    String ownerName;
    Double balance;

    //parameter konstuktor, jika nama instance sama dengan nama parameter konstuktor maka memakai this dari class BankAccount
    public BankAccount(String accountNumber, String ownerName, Double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void displayinfo(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Balance: " + balance);
        System.out.println();
    }

    public void depositMoney(double amount){
        balance += amount;
        System.out.println(ownerName + " menyetor Rp" + amount + ". Saldo sekarang " + balance );
    }

    public void withdrawMoney(double amount){
        if(balance >= amount){
            balance -= amount;
            System.out.println(ownerName + " menarik " + amount + ".(Berhasil) Saldo sekarang Rp" + balance );
        }else if(balance < amount){
            System.out.println(ownerName + " menarik " + amount + ".(Gagal) Saldo sekarang Rp" + balance );
        }else {
            System.out.println("Invalid input");
        }
    }

}
