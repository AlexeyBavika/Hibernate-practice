package com.hibernate.practice.dao.impl;

import com.hibernate.practice.dao.GenreDao;
import com.hibernate.practice.lib.Dao;
import com.hibernate.practice.model.Genre;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.practice.util.HibernateUtil;

@Dao
public class GenreDaoImpl implements GenreDao {

    @Override
    public Genre createGenre(Genre genre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Long genreId = (Long) session.save(genre);
            genre.setId(genreId);
            transaction.commit();
            return genre;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can`t create genre", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
