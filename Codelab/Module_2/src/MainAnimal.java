public class MainAnimal {
    public static void main(String[] args) {
        //setiap objek dissimpan di tempat yang berbeda jika memakai new Animal, dengan disimpan di memori yang berbeda
        Animal Crickets = new Animal("Crickets", "insect", "krik-krik");
        Animal Pig = new Animal("Pig", "Mamalia", "Oink!!");

        //method mengprint yang didapat dari Animal.java
        Crickets.displayInfo();
        Pig.displayInfo();
    }
}