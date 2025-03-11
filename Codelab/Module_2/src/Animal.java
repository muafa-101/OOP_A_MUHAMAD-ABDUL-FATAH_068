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
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Sounds: " + sound);
        System.out.println();
    }
}