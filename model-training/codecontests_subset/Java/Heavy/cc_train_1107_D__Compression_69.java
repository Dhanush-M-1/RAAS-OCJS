import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.StrictMath.max;

public class Main {
    public static void main(String[] args) throws IOException {

        PrintWriter out = new PrintWriter(System.out);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        int n = parseInt(in.readLine());

        int[][] А = new int[n][n];

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int j = 0;
            for (char c : in.readLine().toCharArray()) {

                int z = Character.digit(c, 16);
                String s = Integer.toBinaryString(z);
                StringBuilder stringBuilder1 = new StringBuilder(s);

                if (s.length() == 3) {
                    stringBuilder1.insert(0, "0");
                } else if (s.length() == 2) {
                    stringBuilder1.insert(0, "00");
                } else if (s.length() == 1) {
                    stringBuilder1.insert(0, "000");
                }

                for (char ch : stringBuilder1.toString().toCharArray()) {
                    А[i][j] = Character.digit(ch, 10);
                    j++;
                }
            }
        }

        boolean may[] = new boolean[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (А[i][j] != А[i - 1][j] || А[j][i] != А[j][i - 1]) {
                    may[i] = true;
                }
            }
        }
        int ans = n;
        for (int i = 1; i < n; i++) {
            if (may[i]) {
                ans = gcd(ans, i);
            }
        }
        System.out.println(ans);

    }


        public static int gcd(int a,int b) {
            while (b !=0) {
                int tmp = a%b;
                a = b;
                b = tmp;
            }
            return a;
        }

}