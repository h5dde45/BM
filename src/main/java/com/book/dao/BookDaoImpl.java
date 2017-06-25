package com.book.dao;

import com.book.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    private static final Logger LOGGER=
            LoggerFactory.getLogger(BookDaoImpl.class);

//    @Autowired
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
    public void updateBook(Book book) {
        Session session=sessionFactory.getCurrentSession();
        session.update(book);
        LOGGER.info("Book successfully update. Book details: "+book);
    }

    @Override
    public void removeBook(int id) {
        Session session=sessionFactory.getCurrentSession();
        Book book=(Book) session.load(Book.class,new  Integer(id));
        if(book!=null){
            session.delete(book);
        }
        LOGGER.info("Book successfully delete. Book details: "+book);
    }

    @Override
    public Book getBookById(int id) {
        Session session=sessionFactory.getCurrentSession();
        Book book=(Book) session.load(Book.class,new  Integer(id));
        LOGGER.info("Book successfully loaded. Book details: "+book);
        return book;
    }

    @Override
    public List<Book> listBooks() {
        Session session=sessionFactory.getCurrentSession();
        List<Book> bookList=session.createQuery("from Book").list();

        for (Book book:bookList){
            LOGGER.info("Book details: "+book);
        }
        return bookList;
    }
}
