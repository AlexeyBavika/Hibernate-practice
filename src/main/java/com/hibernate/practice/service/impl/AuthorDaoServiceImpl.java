package com.hibernate.practice.service.impl;

import com.hibernate.practice.dao.AuthorDao;
import com.hibernate.practice.lib.Inject;
import com.hibernate.practice.lib.Service;
import com.hibernate.practice.model.Author;
import com.hibernate.practice.service.AuthorDaoService;

@Service
public class AuthorDaoServiceImpl implements AuthorDaoService {
    @Inject
    private AuthorDao authorDao;

    @Override
    public Author createAuthor(Author author) {
        return authorDao.createAuthor(author);
    }
}
