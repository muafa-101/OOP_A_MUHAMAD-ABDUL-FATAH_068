public class HeroClass extends GameCharacter {
    public HeroClass(String name, int health) {
        super(name, health);//for accessing the parent attribute
    }

    @Override
    public void attack(GameCharacter target) {
        //brimstone attack venom with vandal prime, damage =40 hp
        System.out.println(getHeroName() + " attacks " + target.getHeroName() + " Vandal Prime");
        int newHealth = target.getHeroHealth() - 40;
        target.setHeroHealth(newHealth);
        System.out.println(target.getHeroName() + " health: " + target.getHeroHealth());
    }
}
