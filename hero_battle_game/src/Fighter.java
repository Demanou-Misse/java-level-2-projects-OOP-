public abstract class Fighter {

    private String name;
    private int hp;

    public Fighter(String name) {
        this.name = name;
        this.hp = 50;
    }

    public String getName () {
        return name;
    }

    public int getHp () {
        return hp;
    }

    public void setHp (int newHp) {
        hp = newHp;
    }

}
