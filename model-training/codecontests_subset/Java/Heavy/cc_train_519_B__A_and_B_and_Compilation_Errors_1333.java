
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CF_rnd294B {
    Scanner in = new Scanner(System.in);

    private CF_rnd294B() throws IOException {
        //in.nextLine();
        int n = in.nextInt();
        int[] arr0 = ns(n);
        int[] arr1 = ns(n - 1);
        int[] arr2 = ns(n - 2);
        Arrays.sort(arr0);
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int res1 = hp(arr0, arr1);
        int res2 = hp(arr1, arr2);
        out(res1);
        out(res2);
    }   
    private int hp(int[] arr1, int[] arr2) {
        int n = arr1.length;
        for(int i = 0; i < n - 1; i++) {
            if(arr1[i] == arr2[i])
                continue;
            else
                return arr1[i];
        }
        return arr1[n - 1];
    }
    
    private int[] ns(int n) {
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = in.nextInt();
        }
        return res;
    }
    private int[][] getMat(int m, int n) {//m rows and n cols
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                res[i][j] = in.nextInt();
        return res;
    }
    private static void out(Object x) {
        System.out.println(x);
    }
    public static void main(String[] args) throws IOException {
        new CF_rnd294B();
    }
}
