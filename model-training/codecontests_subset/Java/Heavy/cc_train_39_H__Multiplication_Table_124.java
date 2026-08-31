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
            for (int j = 0; j < k - 1; j++) {
                a[i][j] = (j + 1) * (i + 1);
                System.out.print(func(a[i][j], k) + " ");
            }
            System.out.println();
        }

        out.close();
    }

    int func(int ch, int osn) {
        String s = "";
        while (ch >= osn) {
            s += ch % osn;
            ch = ch / osn;
        }
        s += ch;
        String ans = new StringBuilder(s).reverse().toString();
        return Integer.parseInt(ans);
    }
}