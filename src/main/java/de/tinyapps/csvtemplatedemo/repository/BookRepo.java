package de.tinyapps.csvtemplatedemo.repository;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class BookRepo {

    private static final List<Book> books = List.of(
      new Book("1", "1111-1111-1111", "Der Herr der Ringe", "Tolkien", new Date()),
      new Book("2", "1111-1111-2222", "Der Hobbit", "Tolkien", new Date()),
      new Book("3", "1111-1111-3333", "1984", "George Orwell", new Date()),
      new Book("4", "1111-1111-4444", "The Origin of Species", "Charles Darwin", new Date())
    );

    public List<Book> listBooks() {
        return books;
    }

}
