public class Animal {
    //attribut string
    String name;
    String type;
    String sound;

    //Konstruktor, bagian ini dipanggil otomatis ketika obyjek baru dipanggi seperti new Animal
    public Animal(String animalName, String animalType, String animalSound) {
        name = animalName;
        type = animalType;
        sound = animalSound;
    }

    //fungsi yang akan dipanggil di Main.java
    public void displayInfo() {
        System.out.println("Nama: " + name);
        System.out.println("Jenis: " + type);
        System.out.println("Suara: " + sound);
        System.out.println();
    }
}