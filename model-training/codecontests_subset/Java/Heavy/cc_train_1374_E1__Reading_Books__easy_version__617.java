import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ReadingBooksEasy {
    static FastScanner fs = new FastScanner();

    static PriorityQueue<Book> pqA, pqB;
    public static void main(String[] args) {
        pqA = new PriorityQueue<>(Comparator.reverseOrder());
        pqB = new PriorityQueue<>(Comparator.reverseOrder());
        int n = fs.nextInt(), k = fs.nextInt();

        Book[] books = new Book[n];
        for (int i=0; i<n; i++) books[i] = new Book(fs.nextInt(), fs.nextInt(), fs.nextInt());
        Arrays.sort(books);

        long totalTime = 0;
        int aHave = 0, bHave = 0;

        for (Book book : books) {
            int time = book.time;
            boolean a = book.a;
            boolean b = book.b;

            if (!a && !b) continue;
            if (a && b) {
                if (aHave < k || bHave < k) {
                    totalTime += time;
                    aHave++;
                    bHave++;
                    if (aHave > k && !pqA.isEmpty()) {
                        totalTime -= pqA.remove().time;
                        aHave--;
                    }else if (bHave > k && !pqB.isEmpty()) {
                        totalTime -= pqB.remove().time;
                        bHave--;
                    }
                } else if (!pqA.isEmpty() && !pqB.isEmpty()) {
                    int bonus = pqA.peek().time + pqB.peek().time;
                    if (time < bonus) {
                        pqA.remove();
                        pqB.remove();
                        totalTime -= bonus;
                        totalTime += time;
                    }
                }
            } else if (a) {
                if (aHave < k) {
                    totalTime += time;
                    aHave++;
                    pqA.add(book);
                }
            } else {
                if (bHave < k) {
                    totalTime += time;
                    bHave++;
                    pqB.add(book);
                }
            }
        }

        if (aHave < k || bHave < k) {
            System.out.println("-1");
        } else {
            System.out.println(totalTime);
        }
    }

    static class Book implements Comparable<Book> {
        int time;
        boolean a, b;
        public Book(int time, int a, int b) {
            this.time = time;
            this.a = a == 1;
            this.b = b == 1;
        }

        public int compareTo(Book o) {
            return Integer.compare(time, o.time);
        }
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}