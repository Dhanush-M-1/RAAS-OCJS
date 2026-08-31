//package TIM2;


import java.io.*;
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int c = input.nextInt();
        int v0 = input.nextInt();
        int v1 = input.nextInt();
        int a = input.nextInt();
        int l = input.nextInt();
        int ans = 0;
        while (true) {
            ans++;
            c -= v0;
            if (c <= 0) break;
            v0 += a;
            if (v0 > v1) v0 = v1;
            c += l;
        }
        System.out.println(ans);
    }
}
