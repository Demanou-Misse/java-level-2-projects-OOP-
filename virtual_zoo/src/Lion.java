public class Lion extends Animal {
    public Lion(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("🦁 " + getName() + " the Lion says: Roaaaar!");
    }
}
