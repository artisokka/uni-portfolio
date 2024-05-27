/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author janik
 */
import java.util.Scanner;
import java.util.Arrays;

public class Median {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter numbers:");
        
        String line = myScanner.nextLine();
        String[] numbers = line.split(" ");
        
        var n = numbers.length;
        double[] ascending = Arrays.stream(numbers)
                        .mapToDouble(Double::parseDouble)
                        .toArray();
        Arrays.sort(ascending);
        
        int middle = n / 2;
        double median = 0;        
        
        if(n % 2 == 0) {
            median = (ascending[middle-1] + ascending[middle]) / 2;
        }
        else {
            median = ascending[middle];
        }

        System.out.println("Median: " + median);
    }
}
