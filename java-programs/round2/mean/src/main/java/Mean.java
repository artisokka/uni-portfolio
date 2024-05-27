/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author janik
 */

import java.util.Scanner;

public class Mean {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter numbers:\n");
        String line = myScanner.nextLine();
        String[] numbers = line.split(" ");
        double sum = 0;
        double mean = 0;
        
        for (String s : numbers) {
            double d = Double.parseDouble(s);
            sum += d;
        }
        mean = sum / numbers.length;
        System.out.println("Mean: " + mean);
        
    }
}
