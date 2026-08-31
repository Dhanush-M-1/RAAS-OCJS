import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shahjahan on 5/19/2017.
 * http://codeforces.com/contest/664/problem/B
 */
public class C664_B {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new FileReader("E:\\ProblemSolve\\Acm\\src\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int number = Integer.parseInt(parts[parts.length - 1]);

        int numberOfPlus = 0;
        int numberOfMinus = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("=")) break;
            if (parts[i].equals("?")) {
                if (i == 0 || parts[i - 1].equals("+")) {
                    numberOfPlus++;
                } else if (parts[i - 1].equals("-")) {
                    numberOfMinus++;
                }
            }
        }


        long positivePart = number;
        long negativePart = 0;

        if (numberOfMinus > 0) {
            for (positivePart = numberOfPlus * number; positivePart >= numberOfPlus; positivePart--) {
                negativePart = positivePart - number;
                if (negativePart >= numberOfMinus && negativePart <= numberOfMinus * number) {
                    break;
                }
            }
        }

        if (numberOfMinus > 0 && (positivePart - negativePart) != number) {
            System.out.println("Impossible");
        } else {
            if (numberOfPlus > positivePart) {
                System.out.println("Impossible");
            } else {
                populate(parts, numberOfPlus, positivePart, "+");

                if (numberOfMinus > 0) {
                    populate(parts, numberOfMinus, negativePart, "-");
                }

                System.out.println("Possible");
                for (int i = 0; i < parts.length; i++) {
                    System.out.print(parts[i] + " ");
                }
            }
        }
    }

    private static void populate(String[] parts, int numberOfOperations, long part, String operation) {
        long div = part / numberOfOperations;
        long remainder = part % numberOfOperations;

        long[] numbers = new long[numberOfOperations];
        for (int i = 0; i < numberOfOperations; i++) {
            numbers[i] = div;
        }

        if (remainder != 0) {
            for (int i = 0; i < numberOfOperations && remainder > 0; i++) {
                numbers[i]++;
                remainder--;
            }
        }

        for (int i = 0, counter = 0; i < parts.length; i++) {
            if (parts[i].equals("?")) {
                if (i == 0 || parts[i - 1].equals(operation)) {
                    parts[i] = String.valueOf(numbers[counter]);
                    counter++;

                    if (counter == numbers.length) break;
                }
            }
        }
    }
}