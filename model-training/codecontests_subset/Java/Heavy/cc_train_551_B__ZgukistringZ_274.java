import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rustam on 6/1/2015.
 */
public class Main {

    static FastScanner sc = null;

    public static void init() {
        sc = new FastScanner(System.in);
    }


    static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isUnique(String str) {
        boolean [] digitSet = new boolean[100];
        Arrays.fill(digitSet, false);

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - '0';
            if (digitSet[index]) {
                return false;
            }
            digitSet[index] = true;
        }
        return true;
    }

    public static char intToChar(int number) {
        if (number < 10) {
            char c = (char) (number + '0');
            return c;
        }
        else {
            number -= 10;
            char c = (char) (number + 'A');
            return c;
        }
    }

    public static int countUnique(String s) {
        boolean [] charSet = new boolean[100];
        for (int i = 0; i < s.length(); i++) {
            charSet[s.charAt(i)] = true;
        }

        int counter = 0;
        for (int i = 0; i < charSet.length; i++) {
            if (charSet[i]) {
                counter++;
            }
        }
        return counter;
    }

    public static boolean isPalindrom(String s) {
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }

    public static String encode(String str, int step) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char q = str.charAt(i);
            q = (char) (q + step);
            if (q > 'Z') {
                q = (char) (q - 'Z' + 'A' - 1);
            }
            sb.append(q);
        }
        return sb.toString();
    }

    public static String notationChange(int n, int d) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int a = n % d;
            n /= d;
            char q = intToChar(a);
            sb.insert(0, String.valueOf(q));
        }
        return sb.toString();
    }

    public static int numberSquare(int number) {
        int sum = 0;
        while (number != 0) {
            sum += (number % 10);
            number /= 10;
        }

        if (sum > 9) return numberSquare(sum);
        else return sum;

    }

    public static BigInteger numberSquareBig(BigInteger number) {
        BigInteger sum = new BigInteger("0");
        BigInteger ten = new BigInteger("10");
        BigInteger nine = new BigInteger("9");
        while (!number.equals(new BigInteger("0"))) {
            BigInteger temp = number.mod(ten);
            sum = sum.add(temp);
            number = number.divide(ten);
        }

        if (sum.compareTo(nine) > 0) return numberSquareBig(sum);
        else return sum;
    }

    public static int reverseNumber(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n)).reverse();
        int ans = Integer.parseInt(sb.toString());
        return ans;
    }

    public static long sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static long mult(int n) {
        int mult = 1;
        while (n > 0) {
            mult *= (n % 10);
            n /= 10;
        }
        return mult;
    }

    public static boolean isSumMult(int n) {
        long mult = 1;
        long sum = 0;
        while (n > 0) {
            sum += (n % 10);
            mult *= (n % 10);
            n /= 10;
        }
        return sum == mult;
    }

    public static void showArray(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static void showArray(int [][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int [] reverseArray(int [] arr) {
        int [] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[arr.length - i - 1];
        }
        return ans;
    }



    public static void main(String [] args) {
        init();

        String a = sc.next();
        String b = sc.next();
        String c = sc.next();
        int [] A = new int[26];
        int [] B = new int[26];
        int [] C = new int[26];
        for (char x : a.toCharArray()) A[x-'a']++;
        for (char x : b.toCharArray()) B[x-'a']++;
        for (char x : c.toCharArray()) C[x-'a']++;
        int max = 0;
        int maxB = (a.length()/b.length()) +1;
        int [] count = {0,0};
        for (int i=0;i<maxB;i++) {
            boolean is = true;
            for (int j=0;j<B.length;j++) {
                if ( (A[j] - i*B[j]) < 0) {
                    is = false;
                    break;
                }
            }
            if (!is) break;
            int minC = can(A,B,C,i);
            //System.out.println(i +" "+minC);
            if (max < i+minC) {
                max  = i +minC;
                count[0] = i;
                count[1] = minC;
            }
        }
        //System.out.println(count[0] +" "+count[1]);
        for (int i=0;i<count[0];i++) System.out.print(b);
        for (int i=0;i<count[1];i++) System.out.print(c);
        for (int i=0;i<A.length;i++) {
            A[i] -= (count[0]*B[i]+count[1]*C[i]);
            for (int j=0;j<A[i];j++) System.out.print((char)( i+'a'));
        }
    }

    static int can( int [] a, int [] b, int [] c, int t) {
        int minC  = Integer.MAX_VALUE;
        for (int i=0;i<c.length;i++) {
            if (c[i] == 0) continue;
            minC = Math.min(minC,((a[i]-t*b[i])/c[i]) );
        }
        if (minC < 0 || minC == Integer.MAX_VALUE) minC = 0;
        return minC;

    }

}




class FastScanner {
    private StringTokenizer tokenizer;
    private BufferedReader reader;

    public FastScanner(InputStream inputStream) {
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = null;
            try {
                line = reader.readLine();
            } catch (IOException e) {
            }
            if (line == null)
                return null;
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}
