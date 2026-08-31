import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solveaproblem {
    private static Book[] books;
    private static int a, b, ab, n;
    static class Book implements Comparator<Book> {
        int time, alice, bob;
        Book(int time, int alice, int bob) {
            this.time = time;
            this.alice = alice;
            this.bob = bob;
        }
        Book() {}
        @Override
        public int compare(Book b1, Book b2) {
            return Integer.compare(b1.time, b2.time);
        }
    }
    private static void changetwo() {
        for (a=a+1; a<n; a++) {
            if (books[a].alice==1 && books[a].bob==0) break;
        }
        for (b=b+1; b<n; b++) {
            if (books[b].alice==0 && books[b].bob==1) break;
        }
    }
    private static void changeboth() {
        for (ab=ab+1; ab<n; ab++) {
            if (books[ab].alice==1 && books[ab].bob==1) break;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(sToken.nextToken());
        int k = Integer.parseInt(sToken.nextToken());
        books = new Book[n];
        for (int i=0; i<n; i++) {
            sToken = new StringTokenizer(reader.readLine());
            int t = Integer.parseInt(sToken.nextToken());
            int a = Integer.parseInt(sToken.nextToken());
            int b = Integer.parseInt(sToken.nextToken());
            books[i] = new Book(t, a, b);
        }
        Arrays.sort(books, new Book());
        a = n; b = n; ab = n;
        for (int i=0; i<n; i++) {
            if (a==n && books[i].alice==1 && books[i].bob==0) a = i;
            if (b==n && books[i].alice==0 && books[i].bob==1) b = i;
            if (ab==n && books[i].alice==1 && books[i].bob==1) ab = i;
        }
        long res = 0;
        for (int i=0; i<k; i++) {
            if ((a==n || b==n) && ab==n) {
                System.out.println(-1);
                System.exit(0);
            }
            if (ab==n) {
                res+=books[a].time+books[b].time;
                changetwo();
            } else if ((a==n || b==n)) {
                res+=books[ab].time;
                changeboth();
            } else {
                if (books[ab].time<=books[a].time+books[b].time) {
                    res+=books[ab].time;
                    changeboth();
                } else {
                    res+=books[a].time+books[b].time;
                    changetwo();
                }
            }
        }
        System.out.println(res);
    }
}