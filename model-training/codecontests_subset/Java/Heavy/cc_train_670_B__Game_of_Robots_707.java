import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int[] di = {0, -1, 0, 1};
    static int[] dj = {-1, 0, 1, 0};

    static int[] di_knight = {-1, -1, -2, -2, 1, 1, 2, 2};
    static int[] dj_knight = {2, -2, -1, 1, 2, -2, -1, 1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int num = 1, row = 1, jump = 0;
        while (num <= k) {
            num += ++jump;
            row++;
        }
        row--;

        while (jump > 0) {
            k -= --jump;
        }

        System.out.println(arr[k - 1]);
    }

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
}
