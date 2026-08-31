import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); //整数の数
    int[] x = new int[n];
    for (int i=0; i<n; i++) {
        x[i] = sc.nextInt();
    }
    int count = 0; //素数の数
    for (int a:x) {
        if(prime(a)) count++;
    }
    System.out.println(count); //最大公約数を出力
    }

    /**
     * 素数判定
     */
     public static boolean prime(int x) {
            for (int i=2; i<=Math.sqrt(x); i++) {
                if (x%i==0) return false;
            }
            return true;
     }
}
