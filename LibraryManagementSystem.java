import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = new BookManager();

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Published Year: ");
                    int publishedYear = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Copies Available: ");
                    int copiesAvailable = scanner.nextInt();
                    bookManager.addBook(title, author, isbn, publishedYear, genre, copiesAvailable);
                    break;
                case 2:
                    bookManager.listBooks();
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}