
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

/**
 * Codeforces
 * 
 * 
 */
public class Codeforcess {

    public static boolean has1inbetween(String s, int i, int j) {
        boolean ans = true;
        char ch[] = s.toCharArray();

        for (int b = i + 1; b < j && b < s.length() && i < ch.length && j < ch.length; b++) {
            if (ch[i] == '1') {
                ans = false;
            }
        }
        return ans;
    }

    public static int segregate(int arr[], int size) {
        int j = 0, i;
        for (i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment count of non-positive
                // integers
                j++;
            }
        }

        return j;
    }

    public static long lowComMultiple(long a, long b) {
        long min = a * b;
        long start = Math.min(a, b);
        long ans = -1;
        for (int i = (int) start; i <= min; i++) {
            if (i % a == 0 && i % b == 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static int solution(int[] A) {
        int n = A.length;

        // To mark the occurrence of elements
        boolean[] present = new boolean[n + 1];

        // Mark the occurrences
        for (int i = 0; i < n; i++) {

            if (A[i] > 0 && A[i] <= n)
                present[A[i]] = true;
        }

        // Find the first element which didn't
        // appear in the original array
        for (int i = 1; i <= n; i++)
            if (!present[i])
                return i;

        return n + 1;
    }

    public static ArrayList<Long> digit(long num) {
        long dig = 0;
        // long length = 0;
        ArrayList<Long> digi = new ArrayList<>();
        while (num > 0) {
            dig = num % 10;
            digi.add(dig);
            num = num / 10;

        }
        // return dig; //System.out.printf("%d", +revnum);

        return digi;
    }

    static int[] shuffle(int a[], int n) {
        for (int i = 0; i < n; i++) {

            // getting the random index
            int t = (int) Math.random() * a.length;

            // and swapping values a random index
            // with the current index
            int x = a[t];
            a[t] = a[i];
            a[i] = x;
        }
        return a;
    }

    public void dump() {

    }

    public static long addDigits(long num) {
        long digit = 0;
        // long sum = 0;
        long dig = -1;

        while (num != 0) {
            digit = num % 10;
            dig = digit;
            num = num / 10;
            break;
        }
        return dig;
    }

    public static int addDigit(long num) {
        long digit = 0;
        // long sum = 0;
        int count = 0;

        while (num != 0) {
            digit = num % 10;
            count++;
            num = num / 10;

        }
        return count;
    }

    public static class Pair<A, B> {
        private A first;
        private B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }

        public void setFirst(A first) {
            this.first = first;
        }

        public void setSecond(B second) {
            this.second = second;
        }
    }

    public static void main(String[] args) {

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while (T-- > 0) {
                int n = sc.nextInt();
                sc.nextLine();
                char[][] box = new char[n][n];
                for (int i = 0; i < n; i++) {
                    String row = sc.next();
                    char[] r = row.toCharArray();
                    box[i] = r;
                }

                int a = box[0][1];
                int b = box[1][0];
                int c = box[n - 1][n - 2];
                int d = box[n - 2][n - 1];

                Pair<Integer, Integer> p = new Pair<Integer, Integer>(0, 0);
                ArrayList<Pair<Integer, Integer>> ar = new ArrayList<>();

                if (a == b) {
                    if (c == a) {
                        p.setFirst(n);
                        p.setSecond(n - 1);
                        ar.add(p);
                    }
                    p = new Pair<Integer, Integer>(0, 0);
                    if (a == d) {
                        p.setFirst(n - 1);
                        p.setSecond(n);
                        ar.add(p);
                    }

                } else if (c == d) {
                    if (c == a) {
                        p.setFirst(1);
                        p.setSecond(2);
                        ar.add(p);
                    }
                    p = new Pair<Integer, Integer>(0, 0);
                    if (c == b) {
                        p.setFirst(2);
                        p.setSecond(1);
                        ar.add(p);
                    }
                } else {
                    p = new Pair<Integer, Integer>(0, 0);
                    p.setFirst(2);
                    p.setSecond(1);
                    ar.add(p);
                    p = new Pair<Integer, Integer>(0, 0);
                    if (c == a) {
                        p.setFirst(n);
                        p.setSecond(n - 1);
                        ar.add(p);
                    }
                    p = new Pair<Integer, Integer>(0, 0);
                    if (d == a) {
                        p.setFirst(n - 1);
                        p.setSecond(n);
                        ar.add(p);
                    }
                }
                System.out.println(ar.size());
                for (int i = 0; i < ar.size(); i++) {
                    System.out.println(ar.get(i).getFirst() + " " + ar.get(i).getSecond());
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}