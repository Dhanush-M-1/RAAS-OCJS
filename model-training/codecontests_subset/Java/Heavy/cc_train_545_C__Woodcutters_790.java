import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class TestClass {

    public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList <Pair<Integer, Integer>> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt(), b = in.nextInt();
            v.add(new Pair<Integer, Integer>(a, b));
        }
        ArrayList <Integer> side = new ArrayList<>(n);
        for (int i = 0; i < n; i++) side.add(0);
        int ans = Math.min(2, n);
        side.set(0, -1);
        for (int i = 1; i < n - 1; i++) {
            int h1 = v.get(i).getKey() - v.get(i).getValue(),
                h2 = v.get(i).getKey() + v.get(i).getValue();
            if (side.get(i - 1) == -1) {
                if (h1 > v.get(i - 1).getKey()) {
                    side.set(i, -1);
                    ans++;
                } else if (h2 < v.get(i + 1).getKey()) {
                    side.set(i, 1);
                    ans++;
                } else {
                    side.set(i, 0);
                }
            } else if (side.get(i - 1) == 0) {
                if (h1 > v.get(i - 1).getKey()) {
                    side.set(i, -1);
                    ans++;
                } else if (h2 < v.get(i + 1).getKey()) {
                    side.set(i, 1);
                    ans++;
                } else {
                    side.set(i, 0);
                }
            } else if (side.get(i - 1) == 1) {
                if (h1 > v.get(i - 1).getKey() + v.get(i - 1).getValue()) {
                    side.set(i, -1);
                    ans++;
                } else if (h2 < v.get(i + 1).getKey()) {
                    side.set(i, 1);
                    ans++;
                } else {
                    side.set(i, 0);
                }
            }

        }
        System.out.println(ans);
    }



}
