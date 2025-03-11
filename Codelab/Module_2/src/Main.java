public class Main {
    public static void main(String[] args) {
        //setiap objek dissimpan di tempat yang berbeda jika memakai new Animal, dengan disimpan di memori yang berbeda
        Animal kucing = new Animal("Crickets", "insect", "krik-krik");
        Animal anjing = new Animal("Pig", "Mamalia", "Woof-Woof!!");

        //fungsi mengprint yang didapat dari Animal.java
        kucing.displayInfo();
        anjing.displayInfo();
    }
}