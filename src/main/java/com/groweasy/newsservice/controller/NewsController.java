package com.groweasy.newsservice.controller;

import com.groweasy.newsservice.model.New;
import com.groweasy.newsservice.repository.NewsRepository;
import com.groweasy.newsservice.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NewsController {
    @Autowired
    private NewsService newsService;
    private final NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping("/news")
    public ResponseEntity<List<New>> getAllNews() {
        return new ResponseEntity<List<New>>(newsRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/news/{id}")
    public ResponseEntity<New> getNewById(@PathVariable("id") Long id) {
        New news =  newsService.getNewById(id);
        if(null == news){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(news);
    }

    @PostMapping("/news")
    public ResponseEntity<New> createNew(@RequestBody New news) {
        try {
            validateNew(news);
            existsByTitle(news);
            return new ResponseEntity<New>(newsService.createNew(news), HttpStatus.CREATED);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private void validateNew(New news) {
        if (news.getTitle() == null || news.getTitle().isEmpty()) {
            throw new RuntimeException("El título del artículo es obligatorio");
        }
    }

    private void existsByTitle(New news) {
        if (newsRepository.existsByTitle(news.getTitle())) {
            throw new RuntimeException("El título del artículo ya existe");
        }
    }
}
