public class GameCharacter {
    private String name;
    private int health;

    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String setName() {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int setHealth(int health) {
        this.health = health;
    }

    public int gethealth() {
        return health;
    }

    public void attack(GameCharacter target) {

    }
}
