package fi.tuni.prog3.sevenzipsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

/**
 *
 * @author janik
 */
public class Sevenzipsearch {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File:");
        String fileName = scanner.nextLine();

        try (SevenZFile file = new SevenZFile(new File(fileName))) {
            Iterable<SevenZArchiveEntry> entries = file.getEntries();
            System.out.println("Query:");
            String query = scanner.nextLine();
            System.out.println();

            for (SevenZArchiveEntry entry : entries) {
                if (entry.getName().endsWith(".txt")) {
                    System.out.println(entry.getName());
                    int row = 0;
                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(file.getInputStream(entry)))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            row++;
                            String lineLowerCase = line.toLowerCase(); // Convert line to lowercase
                            String queryLowerCase = query.toLowerCase(); // Convert query to lowercase
                            if (lineLowerCase.contains(queryLowerCase)) {
                                String matchedLine = line.replaceAll("(?i)" +
                                        query, query.toUpperCase());
                                System.out.println(row + ": " + matchedLine);
                            }
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
