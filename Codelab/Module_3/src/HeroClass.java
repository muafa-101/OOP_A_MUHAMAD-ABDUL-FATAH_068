public class HeroClass extends GameCharacter {
    public HeroClass(String name, int health) {
        super(name, health);//for accessing the parent attribute
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(getHeroName() + " attacks " + target.getHeroName() + " using a sword!");
        int newHealth = target.getHeroHealth() - 20;
        target.setHeroHealth(newHealth);
        System.out.println(target.getHeroHealth() + "'s latest health: " + target.getHeroHealth());
    }
}
