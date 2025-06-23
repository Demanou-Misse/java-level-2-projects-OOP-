//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Animal> animals = new ArrayList<>();
        int choice = 0;

        System.out.println("\n🦁 Welcome to the Virtual Zoo!");
        System.out.println("=".repeat(30));
        System.out.println("\n📦 Some animals are already living in the zoo:");

        animals.add(new Dog("Rex"));
        animals.add(new Cat("Whiskers"));
        animals.add(new Lion("Simba"));

        showAnimals(animals);

        do {
            System.out.println("\n=== ZOO MENU ===");
            System.out.println("1. Show all animals");
            System.out.println("2. Make all animals speak");
            System.out.println("3. Add a new animal");
            System.out.println("4. Remove an animal");
            System.out.println("5. Exit");

            System.out.print("\n> Choice: ");
            String inputChoice = input.nextLine().trim();

            try {
                choice = Integer.parseInt(inputChoice);
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    if (animals.isEmpty()) System.out.println("❌ No animals in the zoo.");
                    else showAnimals(animals);
                    break;

                case 2:
                    if (animals.isEmpty()) System.out.println("❌ No animals to speak.");
                    else {
                        System.out.println("\n🎤 The animals are speaking...\n");
                        for (Animal animal : animals) {
                            animal.speak();
                        }
                    }
                    break;

                case 3:
                    System.out.print("\n👉 Enter the type of animal (Dog, Cat, Lion): ");
                    String type = input.nextLine().trim().toLowerCase();

                    if (!type.equals("dog") && !type.equals("cat") && !type.equals("lion")) {
                        System.out.println("❌ Invalid animal type.");
                        break;
                    }

                    System.out.print("👉 Enter the name of the animal: ");
                    String name = input.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("❌ Name cannot be empty.");
                        break;
                    }

                    switch (type) {
                        case "dog" -> animals.add(new Dog(name));
                        case "cat" -> animals.add(new Cat(name));
                        case "lion" -> animals.add(new Lion(name));
                    }

                    System.out.println("✅ " + name + " the " + type + " has been added to the zoo!");
                    break;

                case 4:
                    if (animals.isEmpty()) {
                        System.out.println("❌ No animals to remove.");
                        break;
                    }

                    showAnimals(animals);

                    System.out.print("\n👉 Enter the number of the animal to remove: ");
                    String indexInput = input.nextLine().trim();

                    try {
                        int index = Integer.parseInt(indexInput);
                        if (index <= 0 || index > animals.size()) {
                            System.out.println("❌ Invalid number.");
                        } else {
                            Animal removed = animals.get(index - 1);
                            animals.remove(index - 1);
                            System.out.println("🗑️ " + removed.getName() + " has been removed from the zoo.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid input.");
                    }
                    break;

                case 5:
                    System.out.println("\n👋 Thank you for visiting the Virtual Zoo. See you soon!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }

        } while (choice != 5);

        input.close();
    }

    private static void showAnimals(ArrayList<Animal> animals) {
        System.out.println("\n📋 Current animals in the zoo:");
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            String icon = animal instanceof Dog ? "🐶" :
                    animal instanceof Cat ? "🐱" :
                            animal instanceof Lion ? "🦁" : "❓";
            System.out.println((i + 1) + ". " + icon + " " + animal.getClass().getSimpleName() + " — Name: " + animal.getName());
        }
    }
}