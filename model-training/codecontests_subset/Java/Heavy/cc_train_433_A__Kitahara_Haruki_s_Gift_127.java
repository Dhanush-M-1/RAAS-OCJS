import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        int counter100 = 0;
        int counter200 = 0;
        for(int i = 0; i < n; i++) {
            int k = input.nextInt();
            a[i] = k;
            if(k == 100)
                counter100++;
            else
                counter200++;
        }
        if(balance(a, counter100, counter200)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

        /*
        //System.out.println(counter100);
        //System.out.println(counter200);
        while(counter200 > 0 && counter100 >= 2) {
            counter200--;
            counter100 -= 2;
        }
        //System.out.println(counter100);
        //System.out.println(counter200);

        if(counter100 == 0 && counter200 == 0) {
            System.out.println("YES");
        }
        else if(counter100 == 0 && counter200 % 2 == 0)
            System.out.println("YES");
        else if(counter200 == 0 && counter100 % 2 == 0)
            System.out.println("YES");
        else
            System.out.println("NO"); */
    }

    public static boolean balance(int[] S, int count100, int count200) {
        int n = S.length;
        int N = count100 * 100 + count200 * 200;
        boolean[][] abc = new boolean[N / 2 + 1][n + 1];
        for(int i = 0; i < n + 1; i++) {
            abc[0][i] = true;
        }
        for(int i = 1; i < N / 2 + 1; i++)
            abc[i][0] = false;
        for(int i = 1; i <= N / 2; i++) {
            for(int j = 1; j <= n; j++) {
                abc[i][j] = abc[i][j - 1];
                if(i >= S[j - 1])
                    abc[i][j] = abc[i][j] || abc[i - S[j - 1]][j - 1];
            }
        }   
        return abc[N / 2][n];
    }
}
