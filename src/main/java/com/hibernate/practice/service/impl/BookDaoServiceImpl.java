package com.hibernate.practice.service.impl;

import com.hibernate.practice.dao.BookDao;
import com.hibernate.practice.lib.Inject;
import com.hibernate.practice.lib.Service;
import com.hibernate.practice.model.Author;
import com.hibernate.practice.model.Book;
import com.hibernate.practice.model.Genre;
import com.hibernate.practice.service.BookDaoService;

import java.util.List;

@Service
public class BookDaoServiceImpl implements BookDaoService {
    @Inject
    private BookDao bookDao;

    @Override
    public Book createBook(Book book) {
        return bookDao.createBook(book);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookDao.getBookByTitle(title);
    }

    @Override
    public List<Book> getBooksListByAuthor(Author author) {
        return bookDao.getBooksListByAuthor(author);
    }

    @Override
    public List<Book> getBooksListByGenre(Genre genre) {
        return bookDao.getBooksListByGenre(genre);
    }
}
