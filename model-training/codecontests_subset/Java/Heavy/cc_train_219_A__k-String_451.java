
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class kString {
    private static String solve(int n, String s, int k) {
        int ch[] = new int[26];

        for (int i = 0; i < n; i++) {
            ch[s.charAt(i) - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int x = 0; x < 26; x++) {
            if (ch[x] % k != 0)
                return -1 + "";

        }
        int freq[] = ch.clone();
        Arrays.sort(freq);
        int pos = Arrays.binarySearch(freq, 0);
        min = (pos < 0) ? ~pos : getUb(pos, freq);
        min = freq[min];


        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 26; i = (i + 1) % 26) {
            char c = (char) (i + 97);

            String repeat = ("" + c).repeat((ch[i] / k));
            ans.append(repeat);

            if (ans.toString().length() == n)
                break;

        }
        return ans.toString();
    }

    private static int getUb(int pos, int[] a) {
        while (pos + 1 < a.length && a[pos] == a[pos + 1]) pos++;
        return pos + 1;

    }

    public static void main(String[] args)
            throws IOException {
        Scanner s = new Scanner(System.in);
        int t = 1;
//        t = s.nextInt();
        StringBuilder ans = new StringBuilder();
        int count = 0;
        while (t-- > 0) {
            int k = s.nextInt();
            s.nextLine();
            String str = s.nextLine();
            ans.append(solve(str.length(), str, k)).append("\n");
        }
        System.out.println(ans.toString());
    }


    public static long norm(long a, long MOD) {
        return ((a % MOD) + MOD) % MOD;
    }

    public static long msub(long a, long b, long MOD) {
        return norm(norm(a, MOD) - norm(b, MOD), MOD);

    }

    public static long madd(long a, long b, long MOD) {
        return norm(norm(a, MOD) + norm(b, MOD), MOD);

    }

    public static long mMul(long a, long b, long MOD) {
        return norm(norm(a, MOD) * norm(b, MOD), MOD);


    }

    public static long mDiv(long a, long b, long MOD) {
        return norm(norm(a, MOD) / norm(b, MOD), MOD);
    }

    public static String formattedArray(int a[]) {
        StringBuilder res = new StringBuilder("");
        for (int e : a)
            res.append(e).append(" ");
        return res.toString().trim();

    }

}
