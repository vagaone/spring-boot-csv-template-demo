package de.tinyapps.csvtemplatedemo.repository;

import java.util.Date;

public record Book(String id, String isbn, String title, String author, Date releaseDate) {
}
