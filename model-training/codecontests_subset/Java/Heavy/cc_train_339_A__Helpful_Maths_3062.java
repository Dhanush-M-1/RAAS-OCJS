import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.sort;

/**
 * Created by sadamchyk on 12/4/14.
 */
public class MathHelp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Create scanner
        String line = input.nextLine();

        char [] data = line.toCharArray(); // Convert string to array of chars
        char [] toSort = new char [data.length - (data.length/2)]; // create new array to store sorted values

        int p = 0; // iterator in toSort array

        for (int i = 0; i < data.length; i=i+2){
            toSort[p] = data[i];
            p++;
        }
        Arrays.sort(toSort); // Sorting array

        p = 0;
        for(int n = 0; n < data.length; n=n+2){
            data[n] = toSort[p];
            p++;
        }


        System.out.println(data);
    }
}