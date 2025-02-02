package com.gmail.clarkin200.libraryApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static final Logger log = LoggerFactory.getLogger(Library.class);
    private List<Book> repository = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) {
            log.info("Fail to add, book is null");
            return;
        }
        if (BookValidator.isFieldTitleValidated(book.getTitle()) & BookValidator.isFieldAuthorValidated(book.getAuthor())){
            repository.add(book);
        }
    }

    public boolean removeBook(Book book) {
        if (book == null) {
            log.info("Fail to remove, book is null");
            return false;
        }
        if(!(BookValidator.isFieldTitleValidated(book.getTitle()) & BookValidator.isFieldAuthorValidated(book.getAuthor()))){
            log.info("Fail to remove, book is non valid");
            return false;
        }
        else  {
            if(!repository.contains(book)){
                log.info("Fail to remove, book not exist");
                return false;
            }
            repository.remove(book);
            log.info("Removing {}", book);
            return true;
        }
    }

    public List<Book> getBooks() {
        if (repository == null) {
            log.info("Library is null");
        }
        if (repository.isEmpty()){
            log.info("Library is empty");
        }
        return repository;
    }

    public int getBookCount() {
        return repository.size();
    }
}
