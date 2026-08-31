// https://codeforces.com/problemset/problem/805/A
import java.util.Scanner;

public class p {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        if (l == r) {
            System.out.println(l);
        } else {
            System.out.println(2);
        }
        sc.close();
    }    
}
