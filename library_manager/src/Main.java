//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int max;
        int choice;

        System.out.println("\n😊 Welcome To your 'Library Manager' !");

        // Number of books to manage
        while (true) {
            try {
                System.out.print("\n👉 How many books do you want to manage? Enter a number: ");
                max = Integer.parseInt(input.nextLine().trim());

                if (max <= 0) {
                    System.out.println("❌ Please enter a number greater than 0.");
                } else {
                    System.out.println("🎉 Got it!");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input!");
            }
        }

        Book[] books = new Book[max];
        int count = 0;

        // Main Menu
        do {
            System.out.println("\n=== Library MENU ===");
            System.out.println("   1. Add a book");
            System.out.println("   2. Show all books");
            System.out.println("   3. Search for a book by title");
            System.out.println("   4. Borrow a book");
            System.out.println("   5. Return a book");
            System.out.println("   6. Exit\n");

            // Reading the choice
            while (true) {
                try {
                    System.out.print("♦ Choice: ");
                    choice = Integer.parseInt(input.nextLine().trim());

                    if (choice < 1 || choice > 6) {
                        System.out.println("❌ Enter a number between 1 and 6.");
                    } else break;

                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input!");
                }
            }

            switch (choice) {
                case 1:
                    if (count >= max) {
                        System.out.println("🎯 Maximum number of books reached.");
                    } else {
                        System.out.print("  Title: ");
                        String title = input.nextLine().trim();
                        System.out.print("  Author: ");
                        String author = input.nextLine().trim();

                        books[count] = new Book(title, author);
                        count++;
                        System.out.println("✅ Book successfully added!");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("🚫 No registered books!");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println("\n" + (i + 1) + ".");
                            books[i].show();
                        }
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("🚫 No registered books!");
                        break;
                    }

                    System.out.print("Enter the book title to search: ");
                    String searchTitle = input.nextLine().trim().toLowerCase();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (books[i].getTitle().equalsIgnoreCase(searchTitle)) {
                            books[i].show();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("❌ Book not found.");
                    }
                    break;

                case 4:
                    if (count == 0) {
                        System.out.println("🚫 No registered books!");
                        break;
                    }

                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = input.nextLine().trim();
                    boolean borrowFound = false;

                    for (int i = 0; i < count; i++) {
                        if (books[i].getTitle().equalsIgnoreCase(borrowTitle)) {
                            borrowFound = true;
                            if (!books[i].isBorrowed()) {
                                books[i].borrowBook();
                                System.out.println("✅ Book successfully borrowed!");
                            } else {
                                System.out.println("❌ This book is already borrowed.");
                            }
                            break;
                        }
                    }

                    if (!borrowFound) {
                        System.out.println("❌ Book not found.");
                    }
                    break;

                case 5:
                    if (count == 0) {
                        System.out.println("🚫 No registered books!");
                        break;
                    }

                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = input.nextLine().trim();
                    boolean returnFound = false;

                    for (int i = 0; i < count; i++) {
                        if (books[i].getTitle().equalsIgnoreCase(returnTitle)) {
                            returnFound = true;
                            if (books[i].isBorrowed()) {
                                books[i].returnBook();
                                System.out.println("✅ Book successfully returned!");
                            } else {
                                System.out.println("❌ This book is not borrowed.");
                            }
                            break;
                        }
                    }

                    if (!returnFound) {
                        System.out.println("❌ Book not found.");
                    }
                    break;

                case 6:
                    System.out.println("\n👋 Thank you for using Library Manager. Goodbye!");
                    break;
            }

        } while (choice != 6);

        input.close();
    }
}
