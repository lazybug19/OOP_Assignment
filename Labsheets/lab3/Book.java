import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private int pages;

    Book() {
        this.title = "";
        this.author = "";
        this.pages = 0;
    }

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.pages = 0;
    }

    Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    void displayDetails() {
        System.out.println("Author name: " + author);
        System.out.println("Title name: " + title);
        System.out.println("Pages name: " + pages);
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Author name: ");
        String author = sc.nextLine();
        System.out.print("Title name: ");
        String title = sc.nextLine();
        System.out.print("Pages: ");
        int pages = sc.nextInt();
        Book book1 = new Book();
        Book book2 = new Book(author, title);
        Book book3 = new Book(author, title, pages);
        book1.displayDetails();
        book2.displayDetails();
        book3.displayDetails();

    }
}
