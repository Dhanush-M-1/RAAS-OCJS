import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int[] di = {0, -1, 0, 1};
    static int[] dj = {-1, 0, 1, 0};

    static int[] di_knight = {-1, -1, -2, -2, 1, 1, 2, 2};
    static int[] dj_knight = {2, -2, -1, 1, 2, -2, -1, 1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Integer gcd(Integer a, Integer b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Check if String A is smaller lexicographically than String B
    public static Boolean compareStringLexicographically(String A, String B) {
        if (A == null || B == null)
            return true;

        if (B.indexOf(A) == 0)
            return true;

        for (int i = 0; i < Math.min(A.length(), B.length()); i++) {
            if (A.charAt(i) != B.charAt(i))
                return A.charAt(i) < B.charAt(i);
        }

        return A.length() < B.length();
    }

    // Read Integer
    public static Integer readInt() throws Exception {
        return Integer.parseInt(br.readLine());
    }

    // Read Integer
    public static Integer readInt(String str) throws Exception {
        return Integer.parseInt(str);
    }

    // Read Integer Array
    public static Integer[] readIntArray() throws Exception {
        String[] s = br.readLine().split(" ");
        Integer arr[] = new Integer[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = readInt(s[i]);
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();

        if (l == r) {
            if (isPrime(l)) {
                System.out.println(l);
            } else {
                for (int i = 2; i <= l; i++) {
                    if (l % i == 0) {
                        System.out.println(i);
                        break;
                    }
                }
            }

            return;
        }

        System.out.println(2);
    }

    public static boolean isPrime(int n) {
        boolean prime = true;
        for (int j = 2; j <= Math.sqrt(n); j++) {
            if (n % j == 0) {
                prime = false;
                break;
            }
        }

        return prime;
    }
}
