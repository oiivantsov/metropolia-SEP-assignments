package org.oleg.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LibraryTest {

    @Test
    void testAddBook() {
        Library library = new Library();
        library.addBook("Book A");
        assertTrue(library.listBooks().contains("Book A"));
    }

    @Test
    void testRemoveBook() {
        Library library = new Library();
        library.addBook("Book B");
        library.removeBook("Book B");
        assertFalse(library.listBooks().contains("Book B"));
    }

    @Test
    void testListBooks() {
        Library library = new Library();
        library.addBook("Book C");
        library.addBook("Book D");
        List<String> books = library.listBooks();
        assertEquals(2, books.size());
        assertTrue(books.contains("Book C"));
        assertTrue(books.contains("Book D"));
    }
}
