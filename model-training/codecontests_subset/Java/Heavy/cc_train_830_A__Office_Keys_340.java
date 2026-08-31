import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Fuad
 */
//1 4 5 6
public class Codeforces {

    static class pair<T1, T2> implements Comparator {

        T1 first;
        T2 second;

        pair(T1 f, T2 s) {
            first = f;
            second = s;
        }

        pair() {

        }

        @Override
        public int compare(Object o1, Object o2) {
            pair<Integer, Integer> p1 = (pair) o1;
            pair<Integer, Integer> p2 = (pair) o2;

            if (p1.first < p2.first) {
                return -1;
            } else if (p2.first < p1.first) {
                return 1;
            } else {
                return p1.second <= p2.second ? -1 : 1;
            }
        }

    }

    static int h[], ky[];
    static int k, n, p;

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> assi = new HashMap();

        String arr[] = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        k = Integer.parseInt(arr[1]);
        p = Integer.parseInt(arr[2]);

        h = new int[n];
        ky = new int[k];

        arr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {

            h[i] = Integer.parseInt(arr[i]);
        }

        arr = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            ky[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(ky);
        Arrays.sort(h);

        int mint = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            if (i + h.length > ky.length) {
                break;
            }
            int lmax = Integer.MIN_VALUE;
            int currk = i;
            for (int j = 0; j < h.length; j++) {
                lmax = Math.max(lmax, Math.abs(h[j] - ky[currk]) + Math.abs(p - ky[currk]));
                currk++;
            }

            mint = Math.min(lmax, mint);
        }

        System.out.println(mint);

    }

    public static int t(int i, int j) {
        return Math.abs(h[i] - ky[j]) + Math.abs(p - ky[j]);
    }

}
