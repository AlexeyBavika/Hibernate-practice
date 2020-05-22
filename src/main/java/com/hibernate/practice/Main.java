package com.hibernate.practice;

import com.hibernate.practice.lib.Injector;
import com.hibernate.practice.model.Author;
import com.hibernate.practice.model.Book;
import com.hibernate.practice.model.Genre;
import com.hibernate.practice.service.AuthorDaoService;
import com.hibernate.practice.service.BookDaoService;
import com.hibernate.practice.service.GenreDaoService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("com.hibernate.practice");

    public static void main(String[] args) {
        GenreDaoService genreService = (GenreDaoService) INJECTOR.getInstance(GenreDaoService.class);
        Genre novelGenre = new Genre();
        novelGenre.setName("Novel");
        novelGenre = genreService.createGenre(novelGenre);

        Genre adventureGenre = new Genre();
        adventureGenre.setName("Adventure");
        adventureGenre = genreService.createGenre(adventureGenre);


        AuthorDaoService authorService = (AuthorDaoService) INJECTOR.getInstance(AuthorDaoService.class);
        Author firstAuthor = new Author();
        firstAuthor.setName("Shevchenko");
        firstAuthor = authorService.createAuthor(firstAuthor);

        Author secondAuthor = new Author();
        secondAuthor.setName("Franko");
        secondAuthor = authorService.createAuthor(secondAuthor);


        BookDaoService bookService = (BookDaoService) INJECTOR.getInstance(BookDaoService.class);
        Book firstBook = new Book();
        firstBook.setAuthor(firstAuthor);
        firstBook.setGenre(novelGenre);
        firstBook.setTitle("Kobzar");
        bookService.createBook(firstBook);

        Book secondBook = new Book();
        secondBook.setAuthor(secondAuthor);
        secondBook.setGenre(adventureGenre);
        secondBook.setTitle("Gimn");
        bookService.createBook(secondBook);

        System.out.println("Book by title Kobzar " + bookService.getBookByTitle("Kobzar"));
        System.out.println("Book by first author " + bookService.getBooksListByAuthor(firstAuthor));
        System.out.println("Book by first genre " + bookService.getBooksListByGenre(novelGenre));

        System.out.println("Book by title Gimn " + bookService.getBookByTitle("Gimn"));
        System.out.println("Book by second author " + bookService.getBooksListByAuthor(secondAuthor));
        System.out.println("Book by second genre " + bookService.getBooksListByGenre(adventureGenre));

    }
}
