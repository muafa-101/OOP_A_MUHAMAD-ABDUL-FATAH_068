public class GameCharacter {//atribut untuk naam hero dan jumlah hp
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

    //method target to attack agent
    public void attack(GameCharacter target) {
        System.out.println(this.name + " attacks " + target.getHeroName());
    }
}
