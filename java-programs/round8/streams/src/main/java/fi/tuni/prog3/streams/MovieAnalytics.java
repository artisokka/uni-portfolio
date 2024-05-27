package fi.tuni.prog3.streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author janik
 */
public class MovieAnalytics {
    private ArrayList<Movie> movies;

    public MovieAnalytics() {
        movies = new ArrayList<>();
    }
    static public Consumer<Movie> showInfo() {
        return movie -> System.out.println(movie.getTitle() + " (By " + movie.
                getDirector() + ", " + movie.getReleaseYear() + ")");
    }
    public void populateWithData(String fileName) throws FileNotFoundException,
            IOException {
        try (var br = new BufferedReader(new FileReader(fileName))) {
            this.movies = (ArrayList<Movie>) br.lines()
                                        .map(line -> line.split(";"))
                    .map(movie ->
                            new Movie(movie[0], Integer.parseInt(movie[1]),
                                    Integer.parseInt(movie[2]), movie[3],
                                    Double.parseDouble(movie[4]), movie[5]))
                    .collect(Collectors.toList());
        }
    }

    public Stream<Movie> moviesAfter(int year) {
        return movies.stream().filter(movie -> movie.getReleaseYear() >= year)
                .distinct()
                .sorted(Comparator.comparing(Movie::getReleaseYear).
                        thenComparing(Movie::getTitle))
                .collect(Collectors.toList())
                .stream();
    }

    public Stream<Movie> moviesBefore(int year) {
        return movies.stream().filter(movie -> movie.getReleaseYear() <= year)
                .distinct()
                .sorted(Comparator.comparing(Movie::getReleaseYear).
                        thenComparing(Movie::getTitle))
                .collect(Collectors.toList())
                .stream();
    }

    public Stream<Movie> moviesBetween(int yearA, int yearB) {
        return movies.stream().filter(movie ->
                movie.getReleaseYear() >= yearA && movie.getReleaseYear() <=
                yearB)
                .distinct()
                .sorted(Comparator.comparing(Movie::getReleaseYear).
                        thenComparing(Movie::getTitle))
                .collect(Collectors.toList())
                .stream();
    }

    public Stream<Movie> moviesByDirector(String director) {
        return movies.stream().
                filter(movie -> (movie.getDirector() == null ? director ==
                        null
                        : movie.getDirector().equals(director)))
                .distinct()
                .sorted(Comparator.comparing(Movie::getReleaseYear).
                        thenComparing(Movie::getTitle))
                .collect(Collectors.toList())
                .stream();
    }

}
