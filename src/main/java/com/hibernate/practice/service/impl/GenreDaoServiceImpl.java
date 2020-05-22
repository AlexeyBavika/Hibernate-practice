package com.hibernate.practice.service.impl;

import com.hibernate.practice.dao.GenreDao;
import com.hibernate.practice.lib.Inject;
import com.hibernate.practice.lib.Service;
import com.hibernate.practice.model.Genre;
import com.hibernate.practice.service.GenreDaoService;

@Service
public class GenreDaoServiceImpl implements GenreDaoService {
    @Inject
    private GenreDao genreDao;

    @Override
    public Genre createGenre(Genre genre) {
        return genreDao.createGenre(genre);
    }
}
