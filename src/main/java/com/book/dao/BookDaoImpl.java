package com.book.dao;

import com.book.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    private static final Logger LOGGER=
            LoggerFactory.getLogger(BookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session=sessionFactory.getCurrentSession();
        session.persist(book);
        LOGGER.info("Book successfully saved. Book details: "+book);
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void removeBook(int id) {

    }

    @Override
    public Book getBookById(int id) {
        return null;
    }

    @Override
    public List<Book> listBooks() {
        return null;
    }
}
