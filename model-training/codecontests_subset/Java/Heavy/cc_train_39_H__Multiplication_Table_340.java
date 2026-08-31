import java.io.*;
import java.util.*;

/**
 * Created by Dasha on 05.12.2015.
 */
public class Solution {
    Scanner scanner;


    public static void main(String[] args) throws IOException {
        new Solution().run();

    }

    void run() throws IOException {

        scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int k = scanner.nextInt();
        int a[][] = new int[k - 1][k - 1];

        for (int i = 0; i < k - 1; i++) {
            a[i][0] = i + 1;
        }
        for (int j = 1; j < k - 1; j++) {
            a[0][j] = j + 1;
        }

        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < k - 1; j++) {
                a[i][j] = a[0][j] * a[i][0];
                if (k != 10) {
                    System.out.print(func(a[i][j], k) + " ");
                } else
                    System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }


        out.close();

    }

    int func(int ch, int osn) {
        int a = ch;
        int b = 0;
        String s = "";
        while (ch >= osn) {
            s += ch % osn;
            ch = ch / osn;
            b++;
        }
        s += ch;
        String ans = new StringBuilder(s).reverse().toString();
        return Integer.parseInt(ans);
    }
}