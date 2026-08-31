import java.math.*;
import java.util.*;
public class Main {
    public static int n;
    public static ArrayList<String>[] arr;
    public static BigInteger MOD = new BigInteger("998244353");
    public static BigInteger TEN = BigInteger.TEN;
    public static BigInteger calc(int a, int b) {
        if (arr[a].size() == 0 || arr[b].size() == 0) {
            return BigInteger.ZERO;
        }
        if (a == b) {
            int[] sum = new int[a];
            for (int i = 0; i < a; i++) {
                for (String s : arr[a]) {
                    sum[i] += (s.charAt(i) - '0');
                }
            }
            BigInteger res = BigInteger.ZERO;
            int co = 0;
            for (int i = sum.length - 1; i >= 0; i--) {
                res = res.add(new BigInteger(sum[i] + "").multiply(new BigInteger(arr[a].size() + "")).multiply(TEN.pow(co++)));
                res = res.add(new BigInteger(sum[i] + "").multiply(new BigInteger(arr[a].size() + "")).multiply(TEN.pow(co++)));
            }
            return res;
        } else {
            int[] aSum = new int[a];
            int[] bSum = new int[b];
            for (int i = 0; i < a; i++) {
                for (String s : arr[a]) {
                    aSum[i] += (s.charAt(i) - '0');
                }
            }
            for (int i = 0; i < b; i++) {
                for (String s : arr[b]) {
                    bSum[i] += (s.charAt(i) - '0');
                }
            }
            BigInteger res = BigInteger.ZERO;
            int co = 0;
            if (a < b) {
                for (int i = b - 1, j = a - 1; i >= 0 && j >= 0; i--, j--) {
                    res = res.add(new BigInteger(bSum[i] + "").multiply(new BigInteger(arr[a].size() + "")).multiply(TEN.pow(co++)));
                    res = res.add(new BigInteger(aSum[j] + "").multiply(new BigInteger(arr[b].size() + "")).multiply(TEN.pow(co++)));
                }
                for (int i = b - a - 1; i >= 0; i--) {
                    res = res.add(new BigInteger(bSum[i] + "").multiply(new BigInteger(arr[a].size() + "")).multiply(TEN.pow(co++)));
                }
            } else {
                for (int i = a - 1, j = b - 1; i >= 0 && j >= 0; i--, j--) {
                    res = res.add(new BigInteger(bSum[j] + "").multiply(new BigInteger(arr[a].size() + "")).multiply(TEN.pow(co++)));
                    res = res.add(new BigInteger(aSum[i] + "").multiply(new BigInteger(arr[b].size() + "")).multiply(TEN.pow(co++)));
                }
                for (int i = a - b - 1; i >= 0; i--) {
                    res = res.add(new BigInteger(aSum[i] + "").multiply(new BigInteger(arr[b].size() + "")).multiply(TEN.pow(co++)));
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new ArrayList[11];
        for (int i = 0; i < 11; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            String s = in.next();
            arr[s.length()].add(s);
        }
        BigInteger res = BigInteger.ZERO;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                res = res.add(calc(i, j));
            }
        }
        System.out.println(res.mod(MOD));
    }
}