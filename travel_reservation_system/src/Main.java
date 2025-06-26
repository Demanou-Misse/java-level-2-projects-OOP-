//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Client> clients = new ArrayList<>();
        int choice;
        int tripToParis = 5;
        int tripToNewYork =  3;
        int tripToTokyo = 2;

        System.out.println("\n😊Welcome to your 'Travel Booking System'!");
        System.out.println("*".repeat(40));

        do {

            System.out.println("\n=== TRAVEL BOOKING MENU ===");
            System.out.println("    1. Add a client");
            System.out.println("    2. Show available trips");
            System.out.println("    3. Book a trip");
            System.out.println("    4. View my bookings");
            System.out.println("    5. Cancel a booking");
            System.out.println("    6. Show all clients and their bookings");
            System.out.println("    7. Exit");

            while (true) {
                System.out.print("\n> Choice: ");
                String userInput = input.nextLine().trim();
                if (userInput.isEmpty()) System.out.println("❌ Invalid input.");
                else {
                    try {
                        choice = Integer.parseInt(userInput);
                        if (choice >= 1 && choice <= 7) break;
                        else System.out.println("❌ Invalid input");
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid input.");
                    }
                }
            }

            switch (choice) {

                case 1:

                    if (!clients.isEmpty()) {
                        while (true) {
                            System.out.print("🔹 Enter client name: ");
                            String name = input.nextLine().trim();
                            if (name.isEmpty()) System.out.println("❌ Invalid input.");
                            else {
                                boolean validInput = true;
                                for (Client client : clients) {
                                    if (client.getName().equalsIgnoreCase(name)) {
                                        System.out.println("❌ Sorry. This name already exist.");
                                        validInput = false;
                                    }
                                }
                                if (validInput) {
                                    clients.add(new Client(name));
                                    System.out.println("✅ Client \"" + name + "\" added successfully.");
                                }
                                break;
                            }
                        }
                    } else {
                        while (true) {
                            System.out.print("🔹 Enter client name: ");
                            String name = input.nextLine().trim();
                            if (name.isEmpty()) System.out.println("❌ Invalid input.");
                            else {
                                clients.add(new Client(name));
                                System.out.println("✅ Client \"" + name + "\" added successfully.");
                                break;
                            }
                        }
                    }
                    break;

                case 2:
                    showAvailableTrips(tripToParis, tripToNewYork, tripToTokyo);
                    break;

                case 3:

                    if (clients.isEmpty()) {
                        System.out.println("❌ No Client found.");
                        break;
                    }
                    showAvailableTrips(tripToParis, tripToNewYork, tripToTokyo);
                    System.out.println("\n✈ Book a Trip");
                    while (true) {
                        System.out.print("Client name: ");
                        String name = input.nextLine().trim();
                        if (name.isEmpty()) System.out.println("❌ Invalid input.");
                        else {
                            Client foundClient = findClient(clients, name);
                            if (foundClient == null) {
                                System.out.println("❌ No Client found.");
                            }
                            else {
                                while (true) {
                                    System.out.print("Trip number (1-3): ");
                                    String userInput = input.nextLine().trim();
                                    if (userInput.isEmpty()) System.out.println("❌ Invalid input.");
                                    else {
                                        try {
                                            int number = Integer.parseInt(userInput);
                                            if (number <= 0 || number > 3) System.out.println("❌ Invalid input. Make sure to enter a number between 1 and 3.");
                                            else {
                                                switch (number) {
                                                    case 1:
                                                        if (foundClient.hasAlreadyBooked("Paris")) {
                                                            System.out.println("❌ You have already booked this trip.");
                                                            break;
                                                        }
                                                        if (tripToParis > 0) {
                                                            foundClient.addReservation("Paris");
                                                            System.out.println("✅ Booking confirmed for " + name + " to Paris." );
                                                            tripToParis -= 1;
                                                        } else System.out.println("❌ No seat found.");
                                                        break;
                                                    case 2:
                                                        if (foundClient.hasAlreadyBooked("New York")) {
                                                            System.out.println("❌ You have already booked this trip.");
                                                            break;
                                                        }
                                                        if (tripToNewYork > 0) {
                                                            foundClient.addReservation("New York");
                                                            System.out.println("✅ Booking confirmed for " + name + " to New York." );
                                                            tripToNewYork -= 1;
                                                        } else System.out.println("❌ No seat found.");
                                                        break;
                                                    case 3:
                                                        if (foundClient.hasAlreadyBooked("Tokyo")) {
                                                            System.out.println("❌ You have already booked this trip.");
                                                            break;
                                                        }
                                                        if (tripToTokyo > 0) {
                                                            foundClient.addReservation("Tokyo");
                                                            System.out.println("✅ Booking confirmed for " + name + " to Tokyo." );
                                                            tripToTokyo -= 1;
                                                        } else System.out.println("❌ No seat found.");
                                                        break;
                                                }
                                                break;
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("❌ Invalid input.");
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    }
                    break;

                case 4:

                    if (clients.isEmpty()) {
                        System.out.println("❌ No client found.");
                        break;
                    }

                    System.out.println("\n🙍‍♂️ View Bookings");
                    while (true) {
                        System.out.print("Enter client name: ");
                        String name = input.nextLine().trim();
                        if (name.isEmpty()) System.out.println("❌ Invalid input.");
                        else {
                            Client foundClient = findClient(clients, name);
                            if (foundClient == null) {
                                System.out.println("❌ No client found.");
                            }
                            else {
                                System.out.println("📒 Bookings for " + name + ":");
                                foundClient.showReservation();
                            }
                            break;
                        }
                    }
                    break;

                case 5:

                    if (clients.isEmpty()) {
                        System.out.println("❌ No client found.");
                        break;
                    }

                    System.out.println("\n🗑 Cancel a Booking");
                    while (true) {
                        System.out.print("Enter client name: ");
                        String name = input.nextLine().trim();
                        if (name.isEmpty()) System.out.println("❌ Invalid input.");
                        else {
                            Client foundClient = findClient(clients, name);
                            if (foundClient == null) {
                                System.out.println("    ❌ No client found.");
                            } else {
                                foundClient.showReservation();
                                while (true) {
                                    System.out.print("\n👉 Trip name to cancel: ");
                                    String nameTrip = input.nextLine().trim().toLowerCase();
                                    if (nameTrip.isEmpty()) System.out.println("❌ Invalid input.");
                                    else {
                                        boolean success = foundClient.cancelReservation(nameTrip);
                                        if (success) {
                                            switch (nameTrip) {
                                                case "paris": tripToParis += 1; break;
                                                case "new york": tripToNewYork += 1; break;
                                                case "tokyo": tripToTokyo += 1; break;
                                                default: System.out.println("⚠️ Trip name not recognized.");
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                    break;

                case 6:

                    if (clients.isEmpty()) {
                        System.out.println("❌ No client found.");
                        break;
                    }

                    System.out.println("\n👩‍👦‍👦 All Clients and Their Bookings:");
                    for (Client client : clients) {
                        System.out.println("\n🔸 " + client.getName());
                        client.showReservation();
                    }
                    break;

                case 7:
                    System.out.println("👋 Thank you for using our travel booking system!");
                    break;

            }

        } while (choice != 7);

        input.close();

    }

    public static void showAvailableTrips (int tripToParis, int tripToNewYork, int tripToTokyo) {
        System.out.println("📋 Available trips:");
        System.out.println("1. Paris FR – " + tripToParis + " seat" + (tripToParis > 1 ? "s" : "") + " left");
        System.out.println("2. New York US – " + tripToNewYork + " seat" + (tripToNewYork > 1 ? "s" : "") + " left");
        System.out.println("3. Tokyo JP – " + tripToTokyo + " seat" + (tripToTokyo > 1 ? "s" : "") + " left\n");
    }

    public static Client findClient (ArrayList<Client> clients, String name) {
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(name)) return client;
        }
        return null;
    }

}