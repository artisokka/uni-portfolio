
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author janik
 */
public class Parameters {
    public static void main(String[] args) throws IOException {
        BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> params = new ArrayList<String>();
        int longest = 0;

        System.out.println("Parameters:");

        while (true) {
            String line = user.readLine();
            if (line != null) {
                params.add(line);
                if (longest < line.length()) {
                    longest = line.length();
                }
            } else {
                break;
            }
        }
        int index = 1;
        int lastLine = params.size() + 1;
        String indexLength= Integer.toString(lastLine);
        int listLength = indexLength.length();
        Collections.sort(params);
        
        System.out.print("####");
        for (int i = 0; i < listLength+1; i++) {
            System.out.print("#");
        }
        for (int i = 0; i < longest + 2; i++) {
            System.out.print("#");
        }
        System.out.println();
        
        for (String p : params) {
            if(listLength == 1) {
                System.out.format("#%2d | %s", index, p);
            }
            else if(listLength == 2) {
                System.out.format("#%3d | %s", index, p);
            }
            else if(listLength == 3) {
                System.out.format("#%4d | %s", index, p);
            }
            
            for (int i = 0; i < longest - p.length() + 1; i++) {
                System.out.print(" ");
            }
            System.out.println("#");
            index++;
            if (index < lastLine) {
                System.out.print("#");
                for (int i = 0; i < listLength+2; i++) {
                    System.out.print("-");
                }
                
                
                System.out.print("+-");
                for (int i = 0; i < longest; i++) {
                    System.out.print("-");
                }
                System.out.println("-#");
            }
        }
        
        System.out.print("####");
        for (int i = 0; i < indexLength.length()+1; i++) {
            System.out.print("#");
        }
        for (int i = 0; i < longest + 2; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
}
