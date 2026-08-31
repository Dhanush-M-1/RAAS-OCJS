import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Timur on 16.04.2016.
 */
public class B664 {
    public static void main(String args[]) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();

        int plus = 1;
        int minus = 0;
        int n = 0;

        for (int i = 0;i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                plus ++;
            } else

            if (s.charAt(i) == '-') {
                minus ++;
            } else
            if (s.charAt(i) >= '0' && s.charAt(i)<='9') {
                n = n * 10;
                n += (s.charAt(i) - '0');
            }
        }


        int a[] = new int[plus];
        int b[] = new int[minus];

        for (int i = 0; i < plus; i++) {
            a[i] = 1;
        }

        for (int i = 0; i < minus; i++) {
            b[i] = 1;
        }

        int ost = plus - minus;

        int j = 0;

        while (ost < n && j < plus && a[j] < n) {

            a[j]++;
            ost++;
            if (a[j] == n) {
                j++;
            }
        }

        while (ost > n && j < minus && b[j] < n) {
            b[j]++;
            ost--;
            if (b[j] == n) {
                j++;
            }
        }

        if (ost != n) {
            System.out.println("Impossible");
        } else {
            System.out.println("Possible");
            System.out.print(a[0]);
            int c1 = 1;
            int c2 = 0;
            for (int i =1; i<s.length();i++) {
                if (s.charAt(i) == '?') {
                    if (s.charAt(i - 2) == '+') {
                        System.out.print(a[c1++]);
                    } else {
                        System.out.print(b[c2++]);
                    }
                } else System.out.print(s.charAt(i));
            }
            System.out.println();
        }

        in.close();
    }
}
