import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        PriorityQueue<Integer> pqr = new PriorityQueue<>();
        PriorityQueue<Integer> pql = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pqr.add(sc.nextInt());
        }
        for (int i = 0; i < (n-1) /2; i++) {
            pql.add(pqr.poll());
        }
        long sum = 0;
        int med = pqr.poll();
        if (med < s) {
            sum += (s - med);
            while (!pqr.isEmpty() && pqr.peek() < s) {
                sum += (s - pqr.poll());
            }
        } else if (med > s) {
            sum += (med - s);
            while (!pql.isEmpty() && pql.peek() > s) {
                sum += (pql.poll() - s);
            }
        }
        System.out.println(sum);
    }
}