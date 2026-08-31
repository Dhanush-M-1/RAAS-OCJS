import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int p = sc.nextInt();
        int ans = (int) (Math.ceil(n * p * 0.01) - w);

        System.out.println((ans < 0) ? 0 : ans);
    }
}