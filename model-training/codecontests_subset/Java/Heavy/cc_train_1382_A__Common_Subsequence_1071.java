import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class A {
    static HashMap<Long, Long> combos = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = System.out;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            br.readLine().split(" ");
            String[] arr = br.readLine().split(" ");
            HashSet<Integer> a = new HashSet<>();
            for (int x = 0; x < arr.length; x++) a.add(Integer.parseInt(arr[x]));
            arr = br.readLine().split(" ");
            boolean works = false;
            for (String x : arr) {
                if (a.contains(Integer.parseInt(x))) {
                    out.println("YES");
                    out.println("1 " + x);
                    works = true;
                    break;
                }
            }
            if (!works) out.println("NO");

        }



        System.out.flush();
    }
}