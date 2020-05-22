package com.hibernate.practice.dao.impl;

import com.hibernate.practice.dao.BookDao;
import com.hibernate.practice.lib.Dao;
import com.hibernate.practice.model.Author;
import com.hibernate.practice.model.Book;
import com.hibernate.practice.model.Genre;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.hibernate.practice.util.HibernateUtil;

import java.util.List;

@Dao
public class BookDaoImpl implements BookDao {

    @Override
    public Book createBook(Book book) {
        Session session = session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Long bookId = (Long) session.save(book);
            transaction.commit();
            book.setId(bookId);
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Could not insert genre entity.", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Book getBookByTitle(String title) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Book> query = session.createQuery("FROM Book WHERE title = :ttl");
            query.setParameter("ttl", title);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Book> getBooksListByAuthor(Author author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Book> query = session.createQuery("FROM Book WHERE author = :athr");
            query.setParameter("athr", author);
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Book> getBooksListByGenre(Genre genre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Book> query = session.createQuery("FROM Book WHERE genre = :gnr");
            query.setParameter("gnr", genre);
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
