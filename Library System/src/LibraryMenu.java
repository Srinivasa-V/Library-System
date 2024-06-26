import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;

    public LibraryMenu(Library library) {
        this.library = library;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Library Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Find Book by Title");
            System.out.println("4. Find Book by Author");
            System.out.println("5. List All Books");
            System.out.println("6. List Available Books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    findBookByTitle(scanner);
                    break;
                case 4:
                    findBookByAuthor(scanner);
                    break;
                case 5:
                    listAllBooks();
                    break;
                case 6:
                    listAvailableBooks();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Is the book available (true/false): ");
        boolean isAvailable = scanner.nextBoolean();

        Book book = new Book(title, author, ISBN, genre, year, department, isAvailable);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private void removeBook(Scanner scanner) {
        System.out.print("Enter ISBN of the book to remove: ");
        String ISBN = scanner.nextLine();
        library.removeBook(ISBN);
        System.out.println("Book removed successfully.");
    }

    private void findBookByTitle(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        List<Book> books = library.findBookByTitle(title);
        if (books.isEmpty()) {
            System.out.println("No books found with the title \"" + title + "\".");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void findBookByAuthor(Scanner scanner) {
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        List<Book> books = library.findBookByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("No books found by the author \"" + author + "\".");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void listAllBooks() {
        List<Book> books = library.listAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void listAvailableBooks() {
        List<Book> books = library.listAvailableBooks();
        if (books.isEmpty()) {
            System.out.println("No available books in the library.");
        } else {
            books.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        LibraryMenu menu = new LibraryMenu(library);
        menu.displayMenu();
    }
}

