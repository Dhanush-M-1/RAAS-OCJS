import java.io.*;
import java.lang.*;
import java.util.*;
import javafx.util.Pair;

public class NewMain1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        ArrayList<Pair<Integer,Integer>> pair = new ArrayList<>();
//        ArrayList<Character> car = new ArrayList<Character>();
        ArrayList<Integer> iar = new ArrayList<Integer>();
        int n = sc.nextInt();
        int ar1[] = new int[n];
        int ar2[] = new int[n];
        for (int i = 0; i < n; i++) {
            ar1[i] = sc.nextInt();
            ar2[i] = sc.nextInt();
        }
        int p = -1;
        int c = 0;
        for (int i = 0; i < n * n; i++) {
            if (i % n == 0) {
                p++;
            }
            if (ar1[p] == ar2[i % n]) {
                c++;
            }
        }
        System.out.println(c);
    }
}
