package com.hibernate.practice.service;

import com.hibernate.practice.model.Author;
import com.hibernate.practice.model.Book;
import com.hibernate.practice.model.Genre;

import java.util.List;

public interface BookDaoService {
    Book createBook(Book book);

    Book getBookByTitle(String title);

    List<Book> getBooksListByAuthor(Author author);

    List<Book> getBooksListByGenre(Genre genre);
}
