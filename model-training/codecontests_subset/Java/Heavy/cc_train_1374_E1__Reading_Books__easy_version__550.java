import java.util.*;
import java.io.*;

public class E653 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt(); int k = sc.nextInt();
        Book [] books = new Book[n];
        for (int i = 0; i < n; i++) {
            books[i] = new Book(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        ArrayList<Book> both = new ArrayList<>();
        ArrayList<Book> a = new ArrayList<>();
        ArrayList<Book> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (books[i].a == 1 && books[i].b == 0) a.add(books[i]);
            else if (books[i].a == 1 && books[i].b == 1) both.add(books[i]);
            else if (books[i].a == 0 && books[i].b == 1) b.add(books[i]);
        }
        Collections.sort(both); Collections.sort(a); Collections.sort(b);
        long [] pref1 = new long[both.size() + 1];
        long [] pref2 = new long[a.size() + 1];
        long [] pref3 = new long[b.size() + 1];
        for (int i = 1; i <= both.size(); i++) pref1[i] = pref1[i-1] + both.get(i - 1).t;
        for (int i = 1; i <= a.size(); i++) pref2[i] = pref2[i-1] + a.get(i - 1).t;
        for (int i = 1; i <= b.size(); i++) pref3[i] = pref3[i-1] + b.get(i - 1).t;
        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= Math.min(both.size(), k); i++) {
            int need = k - i;
            if (need > a.size() || need > b.size()) continue;
            ans = Math.min(ans, pref1[i] + pref2[need] + pref3[need]);
        }
        out.println(ans == Long.MAX_VALUE ? -1 : ans);
        out.close();
    }

    static class Book implements Comparable<Book> {
        int t; int a; int b;
        Book(int t, int a, int b) {
            this.a = a; this.b = b; this.t = t;
        }

        @Override
        public int compareTo(Book o) {
            return t - o.t;
        }
    }


    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }


    }

}