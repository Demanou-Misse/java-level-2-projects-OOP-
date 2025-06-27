public class Archer extends Fighter implements Attackable, Healable {

    public Archer (String name) {
        super(name);
    }

    @Override
    public void attack (Fighter opponent) {
        int damage = 8 + (int) (Math.random() * 13);
        System.out.println("🏹 Archer shoots an arrow! Deals " + damage + " damage.");
        opponent.setHp(Math.max(0, opponent.getHp() - damage));
    }

    @Override
    public void heal () {
        int hp = 5 + (int) (Math.random() * 11);
        setHp(getHp() + hp);
        System.out.println("🏹 Archer recovers " + hp + " HP. Total HP: " + getHp());
    }

}
