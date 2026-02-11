package org.example.controller;

import jakarta.validation.Valid;
import org.example.exception.NewsNotFoundException;
import org.example.model.News;
import org.example.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) {
        News news = newsService.getNewsById(id).orElseThrow(() -> new NewsNotFoundException(id));
        return ResponseEntity.ok(news);
    }

    @PostMapping
    public ResponseEntity<News> createNews(@Valid @RequestBody News news) {
        News created = newsService.createNews(news);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @Valid @RequestBody News news) {
        News updatedNews = newsService.updateNews(id, news).orElseThrow(() -> new NewsNotFoundException(id));
        return ResponseEntity.ok(updatedNews);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        boolean deleted = newsService.deleteNews(id);
        if (!deleted)
            throw new NewsNotFoundException(id);
        return ResponseEntity.noContent().build();
    }
}
