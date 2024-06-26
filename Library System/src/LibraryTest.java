import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Java", "Srinivasa V", "1234567890", "Education", 1999, "IT", true);
        book2 = new Book("Python", "Srinivasa", "0987654321", "Education", 1998, "IT", false);
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    public void testAddBook() {
        Book book3 = new Book("C#", "Srini", "9876543210", "Education", 2000, "IT", true);
        library.addBook(book3);
        assertEquals(3, library.listAllBooks().size());
    }

    @Test
    public void testRemoveBook() {
        library.removeBook("1234567890");
        assertEquals(1, library.listAllBooks().size());
    }

    @Test
    public void testFindBookByTitle() {
        List<Book> books = library.findBookByTitle("Java");
        assertEquals(1, books.size());
        assertEquals("Srinivasa V", books.get(0).getAuthor());
    }

    @Test
    public void testFindBookByAuthor() {
        List<Book> books = library.findBookByAuthor("Srinivasa");
        assertEquals(1, books.size());
        assertEquals("Python", books.get(0).getTitle());
    }

    @Test
    public void testListAllBooks() {
        List<Book> books = library.listAllBooks();
        assertEquals(2, books.size());
    }

    @Test
    public void testListAvailableBooks() {
        List<Book> books = library.listAvailableBooks();
        assertEquals(1, books.size());
        assertEquals("Java", books.get(0).getTitle());
    }
}
