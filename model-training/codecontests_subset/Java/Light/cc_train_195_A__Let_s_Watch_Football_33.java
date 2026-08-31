import java.io.*;
import java.util.*;


public class A {
    public static void main(String[] args) throws Exception {
        new A().solve();
    }
    void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = in.readLine().split(" ");
        int a = Integer.parseInt(sp[0]);
        int b = Integer.parseInt(sp[1]);
        int c = Integer.parseInt(sp[2]);
        if (a <= b) {
            System.out.println(0);
        } else {
            int t = (a * c - 1) / b + 1 - c;
            System.out.println(t);
        }
    }
}
