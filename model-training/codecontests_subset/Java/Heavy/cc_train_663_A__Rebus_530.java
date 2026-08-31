import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shahjahan on 5/19/2017.
 * http://codeforces.com/contest/664/problem/B
 */
public class C664_B {
    public static void main(String[] args) throws IOException {
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


        long sumOfPositives = number;
        long sumOfNegatives = 0;

        if (numberOfMinus > 0) {
            for (sumOfPositives = numberOfPlus * number; sumOfPositives >= number; sumOfPositives--) {
                sumOfNegatives = sumOfPositives - number;
                if (sumOfNegatives >= numberOfMinus && sumOfNegatives <= numberOfMinus * number) {
                    break;
                }
            }
        }

        if (numberOfMinus > 0 && (sumOfPositives - sumOfNegatives) != number) {
            System.out.println("Impossible");
        } else if (numberOfPlus > sumOfPositives) {
            System.out.println("Impossible");
        } else {
            populate(parts, numberOfPlus, sumOfPositives, "+");

            if (numberOfMinus > 0) {
                populate(parts, numberOfMinus, sumOfNegatives, "-");
            }

            System.out.println("Possible");
            for (String part : parts) {
                System.out.print(part + " ");
            }
        }
    }

    private static void populate(String[] parts, int numberOfOperations, long sumPart, String operation) {
        long div = sumPart / numberOfOperations;
        long remainder = sumPart % numberOfOperations;

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