package service;

import dto.CreateMediaRequest;
import dto.UpdateMediaRequest;
import exception.NotFoundException;
import model.MediaContent;
import patterns.factory.MediaFactory;
import patterns.factory.MediaType;
import patterns.singleton.LoggingService;
import repository.MediaContentRepository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {

    private final MediaContentRepository repo;

    public MediaService(MediaContentRepository repo) {
        this.repo = repo;
    }

    @CacheEvict(value = {"media", "mediaById"}, allEntries = true)
    public MediaContent create(CreateMediaRequest req) {
        LoggingService.getInstance().info("create media: " + req.getTitle());

        MediaType type = MediaType.valueOf(req.getType().toUpperCase());

        MediaContent media = MediaFactory.create(
                type,
                req.getTitle(),
                req.getYear(),
                req.getDurationMinutes(),
                req.getSeasons()
        );

        return repo.save(media);
    }

    @Cacheable("media")
    public List<MediaContent> findAll() {
        return repo.findAll();
    }

    @Cacheable(value = "mediaById", key = "#id")
    public MediaContent findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("media not found: " + id));
    }

    @CacheEvict(value = {"media", "mediaById"}, allEntries = true)
    public MediaContent update(Long id, UpdateMediaRequest req) {
        MediaContent media = findById(id);

        media.setTitle(req.getTitle());
        media.setYear(req.getYear());

        return repo.save(media);
    }

    @CacheEvict(value = {"media", "mediaById"}, allEntries = true)
    public void delete(Long id) {
        MediaContent media = findById(id);
        repo.delete(media);
    }
}
