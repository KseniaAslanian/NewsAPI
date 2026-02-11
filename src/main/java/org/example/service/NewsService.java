package org.example.service;

import org.example.model.News;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NewsService {
    private final ConcurrentHashMap<Long, News> newsMap = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Optional<News> getNewsById(Long id) {
        return Optional.ofNullable(newsMap.get(id));
    }

    public List<News> getAllNews() {
        return new ArrayList<>(newsMap.values());
    }

    public News createNews(News news) {
        Long newId = idGenerator.getAndIncrement();
        news.setId(newId);
        news.setDate(Instant.now());
        newsMap.put(newId, news);
        return news;
    }

    public Optional<News> updateNews(Long id, News updatedNews) {
        News result = newsMap.computeIfPresent(id, (key, oldNews) -> {
            updatedNews.setId(id);
            updatedNews.setDate(Instant.now());
            return updatedNews;
        });
        return Optional.ofNullable(result);
    }

    public boolean deleteNews(Long id) {
        return newsMap.remove(id) != null;
    }
}
