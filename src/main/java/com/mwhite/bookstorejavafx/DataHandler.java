package com.mwhite.bookstorejavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public enum DataHandler {
    INSTANCE;
    private List<Book> books = null;

    private List<Book> getBooks() {
        if(books == null) {
            books = new ArrayList<>();
            books.add(new Book("A Brief History of Time", "Stephen Hawking", 24.99));
            books.add(new Book("Jurrasic Park", "Michael Crichton", 19.99));
            books.add(new Book("Design Patterns", "Erich Gamma", 34.99));
            books.add(new Book("Clean Code", "Robert Martin", 42.49));
        }
        return books;
    }

    public void createBook(Book book) {
        getBooks().add(book);
    }

    public void deleteBook(Book book) {
        getBooks().remove(book);
    }

    public ObservableList<Book> booksList() {
        ObservableList<Book> obsList = FXCollections.observableArrayList(getBooks());
        return obsList;
    }
}
