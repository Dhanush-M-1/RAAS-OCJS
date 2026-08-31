//package codeforces.r624_1311;

import java.util.Arrays;
import java.util.Scanner;

public class C_PerformTheCombo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String word = scanner.next();
            int[] tries = new int[m];
            for (int j = 0; j < m; j++) {
                tries[j] = scanner.nextInt();
            }
            int[] counts = getCounts(n, m, word, tries);
            for (int j = 0; j < 26; j++) {
                System.out.print(counts[j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] getCounts(int n, int m, String word, int[] tries) {
        int[] counts = new int[26];
        for (int i = 0; i < word.length(); i++) {
            counts[word.charAt(i) - 'a']++;
        }
        int[] tryCount = new int[word.length()];
        int[] isTried = new int[n];
        for (int i = 0; i < m; i++) {
            isTried[tries[i]-1]++;
        }
        for (int i = n - 1; i >= 0; i--) {

            tryCount[i] += isTried[i];

            if (i + 1 < n) {
                tryCount[i] += tryCount[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            counts[word.charAt(i) - 'a'] += tryCount[i];
        }
        return counts;
    }
}
