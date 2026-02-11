package org.example.config;

import org.example.model.News;
import org.example.service.NewsService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {
    private final NewsService newsService;

    public DataInitializer(NewsService newsService) {
        this.newsService = newsService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        newsService.createNews(new News("New AI Model Released", "Tech company announces breakthrough in artificial intelligence with new language model capable of understanding context better than previous versions."));
        newsService.createNews(new News("Discovery on Mars", "NASA's rover has detected unusual mineral formations on Mars surface, potentially indicating past water activity in the region."));
        newsService.createNews(new News("Stock Market Hits Record High", "Major stock indices reached all-time highs today as investors responded positively to recent economic data and corporate earnings reports."));
    }
}
