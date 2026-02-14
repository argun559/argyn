package repository;

import model.MediaContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaContentRepository extends JpaRepository<MediaContent, Long> {
}
