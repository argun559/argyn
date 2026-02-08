package model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MOVIE")
public class Movie extends MediaContent {
    private Integer durationMinutes;

    public Movie() {}

    public Movie(String title, Integer year, Integer durationMinutes) {
        super(title, year);
        this.durationMinutes = durationMinutes;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
