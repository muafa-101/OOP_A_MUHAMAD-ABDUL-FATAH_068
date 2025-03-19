public class EnemyClass extends GameCharacter{
    public EnemyClass (String name, int health) {
        super(name, health);
    }


    @Override
    public void attack(GameCharacter target) {
        //viper attack brimstone with snake venom, damage 50 hp
        System.out.println(getHeroName() + " attacks " + target.getHeroName() + " using snake venom");
        int newHealth = target.getHeroHealth() - 50;

        target.setHeroHealth(newHealth);
        System.out.println(target.getHeroName() + " Health: " + target.getHeroHealth());
    }
}
