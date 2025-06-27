public class Warrior extends Fighter implements Attackable, Healable {

    public Warrior (String name) {
        super(name);
    }

    @Override
    public void attack (Fighter opponent) {
        int damage = 15 + (int) (Math.random() * 11);
        System.out.println("💥 Warrior strikes with a sword! Deals " + damage + " damage.");
        opponent.setHp(Math.max(0, opponent.getHp() - damage));
    }

    @Override
    public void heal () {
        int hp = 5 + (int) (Math.random() * 11);
        setHp(getHp() + hp);
        System.out.println("🛡 Warrior regains " + hp + " HP. Total HP: " + getHp());
    }

}
