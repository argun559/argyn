package model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SERIES")
public class Series extends MediaContent {
    private Integer seasons;

    public Series() {}

    public Series(String title, Integer year, Integer seasons) {
        super(title, year);
        this.seasons = seasons;
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }
}
