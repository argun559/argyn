package controller;

import dto.CreateMediaRequest;
import dto.UpdateMediaRequest;
import model.MediaContent;
import service.MediaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    private final MediaService service;

    public MediaController(MediaService service) {
        this.service = service;
    }

    @PostMapping
    public MediaContent create(@Valid @RequestBody CreateMediaRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<MediaContent> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MediaContent one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public MediaContent update(@PathVariable Long id, @Valid @RequestBody UpdateMediaRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
