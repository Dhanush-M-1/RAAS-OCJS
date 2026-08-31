import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Code {
    public static void main(String[] args) {
        // Use the Scanner class
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] s = new int[m];
        for (int i = 0; i < n; ++i) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < m; ++i) {
            s[i] = sc.nextInt();
        }

        System.out.println(f(w,s,n,m));

    }

    static int f(int[] w, int[] seq, int n, int m) {
        Set<Integer> visited = new HashSet<>();
        Stack<Book> S = new Stack<>();
        for (int i = 0; i < m; ++i) {
            int cur_book_idx = seq[i] - 1;
            if (!visited.contains(cur_book_idx)) {
                S.push(new Book(cur_book_idx, w[cur_book_idx]));
                visited.add(cur_book_idx);
            }
        }

        Queue<Book> q = new LinkedList<>();
        while (!S.isEmpty()) {
            q.add(S.pop());
        }

        while (!q.isEmpty()) {
            S.add(q.poll());
        }
        int WEIGHT = 0;

        for (int i = 0 ; i < m; ++i) {
            int target_book = seq[i] - 1;
            Stack<Book> temp = new Stack<>();
            Book target = null;
            do {
                target = S.pop();
                temp.push(target);
            }
            while(target.id != target_book);
            target = temp.pop();
            while(!temp.isEmpty()) {
                Book cur = temp.pop();
                WEIGHT += cur.weight;
                S.push(cur);
            }
            S.push(target);
        }


        return WEIGHT;
    }

    public static class Book {
        int id;
        int weight;

        public Book(int id, int w) {
            this.id = id;
            this.weight = w;

        }
    }


}