package com.hibernate.practice.dao.impl;

import com.hibernate.practice.dao.AuthorDao;
import com.hibernate.practice.lib.Dao;
import com.hibernate.practice.model.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.practice.util.HibernateUtil;

@Dao
public class AuthorDaoImpl implements AuthorDao {

    @Override
    public Author createAuthor(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Long authorId = (Long) session.save(author);
            author.setId(authorId);
            transaction.commit();
            return author;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can`t add author", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
