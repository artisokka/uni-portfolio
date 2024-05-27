package fi.tuni.prog3.streams2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author janik
 */
public class MovieAnalytics2 {
    private List<Movie> movies;

    public MovieAnalytics2() {
        movies = new ArrayList<>();
    }
    static public Consumer<Movie> showInfo() {
        return movie -> System.out.println(movie.getTitle() + " (By " + movie.
                getDirector() + ", " + movie.getReleaseYear() + ")");
    }
    public void populateWithData(String fileName) throws FileNotFoundException,
            IOException {
        try (var br = new BufferedReader(new FileReader(fileName))) {
            this.movies = (List<Movie>) br.lines()                                        .map(line -> line.split(";"))
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

    public void printCountByDirector(int n) {
        Map<String, Long> counts = movies.stream()
                .collect(Collectors.groupingBy(Movie::getDirector, Collectors.
                        counting()));

        counts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().
                        thenComparing(Map.Entry.comparingByKey()))
                .limit(n)
                .forEach(entry -> System.out.println(entry.getKey() + ": " +
                        entry.getValue() + " movies"));
    }

    public void printAverageDurationByGenre() {
        Map<String, Double> averageDurationsByGenre = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.
                        averagingDouble(Movie::getDuration)));

        averageDurationsByGenre.entrySet().stream().sorted(Map.Entry.
                <String, Double>comparingByValue().thenComparing(Map.Entry.
                        comparingByKey())).
                forEach(entry ->
                        System.out.format("%s: %.2f%n", entry.getKey(),
                                entry.getValue()));
    }

    public void printAverageScoreByGenre() {
        Map<String, Double> avgScores = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.
                        averagingDouble(Movie::getScore)));

        avgScores.entrySet().stream().sorted(Map.Entry.
                <String, Double>comparingByValue().reversed().thenComparing(
                        Map.Entry.
                                comparingByKey())).forEach(
                        entry ->
                        System.out.
                                format("%s: %.2f%n", entry.getKey(), entry.getValue()));
    }
}
