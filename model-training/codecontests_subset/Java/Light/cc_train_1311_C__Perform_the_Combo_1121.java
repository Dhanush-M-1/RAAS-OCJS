//package Codeforces;

import java.util.Scanner;

public class PerformTheCombo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int length = in.nextInt();  // Not really useful
            int numTries = in.nextInt();
            String combo = in.next();

            int[] letterCount = new int[length];
            letterCount[length - 1] = 1;    // final try that works
            for (int j = 0; j < numTries; j++) {
                letterCount[in.nextInt() - 1]++;
            }
//            System.out.println("pre adding: ");
//            print(letterCount);
            for (int j = length - 2; j >= 0; j--) {
                letterCount[j] += letterCount[j + 1];
            }
//            System.out.println("combo: ");
//            print(letterCount);

            createOutput(combo, letterCount);
        }
    }

    private static void createOutput(String combo, int[] letterCount) {
        int[] output = new int[26];
        for (int i = 0; i < letterCount.length; i++) {
            output[combo.charAt(i) - 97] += letterCount[i];
        }
        print(output);
    }

    private static void print(int[] output) {
        for (int i = 0; i < output.length - 1; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println(output[output.length - 1]);
    }
}
