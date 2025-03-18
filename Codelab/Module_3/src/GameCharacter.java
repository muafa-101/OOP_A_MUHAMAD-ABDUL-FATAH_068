public class GameCharacter {
    private String name;
    private int health;

    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getHeroName() {
        return name;
    }

    public void setHeroName(String name) {
        this.name = name;
    }

    public int getHeroHealth() {
        return health;
    }

    public void setHeroHealth(int health) {
        this.health = health;
    }

    public void attack(GameCharacter target) {
        System.out.println(this.name + " attacks " + target.getHeroName());
    }
}
