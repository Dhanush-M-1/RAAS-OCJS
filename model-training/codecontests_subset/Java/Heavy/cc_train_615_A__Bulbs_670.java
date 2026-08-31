import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bulbs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        Set<Integer> distinct = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] bulbs = br.readLine().split(" ");
            for (int j = 1; j < bulbs.length; ++j) {
                Integer e = Integer.valueOf(bulbs[j]);
                distinct.add(e);
            }

        }
        if (distinct.size() != m) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
