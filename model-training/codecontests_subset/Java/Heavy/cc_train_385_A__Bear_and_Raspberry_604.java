import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Solve s = new Solve();
    }

}

class Solve {
    Scanner in = new Scanner(System.in);

    public Solve() {
        solve();
    }

    void solve() {
        int n = NI();
        int c = NI();
        int x[] = new int [n];
        int diff = 0, t = 0;
        for (int i = 0; i < n; i++) {
            x[i] = NI();
            if (i > 0) {
                if (x[i - 1] - x[i] > diff) {
                    diff = x[i - 1] - x[i];
                    t = i - 1;
                }
            }
        }
        System.out.println((x[t] - c - x[t + 1]) < 0 ? 0 : x[t] - c - x[t + 1]);
    }

    int min(int i1, int i2)  {
        return i1 < i2 ? i1 : i2;
    }

    int max(int i1, int i2) {
        return i1 > i2 ? i1 : i2;
    }

    int NI() {
        return in.nextInt();
    }

    String NS() {
        return in.nextLine();
    }
}

class Node {
    int lBr = 0, rBr = 0, maxBr = 0, iN, l, r;

}
