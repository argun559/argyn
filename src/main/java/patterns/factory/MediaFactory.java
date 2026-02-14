package patterns.factory;

import exception.BadRequestException;
import model.MediaContent;
import model.Movie;
import model.Series;


public class MediaFactory {
    public static MediaContent create(MediaType type, String title, Integer year, Integer durationMinutes, Integer seasons) {
        if (type == null) {
            throw new BadRequestException("type is required");
        }
        if (type == MediaType.MOVIE) {
            if (durationMinutes == null) {
                throw new BadRequestException("durationMinutes is required for MOVIE");
            }
            return new Movie(title, year, durationMinutes);
        }
        if (type == MediaType.SERIES) {
            if (seasons == null) {
                throw new BadRequestException("seasons is required for SERIES");
            }
            return new Series(title, year, seasons);
        }
        throw new BadRequestException("unsupported type");
    }
}
