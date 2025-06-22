//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private static Holder findHolder (ArrayList <Holder> holders, long id) {
        for (Holder holder : holders) {
            if (holder.getId() == id) return holder;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Holder> holders = new ArrayList<>();
        int choice;

        System.out.println("\n😊 Welcome to your Bank Account Manager!");
        System.out.println("*".repeat(40));

        do {
            System.out.println("\n=== BANK MENU ===");
            System.out.println("    1. Create a new account");
            System.out.println("    2. Show account balance");
            System.out.println("    3. Deposit money");
            System.out.println("    4. Withdraw money");
            System.out.println("    5. Show account information");
            System.out.println("    6. Exit");

            while (true) {
                try {
                    System.out.print("> Choice: ");
                    choice = Integer.parseInt(input.nextLine().trim());
                    if (choice >= 1 && choice <= 6) break;
                    else System.out.println("❌ Invalid input. Enter a number between 1 and 6.");
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input.");
                }
            }

            switch (choice) {

                case 1:
                    while (true) {
                        System.out.print("\n👉 Enter an account ID: ");
                        String userInput = input.nextLine().trim();
                        if (userInput.isEmpty()) {
                            System.out.println("❌ Invalid input.");
                        } else {
                            try {
                                long id = Long.parseLong(userInput);

                                // Check if ID already exists
                                if (findHolder(holders, id) != null) {
                                    System.out.println("❌ This ID is already used.");
                                    break;
                                }

                                while (true) {
                                    System.out.print("👉 Enter the account holder's name: ");
                                    String name = input.nextLine().trim();
                                    if (name.isEmpty()) System.out.println("❌ Invalid input.");
                                    else {
                                        holders.add(new Holder(name, id));
                                        System.out.println("✅ Account successfully created!");
                                        break;
                                    }
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("❌ Invalid input.");
                            }
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.print("\n👉 Enter an account ID: ");
                        String userInput = input.nextLine().trim();
                        if (userInput.isEmpty()) System.out.println("❌ Invalid input.");
                        else {
                            try {
                                long id = Long.parseLong(userInput);
                                Holder foundHolder = findHolder(holders, id);
                                if (foundHolder != null) {
                                    foundHolder.accountBalance();
                                } else {
                                    System.out.println("❌ Holder not found.");
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("❌ Invalid input.");
                            }
                        }
                    }
                    break;

                case 3:
                    while (true) {
                        System.out.print("\n👉 Enter an account ID: ");
                        String userInput = input.nextLine().trim();
                        if (userInput.isEmpty()) System.out.println("❌ Invalid input.");
                        else {
                            try {
                                long id = Long.parseLong(userInput);
                                Holder foundHolder = findHolder(holders, id);
                                if (foundHolder != null) {
                                    while (true) {
                                        System.out.print("👉 Enter the amount to deposit: ");
                                        String amountInput = input.nextLine().trim();
                                        if (amountInput.isEmpty()) System.out.println("❌ Invalid input.");
                                        else {
                                            try {
                                                double amountToDeposit = Double.parseDouble(amountInput);
                                                foundHolder.depositMoney(amountToDeposit);
                                            } catch (NumberFormatException e) {
                                                System.out.println("❌ Invalid input.");
                                            }
                                            break;
                                        }
                                    }
                                } else {
                                    System.out.println("❌ Holder not found.");
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("❌ Invalid input.");
                            }
                        }
                    }
                    break;

                case 4:
                    while (true) {
                        System.out.print("\n👉 Enter an account ID: ");
                        String userInput = input.nextLine().trim();
                        if (userInput.isEmpty()) System.out.println("❌ Invalid input.");
                        else {
                            try {
                                long id = Long.parseLong(userInput);
                                Holder foundHolder = findHolder(holders, id);
                                if (foundHolder != null) {
                                    while (true) {
                                        System.out.print("👉 Enter the amount to withdraw: ");
                                        String amountInput = input.nextLine().trim();
                                        if (amountInput.isEmpty()) System.out.println("❌ Invalid input.");
                                        else {
                                            try {
                                                double amountToWithdraw = Double.parseDouble(amountInput);
                                                foundHolder.withdrawMoney(amountToWithdraw);
                                            } catch (NumberFormatException e) {
                                                System.out.println("❌ Invalid input.");
                                            }
                                            break;
                                        }
                                    }
                                } else {
                                    System.out.println("❌ Holder not found.");
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("❌ Invalid input.");
                            }
                        }
                    }
                    break;

                case 5:
                    while (true) {
                        System.out.print("\n👉 Enter an account ID: ");
                        String userInput = input.nextLine().trim();
                        if (userInput.isEmpty()) System.out.println("❌ Invalid input.");
                        else {
                            try {
                                long id = Long.parseLong(userInput);
                                Holder foundHolder = findHolder(holders, id);
                                if (foundHolder != null) {
                                    foundHolder.accountInformation();
                                } else {
                                    System.out.println("❌ Holder not found.");
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("❌ Invalid input.");
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("\n👋 Thank you for using our bank management system. See you next time!");
                    break;
            }

        } while (choice != 6);

        input.close();

    }
}