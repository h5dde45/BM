package com.book.dao;

import com.book.model.Book;

import java.util.List;

public interface BookDao {

    void addBook(Book book);

    void update(Book book);

    void removeBook(int id);

    Book getBookById(int id);

    List<Book> listBooks();

}
