package com.groweasy.newsservice.service;

import com.groweasy.newsservice.model.New;

public interface NewsService {
    New createNew(New news);

    New getNewById(Long id);
}
