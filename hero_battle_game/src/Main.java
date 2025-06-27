//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        do {

            ArrayList<Fighter> fighters = new ArrayList<>();
            String nameFighter1 = " ";
            String nameFighter2 = " ";

            Warrior warrior = new Warrior("Warrior");
            Mage mage = new Mage("Mage");
            Archer archer = new Archer("Archer");
            fighters.add(warrior);
            fighters.add(mage);
            fighters.add(archer);

            System.out.println("\n=== HERO COMBAT GAME ===\n");
            System.out.println("Choose your fighter:");
            showFighters(fighters);

            while (true) {
                System.out.print("🙍‍♂️ Player 1, choose your character (1-3): ");
                String userChoice = input.nextLine().trim();
                if (userChoice.isEmpty()) System.out.println("❌ Invalid input.");
                else {
                    try {
                        int number = Integer.parseInt(userChoice);
                        switch (number) {
                            case 1:
                                System.out.println("👉 Player 1 selected: " + warrior.getName());
                                nameFighter1 = warrior.getName();
                                fighters.remove(warrior);
                                break;
                            case 2:
                                System.out.println("👉 Player 1 selected: " + mage.getName());
                                nameFighter1 = mage.getName();
                                fighters.remove(mage);
                                break;
                            case 3:
                                System.out.println("👉 Player 1 selected: " + archer.getName());
                                nameFighter1 = archer.getName();
                                fighters.remove(archer);
                                break;
                            default:
                                System.out.println("❌ Invalid input. Please make sure to enter a number between 1 and 3.");
                        }
                        if (number >= 1 && number <= 3) break;
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid input.");
                    }
                }
            }

            while (true) {
                System.out.println("\nFighters available: ");
                showFighters(fighters);
                System.out.print("🙍‍♂️ Player 2, choose your character (1-2): ");
                String userChoice = input.nextLine().trim();
                if (userChoice.isEmpty()) System.out.println("❌ Invalid input.");
                else {
                    try {
                        int number = Integer.parseInt(userChoice);
                        switch (number) {
                            case 1:
                                nameFighter2 = fighters.getFirst().getName();
                                System.out.println("👉 Player 2 selected: " + nameFighter2);
                                fighters.remove(fighters.getFirst());
                                break;
                            case 2:
                                nameFighter2 = fighters.get(1).getName();
                                System.out.println("👉 Player 2 selected: " + nameFighter2);
                                fighters.remove(fighters.get(1));
                                break;
                            default:
                                System.out.println("❌ Invalid input. Please make sure to enter a number between 1 and 3.");
                        }
                        if (number >= 1 && number <= 2) break;
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid input.");
                    }
                }
            }

            System.out.println("\n💥 Let the battle begin!\n");

            ArrayList<Fighter> newFighters = new ArrayList<>();
            newFighters.add(new Warrior("Warrior"));
            newFighters.add(new Mage("Mage"));
            newFighters.add(new Archer("Archer"));
            Fighter player1 = findFighter(newFighters, nameFighter1);
            Fighter player2 = findFighter(newFighters, nameFighter2);

            System.out.println(nameFighter1 + ": 50 HP  |  " + nameFighter2 + ": 50 HP");


            int count = 1;
            do {
                System.out.println("-".repeat(30));
                System.out.println("\n🔄 Round " + count + "\n");
                int choice1;
                int choice2;

                while (true) {
                    emoji(player1);
                    System.out.println(player1.getName() + ", choose your action:");
                    System.out.println("    1. Attack (between 10 and 25 damages)");
                    System.out.println("    2. Heal (+5 at +15 PV) but you lost your turn");
                    System.out.print("> Choice: ");
                    String userInput1 = input.nextLine().trim();
                    if (userInput1.isEmpty()) System.out.println("❌ Invalid input.");
                    else {
                        try {
                            choice1 = Integer.parseInt(userInput1);
                            switch (choice1) {
                                case 1:
                                    int damage1 = 10 + (int) (Math.random() * 16);
                                    System.out.println("\n💥 " + player1.getName() + " attacks! He deals " + damage1 + " damage.");
                                    player2.setHp(player2.getHp() - damage1);
                                    if (player2.getHp() < 0) {
                                        player2.setHp(0);
                                        System.out.println("➡ " + player2.getName() + " now has 0 HP.");
                                        break;
                                    }
                                    else System.out.println("➡ " + player2.getName() + " now has " + player2.getHp() + " HP.");

                                    while (true) {
                                        System.out.println();
                                        emoji(player2);
                                        System.out.println(player2.getName() + ", choose your action:");
                                        System.out.println("    1. Attack (between 10 and 25 damages)");
                                        System.out.println("    2. Heal (+5 at +15 PV) but you lost your turn");
                                        System.out.print("> Choice: ");
                                        String userInput2 = input.nextLine().trim();
                                        if (userInput2.isEmpty()) System.out.println("❌ Invalid input.");
                                        else {
                                            try {
                                                choice2 = Integer.parseInt(userInput2);
                                                switch (choice2) {
                                                    case 1:
                                                        int damage2 = 10 + (int) (Math.random() * 16);
                                                        System.out.println("\n💥 " + player2.getName() + " attacks! He deals " + damage2 + " damage.");
                                                        player1.setHp(player1.getHp() - damage2);
                                                        if (player1.getHp() < 0) {
                                                            player1.setHp(0);
                                                            System.out.println("➡ " + player1.getName() + " now has 0 HP.");
                                                            break;
                                                        }
                                                        else System.out.println("➡ " + player1.getName() + " now has " + player1.getHp() + " HP.");
                                                        break;
                                                    case 2:
                                                        int hp = 5 + (int) (Math.random() * 11);
                                                        System.out.println("\n🔄 " + player2.getName() + " heals for " + hp + " HP.");
                                                        player2.setHp(player2.getHp() + hp);
                                                        System.out.println(("✅ " + player2.getName() + " now has " + player2.getHp() + " HP."));
                                                        break;
                                                    default:
                                                        System.out.println("❌ Invalid input. Make sure to choose between 1 and 2.");
                                                }
                                                if (choice2 >= 1 && choice2 <= 2) break;
                                            } catch (NumberFormatException e) {
                                                System.out.println("❌ Invalid input.");
                                            }
                                        }
                                    }
                                    break;

                                case 2:
                                    int hp = 5 + (int) (Math.random() * 11);
                                    System.out.println("\n🔄 " + player1.getName() + " heals for " + hp + " HP.");
                                    player1.setHp(player1.getHp() + hp);
                                    System.out.println(("✅ " + player1.getName() + " now has " + player1.getHp() + " HP."));

                                    while (true) {
                                        System.out.println();
                                        emoji(player2);
                                        System.out.println(player2.getName() + ", choose your action:");
                                        System.out.println("    1. Attack (between 10 and 25 damages)");
                                        System.out.println("    2. Heal (+5 at +15 PV) but you lost your turn");
                                        System.out.print("> Choice: ");
                                        String userInput2 = input.nextLine().trim();
                                        if (userInput2.isEmpty()) System.out.println("❌ Invalid input.");
                                        else {
                                            try {
                                                choice2 = Integer.parseInt(userInput2);
                                                switch (choice2) {
                                                    case 1:
                                                        int damage2 = 10 + (int) (Math.random() * 16);
                                                        System.out.println("\n💥 " + player2.getName() + " attacks! He deals " + damage2 + " damage.");
                                                        player1.setHp(player1.getHp() - damage2);
                                                        if (player1.getHp() < 0) {
                                                            player1.setHp(0);
                                                            System.out.println("➡ " + player1.getName() + " now has 0 HP.");
                                                            break;
                                                        }
                                                        else System.out.println("➡ " + player1.getName() + " now has " + player1.getHp() + " HP.");
                                                        break;
                                                    case 2:
                                                        int hp2 = 5 + (int) (Math.random() * 11);
                                                        System.out.println("\n🔄 " + player2.getName() + " heals for " + hp2 + " HP.");
                                                        player2.setHp(player2.getHp() + hp2);
                                                        System.out.println(("✅ " + player2.getName() + " now has " + player2.getHp() + " HP."));
                                                        break;
                                                    default:
                                                        System.out.println("❌ Invalid input. Make sure to choose between 1 and 2.");
                                                }
                                                if (choice2 >= 1 && choice2 <= 2) break;
                                            } catch (NumberFormatException e) {
                                                System.out.println("❌ Invalid input.");
                                            }
                                        }
                                    }
                                    break;

                                default:
                                    System.out.println("❌ Invalid input. Make sure to choose between 1 and 2.");
                            }
                            if (choice1 >= 1 && choice1 <= 2) break;
                        } catch (NumberFormatException e) {
                            System.out.println("❌ Invalid input.");
                        }
                    }
                }

                count++;
            } while (player1.getHp() > 0 && player2.getHp() > 0);

            System.out.println("\n✨ Summary:\n");
            System.out.println("    👉 Number of HP for " + player1.getName() + " is: " + player1.getHp());
            System.out.println("    👉 Number of HP for " + player2.getName() + " is: " + player2.getHp() + "\n");

            System.out.println("=".repeat(40));
            if (player1.getHp() > player2.getHp()) {
                System.out.println("💀 " + player2.getName() + " has fallen!");
                System.out.println("🏆 Victory for the " + player1.getName() + "!");
            } else if (player1.getHp() < player2.getHp()) {
                System.out.println("💀 " + player1.getName() + " has fallen!");
                System.out.println("🏆 Victory for the " + player2.getName() + "!");
            } else {
                System.out.println("🏆 Victory for " + player1.getName() + " and " + player2.getName() + "!");
            }
            System.out.println("=".repeat(40));

            while (true) {
                System.out.print("\n😊 Do you want to play again? (yes/no) : ");
                choice = input.nextLine().trim();
                if (choice.isEmpty()) System.out.println("❌ Invalid input.");
                else {
                    if (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {
                        System.out.println("❌ Invalid input. Please make sure to enter 'yes' or 'no'. ");
                    } else break;
                }
            }

        } while (choice.equalsIgnoreCase("yes"));

        System.out.println("\n👋 Thanks for testing our Java Project.");

    }

    public static void showFighters (ArrayList<Fighter> fighters) {
        for (int i = 0; i < fighters.size(); i++) {
            System.out.println((i + 1) + ". " + fighters.get(i).getName());
        }
        System.out.println();
    }

    public static Fighter findFighter (ArrayList<Fighter> newFighters, String nameFighter1) {
        for (Fighter fighter : newFighters) {
            if (fighter.getName().equalsIgnoreCase(nameFighter1)) {
                return fighter;
            }
        }
        return null;
    }

    public static void emoji (Fighter fighter) {
        if (fighter instanceof Warrior) System.out.print("🛡 ");
        else if (fighter instanceof Mage) System.out.print("🧙‍♂️ ");
        else System.out.print("🏹 ");
    }

}