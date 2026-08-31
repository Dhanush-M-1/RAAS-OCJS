import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Rebus {

    public static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }

    public static class Elem {
        boolean isPositive;
        int value;

        public Elem(boolean b) {
            isPositive = b;
            value = 1;
        }
    }

    private static boolean hasSolution(int sum, Elem current, int pos, int neg, int n, int value) {
        int mul = (current.isPositive)? 1: -1;
        int min = sum + mul * value + pos - n * neg;
        int max = sum + mul * value + n * pos - neg;
//        System.out.println(value + "::" + min + ", " + max + "(pos: " + pos);
        return min <= n && n <= max;
    }

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        LinkedList<Elem> list = new LinkedList<>();
        int number = 0;;
        int pos, neg;
        pos = 1;
        neg = 0;
        boolean isPositive = true;
        for (char c: input.toCharArray()) {
            if (c == '?') {
                list.add(new Elem(isPositive));
            }
            if (c == '-') {
                neg++;
                isPositive = false;
            }
            if (c == '+') {
                pos++;
                isPositive = true;
            }
            if (c >= '0' && c <= '9') {
                number = (c - '0') + 10 * number;
            }
        }

        if (!hasSolution(0, list.get(0), pos, neg, number, 0)) {
            System.out.println("Impossible");
        }
        else {
            System.out.println("Possible");
            int sum = 0;
            for (Elem l : list) {
                int last = 1;
                if (l.isPositive) {
                    pos--;
                }
                else {
                    neg--;
                }
                for (int i = 1; i <= number; ++i) {
                    if (hasSolution(sum, l, pos, neg, number, i)) {
                        last = i;
                        break;
                    }
                }


                sum += (l.isPositive)? last: -last;
                l.value = last;
            }

            boolean firstTime = true;
            int summy = 0;
            for (Elem l: list) {
                summy += (l.isPositive)? l.value: -l.value;
                if (firstTime) {
                    System.out.print(l.value + " ");
                    firstTime = false;
                    continue;
                }
                System.out.print((l.isPositive? "+": "-") + " " + l.value + " ");
            }
            System.out.println(" = " + number);
//            System.out.println(summy);
        }


    }
}
