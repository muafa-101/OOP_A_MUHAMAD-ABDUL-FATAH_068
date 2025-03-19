public class Main{
    public static void main(String[] args) {
        System.out.println("Initial Status");

        //konstruktor
        GameCharacter Brimestone = new HeroClass("Brimstone", 150);//brimstone - hero
        GameCharacter Viper = new EnemyClass("Viper", 200);//venom - enemy

        System.out.println("Brimestone has health: " + Brimestone.getHeroHealth() );
        System.out.println("Viper has health: " + Viper.getHeroHealth());

        //attack character
        Brimestone.attack(Viper);
        Brimestone.attack(Viper);
        Viper.attack(Brimestone);
    }
}