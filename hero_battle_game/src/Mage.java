public class Mage extends Fighter implements Attackable, Healable {

    public Mage (String name) {
        super(name);
    }

    @Override
    public void attack (Fighter opponent) {
        int damage = 10 + (int) (Math.random() * 16);
        System.out.println("🔮 Mage casts a spell! Deals " + damage + " damage.");
        opponent.setHp(Math.max(0, opponent.getHp() - damage));
    }

    @Override
    public void heal () {
        int hp = 5 + (int) (Math.random() * 11);
        setHp(getHp() + hp);
        System.out.println("🔮 Mage restores " + hp + " HP. Total HP: " + getHp());
    }

}
