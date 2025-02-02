package com.gmail.clarkin200.libraryApp;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LibraryTest {

    private static Logger log;
    private static Library library;

    @BeforeAll
    static void setUo() {
        library = new Library();
        log = LoggerFactory.getLogger(LibraryTest.class);
    }

    @AfterEach
    public void cleanUp() {
        library.getBooks().clear();
    }

    @Test
    @Order(1)
    public void testAddBook() {
        log.info("testAddBook");
        Book book = new Book("Kobzar", "Taras Shevhencko");
        library.addBook(book);
        assertNotNull(library.getBooks());
    }

    @Test
    @Order(2)
    public void testAddInvalidBook() throws NullPointerException {
        log.info("testAddInvalidBook");
        library.addBook(null);
        assertTrue(library.getBooks().isEmpty());

        log.info("Trying create book where fields equals null");
        Book book = new Book("Kobzar", null);
        library.addBook(book);
        assertTrue(library.getBooks().isEmpty());

        book = new Book(null, "Taras Shevchenko");
        library.addBook(book);
        assertTrue(library.getBooks().isEmpty());

        book = new Book(null, null);
        library.addBook(book);
        assertTrue(library.getBooks().isEmpty());

        log.info("Trying create book where fields is empty");
        book = new Book("Kobzar", "");
        library.addBook(book);
        assertTrue(library.getBooks().isEmpty());

        book = new Book("", "Taras Shevchenko");
        library.addBook(book);
        assertTrue(library.getBooks().isEmpty());

        book = new Book("", "");
        library.addBook(book);
        assertTrue(library.getBooks().isEmpty());

        log.info("Trying create book where fields contains special symbols");
        book = new Book("Kobzar@", "Taras Shevchenko@12");
        library.addBook(book);
        assertTrue(library.getBooks().isEmpty());

        log.info("Trying create book where fields is more than 10-25 symbols");
        book = new Book("KobzarKobzar", "Taras ShevchenkoTaras Shevchenko");
        library.addBook(book);
        assertTrue(library.getBooks().isEmpty());
    }

    @Test
    @Order(3)
    public void testRemoveBook() {
        log.info("Trying delete valid value");
        Book bookToDelete = new Book("Kobzar", "Taras Shevchenko");
        library.addBook(bookToDelete);
        assertTrue(library.removeBook(bookToDelete));

        log.info("Trying delete when book equals null ");
        assertFalse(library.removeBook(null));

        log.info("Trying delete null values");
        assertFalse(library.removeBook(new Book(null,null)));

        assertFalse(library.removeBook(new Book("Kobzar",null)));

        assertFalse(library.removeBook(new Book(null,"Taras Shevchenko")));

        log.info("Attempting to delete a value that does not exist");
        assertFalse(library.removeBook(new Book("Eneyida","Ivan Kotlyrevski")));

        log.info("Attempting to delete non valid value");
        assertFalse(library.removeBook(new Book("","")));
    }

    @Test
    @Order(4)
    public void testGetBooks(){
        log.info("Trying to get empty library");
        assertTrue(library.getBooks().isEmpty());

        log.info("Trying to get library");
        Book toAdd = new Book("Kobzar","Taras Shevchenko");
        library.addBook(toAdd);
        library.getBooks().forEach(System.out::println);
        assertTrue(library.getBooks().contains(toAdd));
    }

    @Test
    @Order(5)
    public void testGetBookCount(){
        log.info("Trying to get book count");
        Book book = new Book("Kobzar","Taras Shevchenko");
        Book book2 = new Book("Eneyida","Ivan Kotlyrevski");

        library.addBook(book);
        library.addBook(book2);

        library.getBookCount();

        System.out.println("Books in library: " + library.getBookCount());
        assertEquals(library.getBooks().size(),library.getBookCount());
    }

}
