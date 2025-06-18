public class Book {

    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    // --- Getters & Setters ---
    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        this.isBorrowed = true;
    }

    public void returnBook() {
        this.isBorrowed = false;
    }

    public void show() {
        System.out.println("📗 BOOK :");
        System.out.println("   Title  : " + title);
        System.out.println("   Author : " + author);
        System.out.println("   Status : " + (isBorrowed ? "Borrowed" : "Available"));
    }
}
