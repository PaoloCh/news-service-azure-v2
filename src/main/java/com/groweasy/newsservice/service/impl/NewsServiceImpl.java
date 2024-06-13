package com.groweasy.newsservice.service.impl;

import com.groweasy.newsservice.model.New;
import com.groweasy.newsservice.repository.NewsRepository;
import com.groweasy.newsservice.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public New createNew(New news) {
        return newsRepository.save(news);
    }

    @Override
    public New getNewById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }

}
